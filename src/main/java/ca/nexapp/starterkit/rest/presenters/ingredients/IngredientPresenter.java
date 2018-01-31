package ca.nexapp.starterkit.rest.presenters.ingredients;

import java.util.Collection;

import ca.nexapp.starterkit.domain.ingredients.Ingredient;
import ca.nexapp.starterkit.domain.ingredients.IngredientVisitor;

public abstract class IngredientPresenter implements IngredientVisitor<IngredientResponse> {

    public IngredientResponse[] present(Collection<Ingredient> ingredients) {
        return ingredients.stream().map(this::present).toArray(IngredientResponse[]::new);
    }

    public IngredientResponse present(Ingredient ingredient) {
        return ingredient.accept(this);
    }

}
