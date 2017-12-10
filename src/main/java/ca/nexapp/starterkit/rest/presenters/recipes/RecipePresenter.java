package ca.nexapp.starterkit.rest.presenters.recipes;

import java.util.Collection;

import ca.nexapp.starterkit.domain.recipes.Recipe;
import ca.nexapp.starterkit.rest.presenters.ingredients.IngredientPresenter;

public class RecipePresenter {

    private final IngredientPresenter ingredientPresenter;

    public RecipePresenter(IngredientPresenter ingredientPresenter) {
        this.ingredientPresenter = ingredientPresenter;
    }

    public RecipeResponse[] present(Collection<Recipe> recipes) {
        return recipes.stream().map(this::present).toArray(RecipeResponse[]::new);
    }

    public RecipeResponse present(Recipe recipe) {
        RecipeResponse response = new RecipeResponse();
        response.name = recipe.name;
        response.ingredients = ingredientPresenter.present(recipe.ingredients);
        return response;
    }
}
