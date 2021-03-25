package io.github.mmagicala.gnomeRestaurant.data;

import io.github.mmagicala.gnomeRestaurant.OrderDifficulty;
import io.github.mmagicala.gnomeRestaurant.OrderRecipient;
import java.util.ArrayList;

public class OrderRecipients
{
	public static final ArrayList<OrderRecipient> list = new ArrayList<OrderRecipient>()
	{
		{
			add(new OrderRecipient("Burkor", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Brimstail", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Captain Errdo", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Coach", "Gnome Coach", OrderDifficulty.EASY));
			add(new OrderRecipient("Dalila", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Damwin", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Eebel", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Ermin", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Femi", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Froono", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Guard Vemmeldo", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Gulluck", null, OrderDifficulty.EASY));
			add(new OrderRecipient("His Royal Highness King Narnode", "King Narnode Shareen",
				OrderDifficulty.EASY));
			add(new OrderRecipient("Meegle", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Perrdur", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Rometti", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Sarble", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Trainer Nacklepen", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Wurbel", null, OrderDifficulty.EASY));
			add(new OrderRecipient("Heckel Funch", null, OrderDifficulty.EASY));

			// Hard NPCs
			add(new OrderRecipient("Ambassador Ferrnook", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Ambassador Gimblewap", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Ambassador Spanfipple", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Brambickle", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Captain Bleemadge", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Captain Daerkin", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Captain Dalbur", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Captain Klemfoodle", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Captain Ninto", null, OrderDifficulty.HARD));
			add(new OrderRecipient("G.L.O Caranock", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Garkor", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Gnormadium Avlafrim", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Hazelmere", null, OrderDifficulty.HARD));
			add(new OrderRecipient("King Bolren", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Lieutenant Schepbur", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Penwie", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Professor Imblewyn", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Professor Manglethorp", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Professor Onglewip", null, OrderDifficulty.HARD));
			add(new OrderRecipient("Wingstone", null, OrderDifficulty.HARD));
		}
	};
}
