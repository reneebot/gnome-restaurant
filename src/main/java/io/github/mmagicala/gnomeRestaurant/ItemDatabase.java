package io.github.mmagicala.gnomeRestaurant;

import io.github.mmagicala.gnomeRestaurant.itemOrder.BakedOrder;
import io.github.mmagicala.gnomeRestaurant.itemOrder.BakedToppedOrder;
import io.github.mmagicala.gnomeRestaurant.itemOrder.CocktailOrder;
import io.github.mmagicala.gnomeRestaurant.itemOrder.HeatedCocktailOrder;
import io.github.mmagicala.gnomeRestaurant.itemOrder.ItemOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import net.runelite.api.ItemID;

public class ItemDatabase
{
	public static final Map<String, ItemOrder> orders = Collections.unmodifiableMap(new Hashtable<String, ItemOrder>()
	{
		{
			// Gnomebowls

			put("worm hole",
				new BakedToppedOrder(
					ItemOrderType.GNOMEBOWL,
					ItemID.HALF_MADE_BOWL_9559,
					ItemID.UNFINISHED_BOWL_9560,
					ItemID.WORM_HOLE,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.KING_WORM, 4));
							add(new CookingItem(ItemID.ONION, 2));
							add(new CookingItem(ItemID.GNOME_SPICE, 1));
							add(new CookingItem(ItemID.EQUA_LEAVES, 1, true));
						}
					}
				)
			);
			put("vegetable ball", new BakedToppedOrder(
					ItemOrderType.GNOMEBOWL,
					ItemID.HALF_MADE_BOWL_9561,
					ItemID.UNFINISHED_BOWL_9562,
					ItemID.VEG_BALL,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.POTATO, 2));
							add(new CookingItem(ItemID.ONION, 2));
							add(new CookingItem(ItemID.GNOME_SPICE, 1));
							add(new CookingItem(ItemID.EQUA_LEAVES, 1, true));
						}
					}
				)
			);
			put("tangled toads legs", new BakedOrder(
					ItemOrderType.GNOMEBOWL,
					ItemID.HALF_MADE_BOWL,
					ItemID.TANGLED_TOADS_LEGS,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.TOADS_LEGS, 4));
							add(new CookingItem(ItemID.GNOME_SPICE, 2));
							add(new CookingItem(ItemID.CHEESE, 1));
							add(new CookingItem(ItemID.DWELLBERRIES, 1));
							add(new CookingItem(ItemID.EQUA_LEAVES, 1));
						}
					}
				)
			);
			put("chocolate bomb", new BakedToppedOrder(
					ItemOrderType.GNOMEBOWL,
					ItemID.HALF_MADE_BOWL_9563,
					ItemID.UNFINISHED_BOWL_9564,
					ItemID.CHOCOLATE_BOMB,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.CHOCOLATE_BAR, 4));
							add(new CookingItem(ItemID.EQUA_LEAVES, 2));
							add(new CookingItem(ItemID.CHOCOLATE_DUST, 1, true));
							add(new CookingItem(ItemID.POT_OF_CREAM, 2, true));
						}
					}
				)
			);

			// Battas

			put("fruit batta", new BakedToppedOrder(
					ItemOrderType.BATTA,
					ItemID.HALF_MADE_BATTA,
					ItemID.UNFINISHED_BATTA_9479,
					ItemID.FRUIT_BATTA,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.EQUA_LEAVES, 4));
							add(new CookingItem(ItemID.LIME_CHUNKS, 1));
							add(new CookingItem(ItemID.ORANGE_CHUNKS, 1));
							add(new CookingItem(ItemID.PINEAPPLE_CHUNKS, 1));
							add(new CookingItem(ItemID.GNOME_SPICE, 1, true));
						}
					}
				)
			);
			put("toad batta", new BakedOrder(
					ItemOrderType.BATTA,
					ItemID.HALF_MADE_BATTA_9482,
					ItemID.TOAD_BATTA,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.EQUA_LEAVES, 4));
							add(new CookingItem(ItemID.GNOME_SPICE, 1));
							add(new CookingItem(ItemID.CHEESE, 1));
							add(new CookingItem(ItemID.TOADS_LEGS, 1));
						}
					}
				)
			);
			put("worm batta", new BakedToppedOrder(
					ItemOrderType.BATTA,
					ItemID.HALF_MADE_BATTA_9480,
					ItemID.UNFINISHED_BATTA_9481,
					ItemID.WORM_BATTA,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.KING_WORM, 1));
							add(new CookingItem(ItemID.CHEESE, 1));
							add(new CookingItem(ItemID.GNOME_SPICE, 1));
							add(new CookingItem(ItemID.EQUA_LEAVES, 1, true));
						}
					}
				)
			);
			put("vegetable batta", new BakedToppedOrder(
					ItemOrderType.BATTA,
					ItemID.HALF_MADE_BATTA_9485,
					ItemID.UNFINISHED_BATTA_9486,
					ItemID.VEGETABLE_BATTA,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.TOMATO, 2));
							add(new CookingItem(ItemID.DWELLBERRIES, 1));
							add(new CookingItem(ItemID.ONION, 1));
							add(new CookingItem(ItemID.CHEESE, 1));
							add(new CookingItem(ItemID.CABBAGE, 1));
							add(new CookingItem(ItemID.EQUA_LEAVES, 1, true));
						}
					}
				)
			);
			put("cheese and tomato batta", new BakedToppedOrder(
					ItemOrderType.BATTA,
					ItemID.HALF_MADE_BATTA_9483,
					ItemID.UNFINISHED_BATTA_9484,
					ItemID.CHEESETOM_BATTA,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.CHEESE, 1));
							add(new CookingItem(ItemID.TOMATO, 1));
							add(new CookingItem(ItemID.EQUA_LEAVES, 1, true));
						}
					}
				)
			);

			// Crunchies

			put("choc chip crunchies", new BakedToppedOrder(
					ItemOrderType.CRUNCHIES,
					ItemID.HALF_MADE_CRUNCHY,
					ItemID.UNFINISHED_CRUNCHY_9578,
					ItemID.CHOCCHIP_CRUNCHIES,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.CHOCOLATE_BAR, 2));
							add(new CookingItem(ItemID.GNOME_SPICE, 1));
							add(new CookingItem(ItemID.CHOCOLATE_DUST, 1, true));
						}
					}
				)
			);
			put("spicy crunchies", new BakedToppedOrder(
					ItemOrderType.CRUNCHIES,
					ItemID.HALF_MADE_CRUNCHY_9579,
					ItemID.UNFINISHED_CRUNCHY_9580,
					ItemID.SPICY_CRUNCHIES,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.EQUA_LEAVES, 2));
							add(new CookingItem(ItemID.GNOME_SPICE, 1));
							add(new CookingItem(ItemID.GNOME_SPICE, 1, true));
						}
					}
				)
			);
			put("toad crunchies", new BakedToppedOrder(
					ItemOrderType.CRUNCHIES,
					ItemID.HALF_MADE_CRUNCHY_9581,
					ItemID.UNFINISHED_CRUNCHY_9582,
					ItemID.TOAD_CRUNCHIES,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.TOADS_LEGS, 2));
							add(new CookingItem(ItemID.GNOME_SPICE, 1));
							add(new CookingItem(ItemID.EQUA_LEAVES, 1, true));
						}
					}
				)
			);
			put("worm crunchies", new BakedToppedOrder(
					ItemOrderType.CRUNCHIES,
					ItemID.HALF_MADE_CRUNCHY_9583,
					ItemID.UNFINISHED_CRUNCHY_9584,
					ItemID.WORM_CRUNCHIES,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.KING_WORM, 2));
							add(new CookingItem(ItemID.GNOME_SPICE, 1));
							add(new CookingItem(ItemID.EQUA_LEAVES, 1));
							add(new CookingItem(ItemID.GNOME_SPICE, 1, true));
						}
					}
				)
			);

			// Gnome cocktails

			put("fruit blast", new CocktailOrder(
					ItemID.MIXED_BLAST,
					ItemID.FRUIT_BLAST,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.PINEAPPLE, 1));
							add(new CookingItem(ItemID.LEMON, 1));
							add(new CookingItem(ItemID.ORANGE, 1));
							add(new CookingItem(ItemID.LEMON_SLICES, 1, true));
						}
					}
				)
			);
			put("pineapple punch", new CocktailOrder(
					ItemID.MIXED_PUNCH,
					ItemID.PINEAPPLE_PUNCH,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.PINEAPPLE, 2));
							add(new CookingItem(ItemID.LEMON, 1));
							add(new CookingItem(ItemID.ORANGE, 1));
							add(new CookingItem(ItemID.LIME_CHUNKS, 1, true));
							add(new CookingItem(ItemID.PINEAPPLE_CHUNKS, 1, true));
							add(new CookingItem(ItemID.ORANGE_SLICES, 1, true));
						}
					}
				)
			);
			put("wizard blizzard", new CocktailOrder(
				ItemID.MIXED_BLIZZARD,
				ItemID.WIZARD_BLIZZARD,
				new ArrayList<CookingItem>()
				{
					{
						add(new CookingItem(ItemID.VODKA, 2));
						add(new CookingItem(ItemID.GIN, 1));
						add(new CookingItem(ItemID.LIME, 1));
						add(new CookingItem(ItemID.LEMON, 1));
						add(new CookingItem(ItemID.ORANGE, 1));
						add(new CookingItem(ItemID.PINEAPPLE_CHUNKS, 1, true));
						add(new CookingItem(ItemID.LIME_SLICES, 1, true));
					}
				}));
			put("short green guy", new CocktailOrder(
					ItemID.MIXED_SGG,
					ItemID.SHORT_GREEN_GUY,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.VODKA, 1));
							add(new CookingItem(ItemID.LIME, 3));
							add(new CookingItem(ItemID.LIME_SLICES, 1, true));
							add(new CookingItem(ItemID.EQUA_LEAVES, 1, true));
						}
					}
				)
			);
			put("drunk dragon", new HeatedCocktailOrder(
					HeatTiming.AFTER_ADDING_INGREDS,
					ItemID.MIXED_DRAGON,
					ItemID.MIXED_DRAGON_9575,
					ItemID.MIXED_DRAGON_9576,
					ItemID.DRUNK_DRAGON,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.VODKA, 1));
							add(new CookingItem(ItemID.GIN, 1));
							add(new CookingItem(ItemID.DWELLBERRIES, 1));
							add(new CookingItem(ItemID.PINEAPPLE_CHUNKS, 1, true));
							add(new CookingItem(ItemID.POT_OF_CREAM, 1, true));
						}
					}
				)
			);
			put("choc saturday", new HeatedCocktailOrder(
					HeatTiming.BEFORE_ADDING_INGREDS,
					ItemID.MIXED_SATURDAY,
					ItemID.MIXED_SATURDAY_9572,
					ItemID.MIXED_SATURDAY_9573,
					ItemID.CHOC_SATURDAY,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.WHISKY, 1));
							add(new CookingItem(ItemID.CHOCOLATE_BAR, 1));
							add(new CookingItem(ItemID.EQUA_LEAVES, 1));
							add(new CookingItem(ItemID.BUCKET_OF_MILK, 1));
							add(new CookingItem(ItemID.CHOCOLATE_DUST, 1, true));
							add(new CookingItem(ItemID.POT_OF_CREAM, 1, true));
						}
					}
				)
			);
			put("blurberry special", new CocktailOrder(
					ItemID.MIXED_SPECIAL,
					ItemID.BLURBERRY_SPECIAL,
					new ArrayList<CookingItem>()
					{
						{
							add(new CookingItem(ItemID.VODKA, 1));
							add(new CookingItem(ItemID.BRANDY, 1));
							add(new CookingItem(ItemID.GIN, 1));
							add(new CookingItem(ItemID.LEMON, 2));
							add(new CookingItem(ItemID.ORANGE, 1));
							add(new CookingItem(ItemID.LEMON_CHUNKS, 1, true));
							add(new CookingItem(ItemID.ORANGE_CHUNKS, 1, true));
							add(new CookingItem(ItemID.EQUA_LEAVES, 1, true));
							add(new CookingItem(ItemID.LIME_SLICES, 1, true));
						}
					}
				)
			);
		}
	});
}
