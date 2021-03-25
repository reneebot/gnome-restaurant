package io.github.mmagicala.gnomeRestaurant;

public class OrderRecipient
{
	public final String addressedName;
	public final String inGameName;
	public final OrderDifficulty difficulty;

	public OrderRecipient(String addressedName, String inGameName, OrderDifficulty difficulty)
	{
		this.addressedName = addressedName;
		this.inGameName = inGameName;
		this.difficulty = difficulty;
	}
}
