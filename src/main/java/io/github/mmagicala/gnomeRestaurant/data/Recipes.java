package io.github.mmagicala.gnomeRestaurant.data;

import io.github.mmagicala.gnomeRestaurant.BakedRecipeType;
import io.github.mmagicala.gnomeRestaurant.Ingredient;
import io.github.mmagicala.gnomeRestaurant.Instruction;
import io.github.mmagicala.gnomeRestaurant.RecipeStep;
import io.github.mmagicala.gnomeRestaurant.recipe.CocktailOrder;
import io.github.mmagicala.gnomeRestaurant.recipe.HeatedCocktailOrder;
import java.util.ArrayList;
import java.util.HashMap;
import net.runelite.api.ItemID;

public class Recipes
{
	public static final HashMap<String, ArrayList<RecipeStep>> list = new HashMap<String, ArrayList<RecipeStep>>()
	{
		{
			// Gnomebowls

			put("worm hole", createBakedRecipe(
				BakedRecipeType.GNOMEBOWL,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.KING_WORM, 4));
						add(new Ingredient(ItemID.ONION, 2));
						add(new Ingredient(ItemID.GNOME_SPICE, 1));
					}
				},
				ItemID.HALF_MADE_BOWL_9559,
				ItemID.UNFINISHED_BOWL_9560,
				new Ingredient(ItemID.EQUA_LEAVES, 1),
				ItemID.WORM_HOLE)
			);

			put("vegetable ball", createBakedRecipe(
				BakedRecipeType.GNOMEBOWL,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.POTATO, 2));
						add(new Ingredient(ItemID.ONION, 2));
						add(new Ingredient(ItemID.GNOME_SPICE, 1));
					}
				},
				ItemID.HALF_MADE_BOWL_9561,
				ItemID.UNFINISHED_BOWL_9562,
				new Ingredient(ItemID.EQUA_LEAVES, 1),
				ItemID.VEG_BALL)
			);

			put("tangled toads legs", createBakedRecipe(
				BakedRecipeType.GNOMEBOWL,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.TOADS_LEGS, 4));
						add(new Ingredient(ItemID.GNOME_SPICE, 1));
						add(new Ingredient(ItemID.CHEESE, 2));
						add(new Ingredient(ItemID.DWELLBERRIES, 1));
						add(new Ingredient(ItemID.EQUA_LEAVES, 2));
					}
				},
				ItemID.HALF_MADE_BOWL,
				ItemID.TANGLED_TOADS_LEGS)
			);

			put("chocolate bomb", createBakedRecipe(
				BakedRecipeType.GNOMEBOWL,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.CHOCOLATE_BAR, 4));
						add(new Ingredient(ItemID.EQUA_LEAVES, 1));
					}
				},
				ItemID.HALF_MADE_BOWL_9563,
				ItemID.UNFINISHED_BOWL_9564,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.CHOCOLATE_DUST, 1));
						add(new Ingredient(ItemID.POT_OF_CREAM, 2));
					}
				},
				ItemID.CHOCOLATE_BOMB)
			);

			// Battas

			put("fruit batta", createBakedRecipe(
				BakedRecipeType.BATTA,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.EQUA_LEAVES, 4));
						add(new Ingredient(ItemID.LIME_CHUNKS, 1));
						add(new Ingredient(ItemID.ORANGE_CHUNKS, 1));
						add(new Ingredient(ItemID.PINEAPPLE_CHUNKS, 1));
					}
				},
				ItemID.HALF_MADE_BATTA,
				ItemID.UNFINISHED_BATTA_9479,
				new Ingredient(ItemID.GNOME_SPICE, 1),
				ItemID.FRUIT_BATTA)
			);

			put("toad batta", createBakedRecipe(
				BakedRecipeType.BATTA,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.EQUA_LEAVES, 1));
						add(new Ingredient(ItemID.GNOME_SPICE, 1));
						add(new Ingredient(ItemID.CHEESE, 1));
						add(new Ingredient(ItemID.TOADS_LEGS, 1));
					}
				},
				ItemID.HALF_MADE_BATTA_9482,
				ItemID.TOAD_BATTA)
			);

			put("worm batta", createBakedRecipe(
				BakedRecipeType.BATTA,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.KING_WORM, 1));
						add(new Ingredient(ItemID.CHEESE, 1));
						add(new Ingredient(ItemID.GNOME_SPICE, 1));
					}
				},
				ItemID.HALF_MADE_BATTA_9480,
				ItemID.UNFINISHED_BATTA_9481,
				new Ingredient(ItemID.EQUA_LEAVES, 1),
				ItemID.WORM_BATTA)
			);

			put("vegetable batta", createBakedRecipe(
				BakedRecipeType.BATTA,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.TOMATO, 2));
						add(new Ingredient(ItemID.DWELLBERRIES, 1));
						add(new Ingredient(ItemID.ONION, 1));
						add(new Ingredient(ItemID.CHEESE, 1));
						add(new Ingredient(ItemID.CABBAGE, 1));
					}
				},
				ItemID.HALF_MADE_BATTA_9485,
				ItemID.UNFINISHED_BATTA_9486,
				new Ingredient(ItemID.EQUA_LEAVES, 1),
				ItemID.VEGETABLE_BATTA)
			);

			put("cheese and tomato batta", createBakedRecipe(
				BakedRecipeType.BATTA,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.CHEESE, 1));
						add(new Ingredient(ItemID.TOMATO, 1));
					}
				},
				ItemID.HALF_MADE_BATTA_9483,
				ItemID.UNFINISHED_BATTA_9484,
				new Ingredient(ItemID.EQUA_LEAVES, 1),
				ItemID.CHEESETOM_BATTA)
			);

			// Crunchies

			put("choc chip crunchies", createBakedRecipe(
				BakedRecipeType.CRUNCHIES,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.CHOCOLATE_BAR, 2));
						add(new Ingredient(ItemID.GNOME_SPICE, 1));
					}
				},
				ItemID.HALF_MADE_CRUNCHY,
				ItemID.UNFINISHED_CRUNCHY_9578,
				new Ingredient(ItemID.CHOCOLATE_DUST, 1),
				ItemID.CHOCCHIP_CRUNCHIES)
			);

			put("spicy crunchies", createBakedRecipe(
				BakedRecipeType.CRUNCHIES,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.EQUA_LEAVES, 2));
						add(new Ingredient(ItemID.GNOME_SPICE, 1));
					}
				},
				ItemID.HALF_MADE_CRUNCHY_9579,
				ItemID.UNFINISHED_CRUNCHY_9580,
				new Ingredient(ItemID.GNOME_SPICE, 1),
				ItemID.SPICY_CRUNCHIES)
			);

			put("toad crunchies", createBakedRecipe(
				BakedRecipeType.CRUNCHIES,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.TOADS_LEGS, 2));
						add(new Ingredient(ItemID.GNOME_SPICE, 1));
					}
				},
				ItemID.HALF_MADE_CRUNCHY_9581,
				ItemID.UNFINISHED_CRUNCHY_9582,
				new Ingredient(ItemID.EQUA_LEAVES, 1),
				ItemID.TOAD_CRUNCHIES)
			);

			put("worm crunchies", createBakedRecipe(
				BakedRecipeType.CRUNCHIES,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.KING_WORM, 2));
						add(new Ingredient(ItemID.GNOME_SPICE, 1));
						add(new Ingredient(ItemID.EQUA_LEAVES, 1));
					}
				},
				ItemID.HALF_MADE_CRUNCHY_9583,
				ItemID.UNFINISHED_CRUNCHY_9584,
				new Ingredient(ItemID.GNOME_SPICE, 1),
				ItemID.WORM_CRUNCHIES)
			);

			// Cocktails

			put("fruit blast", createCocktailRecipe(
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.PINEAPPLE, 1));
						add(new Ingredient(ItemID.LEMON, 1));
						add(new Ingredient(ItemID.ORANGE, 1));
					}
				},
				ItemID.MIXED_BLAST,
				new Ingredient(ItemID.LEMON_SLICES, 1),
				ItemID.FRUIT_BLAST)
			);

			put("pineapple punch", createCocktailRecipe(
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.PINEAPPLE, 2));
						add(new Ingredient(ItemID.LEMON, 1));
						add(new Ingredient(ItemID.ORANGE, 1));
					}
				},
				ItemID.MIXED_PUNCH,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.LIME_CHUNKS, 1));
						add(new Ingredient(ItemID.PINEAPPLE_CHUNKS, 1));
						add(new Ingredient(ItemID.ORANGE_SLICES, 1));
					}
				},
				ItemID.PINEAPPLE_PUNCH)
			);

			put("wizard blizzard", createCocktailRecipe(
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.VODKA, 2));
						add(new Ingredient(ItemID.GIN, 1));
						add(new Ingredient(ItemID.LIME, 1));
						add(new Ingredient(ItemID.LEMON, 1));
						add(new Ingredient(ItemID.ORANGE, 1));
					}
				},
				ItemID.MIXED_BLIZZARD,
				new ArrayList<Ingredient>()
				{
					{
						add(new Ingredient(ItemID.PINEAPPLE_CHUNKS, 1));
						add(new Ingredient(ItemID.LIME_SLICES, 1));
					}
				},
				ItemID.WIZARD_BLIZZARD)
			);

			put("short green guy", createCocktailRecipe(
					new ArrayList<Ingredient>()
					{
						{
							add(new Ingredient(ItemID.VODKA, 1));
							add(new Ingredient(ItemID.LIME, 3));
						}
					},
					ItemID.MIXED_SGG,
					new ArrayList<Ingredient>()
					{
						{
							add(new Ingredient(ItemID.LIME_SLICES, 1));
							add(new Ingredient(ItemID.EQUA_LEAVES, 1));
						}
					},
					ItemID.SHORT_GREEN_GUY)
			);

			put("drunk dragon", createDrunkDragonRecipe());
			put("choc saturday", createChocSaturdayRecipe());

			put("blurberry special", createCocktailRecipe(
					new ArrayList<Ingredient>()
					{
						{
							add(new Ingredient(ItemID.VODKA, 1));
							add(new Ingredient(ItemID.BRANDY, 1));
							add(new Ingredient(ItemID.GIN, 1));
							add(new Ingredient(ItemID.LEMON, 2));
							add(new Ingredient(ItemID.ORANGE, 1));
						}
					},
					ItemID.MIXED_SPECIAL,
					new ArrayList<Ingredient>()
					{
						{
							add(new Ingredient(ItemID.LEMON_CHUNKS, 1));
							add(new Ingredient(ItemID.ORANGE_CHUNKS, 1));
							add(new Ingredient(ItemID.EQUA_LEAVES, 1));
							add(new Ingredient(ItemID.LIME_SLICES, 1));
						}
					},
					ItemID.BLURBERRY_SPECIAL)
			);
		}
	};

	// Cocktail recipe builders

	// Sets up recipe from making raw batter to half-made item

	private static ArrayList<RecipeStep> createBakedRecipeHelper(BakedRecipeType bakedRecipeType,
																 ArrayList<Ingredient> ingredients, int halfMadeId)
	{
		ArrayList<RecipeStep> unfinishedRecipe = new ArrayList<>();

		unfinishedRecipe.add(new RecipeStep(Instruction.CREATE_RAW,
			new ArrayList<Ingredient>()
			{
				{
					add(new Ingredient(ItemID.GIANNE_DOUGH, 1));
					add(new Ingredient(bakedRecipeType.getToolId(), 1));
				}
			},
			bakedRecipeType.getRawId())
		);

		unfinishedRecipe.add(new RecipeStep(Instruction.CREATE_HALF_BAKED,
			new Ingredient(bakedRecipeType.getRawId(), 1, true),
			bakedRecipeType.getHalfBakedId())
		);

		ArrayList<Ingredient> ingredientsToCombine = new ArrayList<>(ingredients);
		ingredientsToCombine.add(new Ingredient(bakedRecipeType.getHalfBakedId(), 1, true));

		unfinishedRecipe.add(new RecipeStep(Instruction.COMBINE_INGREDIENTS, ingredientsToCombine, halfMadeId));

		return unfinishedRecipe;
	}

	// Baked recipe with no topped ingredients

	private static ArrayList<RecipeStep> createBakedRecipe(BakedRecipeType bakedRecipeType, ArrayList<Ingredient> ingredients,
														   int halfMadeId, int finishedId)
	{
		ArrayList<RecipeStep> recipe = createBakedRecipeHelper(bakedRecipeType, ingredients, halfMadeId);

		// Bake bowl to finish

		recipe.add(new RecipeStep(Instruction.ADD_TOPPINGS,
			new Ingredient(halfMadeId, 1, true),
			finishedId));

		return recipe;
	}

	// Baked recipe with multiple topped ingredients

	private static ArrayList<RecipeStep> createBakedRecipe(BakedRecipeType bakedRecipeType,
														   ArrayList<Ingredient> firstIngredients, int halfMadeId,
														   int unfinishedId, ArrayList<Ingredient> toppingIngredients,
														   int finishedId)
	{
		ArrayList<RecipeStep> recipe = createBakedRecipe(bakedRecipeType, firstIngredients, halfMadeId, finishedId);

		// Bake half made item

		recipe.add(new RecipeStep(Instruction.CREATE_UNFINISHED,
			new Ingredient(halfMadeId, 1, true),
			unfinishedId));

		// Add topping to unfinished item

		recipe.add(new RecipeStep(Instruction.ADD_TOPPINGS,
			new ArrayList<Ingredient>()
			{
				{
					add(new Ingredient(unfinishedId, 1, true));
					addAll(toppingIngredients);
				}
			},
			finishedId));

		return recipe;
	}

	// Baked recipe with one topped ingredient

	private static ArrayList<RecipeStep> createBakedRecipe(BakedRecipeType bakedRecipeType,
														   ArrayList<Ingredient> firstIngredients, int halfMadeId,
														   int unfinishedId, Ingredient toppingIngredient,
														   int finishedId)
	{
		ArrayList<Ingredient> toppingIngredients = new ArrayList<>();
		toppingIngredients.add(toppingIngredient);

		return createBakedRecipe(bakedRecipeType, firstIngredients, halfMadeId, unfinishedId, toppingIngredients,
			finishedId);
	}

	// Cocktail recipe builders

	private static ArrayList<RecipeStep> createCocktailRecipeHelper(ArrayList<Ingredient> shakedIngredients,
																	int mixedItem)
	{
		ArrayList<RecipeStep> unfinishedRecipe = new ArrayList<>();

		unfinishedRecipe.add(new RecipeStep(Instruction.MIX_COCKTAIL,
			new ArrayList<Ingredient>(){
				{
					addAll(shakedIngredients);
					add(new Ingredient(ItemID.COCKTAIL_SHAKER, 1, true));
				}
			},
			mixedItem)
		);

		return unfinishedRecipe;
	}

	// Simple cocktail recipe with one poured ingredient

	private static ArrayList<RecipeStep> createCocktailRecipe(ArrayList<Ingredient> shakedIngredients,
															  int mixedItem, ArrayList<Ingredient> pouredIngredients,
															  int finishedItem)
	{
		ArrayList<RecipeStep> recipe = createCocktailRecipeHelper(shakedIngredients, mixedItem);

		recipe.add(new RecipeStep(Instruction.POUR, new ArrayList<Ingredient>(){
				{
					add(new Ingredient(ItemID.COCKTAIL_GLASS, 1, true));
					addAll(pouredIngredients);
				}
			},
			finishedItem)
		);

		return recipe;
	}

	// Simple cocktail recipe with multiple poured ingredients

	private static ArrayList<RecipeStep> createCocktailRecipe(ArrayList<Ingredient> shakedIngredients, int mixedItem,
															  Ingredient pouredIngredient, int finishedItem)
	{
		ArrayList<Ingredient> pouredIngredients = new ArrayList<>();
		pouredIngredients.add(pouredIngredient);

		return createCocktailRecipe(shakedIngredients, mixedItem, pouredIngredients, finishedItem);
	}

	// Heated cocktail recipes

	private static ArrayList<RecipeStep> createDrunkDragonRecipe()
	{
		ArrayList<Ingredient> shakedIngredients = new ArrayList<Ingredient>()
		{
			{
				add(new Ingredient(ItemID.VODKA, 1));
				add(new Ingredient(ItemID.GIN, 1));
				add(new Ingredient(ItemID.DWELLBERRIES, 1));
			}
		};

		ArrayList<RecipeStep> recipe = createCocktailRecipe(shakedIngredients, ItemID.MIXED_DRAGON_9575,
			new ArrayList<Ingredient>()
			{
				{
					add(new Ingredient(ItemID.PINEAPPLE_CHUNKS, 1));
					add(new Ingredient(ItemID.POT_OF_CREAM, 1));
				}
			},
			ItemID.MIXED_DRAGON_9576);

		recipe.add(new RecipeStep(Instruction.HEAT_COCKTAIL,
			new Ingredient(ItemID.MIXED_DRAGON_9576, 1, true), ItemID.DRUNK_DRAGON));

		return recipe;
	}

	private static ArrayList<RecipeStep> createChocSaturdayRecipe()
	{
		ArrayList<Ingredient> shakedIngredients = new ArrayList<Ingredient>()
		{
			{
				add(new Ingredient(ItemID.WHISKY, 1));
				add(new Ingredient(ItemID.CHOCOLATE_BAR, 1));
				add(new Ingredient(ItemID.EQUA_LEAVES, 1));
				add(new Ingredient(ItemID.BUCKET_OF_MILK, 1));
			}
		};

		ArrayList<RecipeStep> recipe = createCocktailRecipeHelper(shakedIngredients, ItemID.MIXED_SATURDAY_9572);

		recipe.add(new RecipeStep(Instruction.HEAT_COCKTAIL,
			new Ingredient(ItemID.MIXED_SATURDAY_9572, 1, true), ItemID.MIXED_SATURDAY_9573));

		recipe.add(new RecipeStep(Instruction.ADD_TOPPINGS,
			new ArrayList<Ingredient>()
			{
				{
					add(new Ingredient(ItemID.MIXED_SATURDAY_9573, 1, true));
					add(new Ingredient(ItemID.CHOCOLATE_DUST, 1));
					add(new Ingredient(ItemID.POT_OF_CREAM, 1));

				}
			}
			, ItemID.CHOC_SATURDAY));

		return recipe;
	}

	/** Return raw ingredients used in a recipe after step number @stepNum **/
	public static ArrayList<Ingredient> getFutureRawIngredients(ArrayList<RecipeStep> recipe, int stepNum)
	{
		ArrayList<Ingredient> ingredients = new ArrayList<>();

		// Collect raw ingredients from each step
		for (int i = stepNum + 1; i < recipe.size(); i++)
		{
			ArrayList<Ingredient> rawIngredients = recipe.get(stepNum).getRawIngredients();
			ingredients.addAll(rawIngredients);
		}

		return ingredients;
	}

	/** Return the final product of a recipe **/
	public static int getFinalProduct(ArrayList<RecipeStep> recipe)
	{
		RecipeStep lastStep = recipe.get(recipe.size() - 1);
		return lastStep.getProducedItemId();
	}
}
