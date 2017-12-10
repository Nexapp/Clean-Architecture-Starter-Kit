package ca.nexapp.starterkit.rest.presenters.ingredients;

public class IngredientPresenterFactory {

    public IngredientPresenter create(UnitDisplay unit) {
        switch (unit) {
            case METRIC:
                return new MetricIngredientPresenter();
            case IMPERIAL:
                return new ImperialIngredientPresenter();
            default:
                return new MetricIngredientPresenter();
        }
    }
}
