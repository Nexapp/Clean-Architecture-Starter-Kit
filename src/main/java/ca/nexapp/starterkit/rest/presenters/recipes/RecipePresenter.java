package ca.nexapp.starterkit.rest.presenters.recipes;

import java.util.Collection;

import ca.nexapp.starterkit.domain.recipes.Recipe;
import ca.nexapp.starterkit.rest.presenters.ingredients.IngredientPresenter;
import ca.nexapp.starterkit.rest.presenters.ingredients.IngredientPresenterFactory;
import ca.nexapp.starterkit.rest.presenters.ingredients.UnitDisplay;

public class RecipePresenter {

    private final IngredientPresenterFactory ingredientPresenterFactory;

    public RecipePresenter(IngredientPresenterFactory ingredientPresenterFactory) {
        this.ingredientPresenterFactory = ingredientPresenterFactory;
    }

    public RecipeResponse[] present(Collection<Recipe> recipes, UnitDisplay unitDisplay) {
        return recipes.stream().map(recipe -> present(recipe, unitDisplay)).toArray(RecipeResponse[]::new);
    }

    public RecipeResponse present(Recipe recipe, UnitDisplay unitDisplay) {
        IngredientPresenter ingredientPresenter = ingredientPresenterFactory.create(unitDisplay);

        RecipeResponse response = new RecipeResponse();
        response.name = recipe.name;
        response.ingredients = ingredientPresenter.present(recipe.ingredients);
        return response;
    }
}
