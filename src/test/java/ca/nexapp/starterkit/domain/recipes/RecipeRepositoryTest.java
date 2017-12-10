package ca.nexapp.starterkit.domain.recipes;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ca.nexapp.math.units.Mass;
import ca.nexapp.starterkit.domain.ingredients.Ingredient;
import ca.nexapp.starterkit.domain.ingredients.MassIngredient;
import ca.nexapp.starterkit.domain.ingredients.UnitLessIngredient;

public abstract class RecipeRepositoryTest {

    private RecipeRepository recipeRepository;

    @Before
    public void setUp() {
        recipeRepository = createRepository();
    }

    @Test
    public void canAddRecipes() {
        Recipe recipe = aRecipe();
        Recipe anotherRecipe = anotherRecipe();

        recipeRepository.add(recipe);
        recipeRepository.add(anotherRecipe);

        Set<Recipe> recipes = recipeRepository.findAll();
        assertThat(recipes).containsExactly(recipe, anotherRecipe);
    }

    protected abstract RecipeRepository createRepository();

    private Recipe aRecipe() {
        Ingredient salt = new UnitLessIngredient("salt");
        Ingredient pepper = new UnitLessIngredient("pepper");
        Ingredient pork = new MassIngredient("Pork", Mass.grams(250));
        Ingredient beans = new MassIngredient("Beans", Mass.grams(20));
        return new Recipe("Pork and Beans", Arrays.asList(salt, pepper, pork, beans));
    }

    private Recipe anotherRecipe() {
        Ingredient salt = new UnitLessIngredient("salt");
        Ingredient pepper = new UnitLessIngredient("pepper");
        Ingredient cream = new MassIngredient("Cream", Mass.grams(200));
        Ingredient flour = new MassIngredient("Flour", Mass.grams(10));
        return new Recipe("Cream pie", Arrays.asList(cream, flour, salt, pepper));
    }
}
