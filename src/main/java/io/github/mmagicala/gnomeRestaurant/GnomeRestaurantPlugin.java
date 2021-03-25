/*
 * Copyright (c) 2020, MMagicala <https://github.com/MMagicala>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package io.github.mmagicala.gnomeRestaurant;

import com.google.inject.Provides;
import io.github.mmagicala.gnomeRestaurant.data.OrderRecipients;
import io.github.mmagicala.gnomeRestaurant.data.Recipes;
import java.security.InvalidParameterException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import net.runelite.api.NPC;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ui.overlay.infobox.Timer;

@Slf4j
@PluginDescriptor(
	name = "Gnome Restaurant"
)
public class GnomeRestaurantPlugin extends Plugin
{
	// Gianne jr. dialogue
	private static final Pattern DELIVERY_START_PATTERN = Pattern.compile("([\\w .]+) wants (?:some|a) ([\\w ]+)");
	private static final String EASY_DELIVERY_CANCEL_TEXT = "Fine, your loss. If you want another easy job one come " +
		"back in five minutes and maybe I'll be able to find you one.";
	private static final String HARD_DELIVERY_CANCEL_TEXT = "Fine, your loss. I may have an easier job for you, since" +
		" you chickened out of that one, If you want another hard one come back in five minutes and maybe I'll be" +
		" able to find you a something.";

	@Inject
	private Client client;

	@Inject
	private GnomeRestaurantConfig config;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	// UI

	private Timer timer;
	private Overlay overlay;

	// Flags

	@Inject
	@Named("developerMode")
	boolean developerMode;

	private boolean isDeliveryForTesting = false;
	private boolean isTrackingOrder = false;
	private boolean isDelayed = false;

	// Current order information

	private ArrayList<RecipeStep> recipe;
	private OrderRecipient orderRecipient;

	private int stepNum;

	// Overlay tables hold the ingredients for the recipe
	// We only display the remaining ingredients left

	private final Hashtable<Integer, OverlayTableFraction> stepIngredientsOverlayTable = new Hashtable<>();
	private final Hashtable<Integer, OverlayTableFraction> futureRawIngredientsOverlayTable = new Hashtable<>();

	// Overlay strings

	public static final String OVERLAY_MENU_ENTRY_TEXT = "Reset Stage";

	@Override
	protected void shutDown() throws Exception
	{
		resetPlugin();
	}

	private void resetPlugin()
	{
		removeTimer();
		removeOverlay();
		client.clearHintArrow();
	}

	// Monitor dialogue for Gianne jnr's new order
	@Subscribe
	public void onGameTick(GameTick event)
	{
		boolean isDialogueOpen = client.getWidget(WidgetInfo.DIALOG_NPC_NAME) != null;
		if (!isDialogueOpen)
		{
			return;
		}

		boolean isTalkingToGianneJnr = client.getWidget(WidgetInfo.DIALOG_NPC_NAME).getText().equals("Gianne jnr.");
		if (!isTalkingToGianneJnr)
		{
			return;
		}

		assert(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT) != null);

		String dialog = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT).getText();
		// Treat dialogue as a single line
		dialog = dialog.replace("<br>", " ");
		Matcher matcher = DELIVERY_START_PATTERN.matcher(dialog);

		if (matcher.find() && !isTrackingOrder)
		{
			// Configure plugin
			parseOrder(matcher.group(1), matcher.group(2));
			stepNum = 0;

			setupUI();

			// Set flag
			isTrackingOrder = true;
		}

		boolean playerCancelledOrder = dialog.contains(EASY_DELIVERY_CANCEL_TEXT) ||
			dialog.contains(HARD_DELIVERY_CANCEL_TEXT);
		if (config.showDelayTimer() && !isDelayed && playerCancelledOrder)
		{
			// Show delay timer if player refuses the order
			addDelayTimer();
			isDelayed = true;
		}

		/*
		if (isDeliveryForTesting)
		{
			resetPluginAndTest("Starting real delivery");
		}
		*/
	}

	private void addDelayTimer()
	{
		timer = new Timer(5, ChronoUnit.MINUTES, itemManager.getImage(ItemID.ALUFT_ALOFT_BOX), this);
		timer.setTooltip("Cannot place an order at this time");
		infoBoxManager.addInfoBox(timer);
	}

	private void parseOrder(String addressedName, String recipeName)
	{
		resetPlugin();

		recipe = Recipes.list.get(recipeName);

		if (recipe == null)
		{
			throw new InvalidParameterException("No order found with the name " + recipeName);
		}

		// Get in-game names
		for (OrderRecipient npc: OrderRecipients.list)
		{
			if (npc.addressedName == addressedName)
			{
				orderRecipient = npc;
			}
		}

		if (orderRecipient == null)
		{
			throw new InvalidParameterException("No recipient found with the name " + addressedName);
		}
	}

	private void setupUI()
	{
		if (config.showOverlay())
		{
			buildOverlayTables();

			// Display overlay tables
			overlay = new GnomeRestaurantOverlay(this, stepIngredientsOverlayTable,
				futureRawIngredientsOverlayTable);
			overlayManager.add(overlay);
		}

		if (config.showOrderTimer())
		{
			int numSecondsLeft;

			if (orderRecipient.difficulty == OrderDifficulty.HARD)
			{
				numSecondsLeft = 660;
			}
			else
			{
				numSecondsLeft = 360;
			}

			timer = new Timer(numSecondsLeft, ChronoUnit.SECONDS, itemManager.getImage(Recipes.getFinalProduct(recipe)),
				this);
			String tooltipText = "Deliver " + orderName + " to " + recipientRealName;
			timer.setTooltip(tooltipText);
			infoBoxManager.addInfoBox(timer);
		}

		// Draw hint arrow if we can already identify the NPC

		if (config.showHintArrow())
		{
			markNPCFromCache();
		}
	}

	private void markNPCFromCache()
	{
		NPC[] npcs = client.getCachedNPCs();

		for (NPC npc : npcs)
		{
			if (toggleMarkRecipient(npc, true))
			{
				return;
			}
		}
	}

	private boolean toggleMarkRecipient(NPC npc, boolean mark)
	{
		if (npc == null || npc.getName() == null)
		{
			return false;
		}

		if (npc.getName().equals(recipientRealName))
		{
			if (mark)
			{
				client.setHintArrow(npc);
			}
			else
			{
				client.clearHintArrow();
			}
			return true;
		}
		return false;
	}

	@Subscribe
	public void onNpcSpawned(final NpcSpawned event)
	{
		if (isTrackingOrder && config.showHintArrow())
		{
			toggleMarkRecipient(event.getNpc(), true);
		}
	}

	@Subscribe
	public void onNpcDespawned(final NpcDespawned event)
	{
		if (isTrackingOrder && config.showHintArrow())
		{
			toggleMarkRecipient(event.getNpc(), false);
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		// Ignore varbit changes while we are testing, since it will stay 0

		if (isTrackingOrder && !isDeliveryForTesting && client.getVarbitValue(2478) == 0)
		{
			resetPlugin();
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (overlay != null)
		{
			if (event.getContainerId() != InventoryID.INVENTORY.getId())
			{
				return;
			}

			buildOverlayTables();
		}
	}

	private void buildOverlayTables()
	{
		ArrayList<Ingredient> stepIngredients = recipe.get(stepNum).getIngredients();
		buildOverlayTable(stepIngredients, stepIngredientsOverlayTable);

		ArrayList<Ingredient> futureRawIngredients = Recipes.getFutureRawIngredients(recipe, stepNum);
		buildOverlayTable(futureRawIngredients, futureRawIngredientsOverlayTable);
	}

	private void buildOverlayTable(ArrayList<Ingredient> ingredients,
								   Hashtable<Integer, OverlayTableFraction> overlayTable)
	{
		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		assert(inventory != null);

		for (Ingredient ingredient: ingredients)
		{
			int itemId = ingredient.getItemId();
			int inventoryCount = inventory.count(itemId);
			int expectedCount = ingredient.getCount();

			overlayTable.put(itemId, new OverlayTableFraction(inventoryCount, expectedCount));
		}
	}

	// Overlay methods

	@Subscribe
	public void onOverlayMenuClicked(OverlayMenuClicked event)
	{
		if (event.getEntry().getMenuAction() == MenuAction.RUNELITE_OVERLAY &&
			event.getEntry().getTarget().equals("Gnome Restaurant Overlay") &&
			event.getEntry().getOption().equals(OVERLAY_MENU_ENTRY_TEXT))
		{
			// Reset to beginning stage, then update it again

			currentStageNodeIndex = 0;

			ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
			assert inventory != null;
			buildOverlayTables(inventory, true);
		}
	}

	// Config

	@Provides
	GnomeRestaurantConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GnomeRestaurantConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!config.showDelayTimer())
		{
			removeTimer();
		}

		if (!)
		{
			removeOrderTimer();
		}

		if (!config.showOverlay())
		{
			removeOverlay();
		}

		if (!config.showHintArrow())
		{
			client.clearHintArrow();
		}
		else if (isTrackingOrder)
		{
			// Re-enable hint arrow

			markNPCFromCache();
		}
	}

	// UI cleaning

	private void removeTimer()
	{
		infoBoxManager.removeInfoBox(timer);
		timer = null;
	}

	private void removeOverlay()
	{
		overlayManager.remove(overlay);
		overlay = null;
	}

	// Plugin testing

	@Subscribe
	public void onCommandExecuted(CommandExecuted commandExecuted)
	{
		// Must be in developer mode to send command

		if (!developerMode || !commandExecuted.getCommand().equals("gnome") || commandExecuted.getArguments().length < 1)
		{
			return;
		}

		if (commandExecuted.getArguments()[0].equals("reset"))
		{
			resetPluginAndTest("Reset command called.");
			return;
		}
		else if (isTrackingOrder && !isDeliveryForTesting)
		{
			printTestMessage("Cannot run test when a real order is in progress");
			return;
		}

		String orderName = commandExecuted.getArguments()[0].replace("_", " ");
		String recipientName;

		// Default recipient

		if (commandExecuted.getArguments().length < 2)
		{
			recipientName = "His Royal Highness King Narnode";
		}
		else
		{
			recipientName = commandExecuted.getArguments()[1].replace("_", " ");
		}

		printTestMessage("Test started with arguments: " + orderName + ", " + recipientName);

		try
		{
			isDeliveryForTesting = true;
			parseOrder(recipientName, orderName);
		}
		catch (InvalidParameterException e)
		{
			resetPluginAndTest(e.getMessage());
		}
	}

	/**
	 * Reset plugin and test, and print out the reason
	 */
	private void resetPluginAndTest(String errorMessage)
	{
		resetPlugin();
		isDeliveryForTesting = false;
		printTestMessage("Test cancelled. Reason: " + errorMessage);
	}

	private void printTestMessage(String message)
	{
		chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.GAMEMESSAGE).value(message).build());
	}
}
