package ca.nexapp.starterkit.rest.presenters.ingredients;

import java.util.Collection;

import ca.nexapp.starterkit.domain.ingredients.Ingredient;
import ca.nexapp.starterkit.domain.ingredients.IngredientVisitor;
import ca.nexapp.starterkit.domain.ingredients.MassIngredient;
import ca.nexapp.starterkit.domain.ingredients.UnitLessIngredient;

public class IngredientPresenter implements IngredientVisitor<IngredientResponse> {

    public IngredientResponse[] present(Collection<Ingredient> ingredients) {
        return ingredients.stream().map(this::present).toArray(IngredientResponse[]::new);
    }

    public IngredientResponse present(Ingredient ingredient) {
        return ingredient.accept(this);
    }

    @Override
    public IngredientResponse visit(UnitLessIngredient ingredient) {
        IngredientResponse response = new IngredientResponse();
        response.name = ingredient.getName();
        return response;
    }

    @Override
    public IngredientResponse visit(MassIngredient ingredient) {
        IngredientResponse response = new IngredientResponse();
        response.name = ingredient.getName();
        response.unit = "grams";
        response.quantity = ingredient.getMass().toGrams();
        return response;
    }
}
