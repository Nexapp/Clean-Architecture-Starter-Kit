package ca.nexapp.starterkit.rest.presenters.ingredients;

import ca.nexapp.starterkit.domain.ingredients.MassIngredient;
import ca.nexapp.starterkit.domain.ingredients.UnitLessIngredient;

public class MetricIngredientPresenter extends IngredientPresenter {

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
