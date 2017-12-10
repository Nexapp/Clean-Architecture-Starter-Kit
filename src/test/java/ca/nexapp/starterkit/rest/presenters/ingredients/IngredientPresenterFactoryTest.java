package ca.nexapp.starterkit.rest.presenters.ingredients;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Before;
import org.junit.Test;

public class IngredientPresenterFactoryTest {

    private IngredientPresenterFactory ingredientPresenterFactory;

    @Before
    public void setUp() {
        ingredientPresenterFactory = new IngredientPresenterFactory();
    }

    @Test
    public void canCreateMetricPresenter() {
        IngredientPresenter ingredientPresenter = ingredientPresenterFactory.create(UnitDisplay.METRIC);

        assertThat(ingredientPresenter).isInstanceOf(MetricIngredientPresenter.class);
    }

    @Test
    public void canCreateImperialPresenter() {
        IngredientPresenter ingredientPresenter = ingredientPresenterFactory.create(UnitDisplay.IMPERIAL);

        assertThat(ingredientPresenter).isInstanceOf(ImperialIngredientPresenter.class);
    }

    @Test
    public void shouldCreateAnInstanceForEachUnit() {
        for (UnitDisplay unit : UnitDisplay.values()) {
            IngredientPresenter ingredientPresenter = ingredientPresenterFactory.create(unit);
            assertThat(ingredientPresenter).isNotNull();
        }
    }
}
