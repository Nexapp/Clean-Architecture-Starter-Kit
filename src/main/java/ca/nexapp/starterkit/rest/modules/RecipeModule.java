package ca.nexapp.starterkit.rest.modules;

import java.util.Arrays;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import ca.nexapp.math.units.Mass;
import ca.nexapp.starterkit.domain.ingredients.Ingredient;
import ca.nexapp.starterkit.domain.ingredients.MassIngredient;
import ca.nexapp.starterkit.domain.ingredients.UnitLessIngredient;
import ca.nexapp.starterkit.domain.recipes.Recipe;
import ca.nexapp.starterkit.domain.recipes.RecipeRepository;
import ca.nexapp.starterkit.infrastructure.persistence.recipes.RecipeInMemoryRepository;
import ca.nexapp.starterkit.rest.presenters.ingredients.IngredientPresenterFactory;
import ca.nexapp.starterkit.rest.presenters.recipes.RecipePresenter;

public class RecipeModule extends AbstractModule {

    @Override
    protected void configure() {

    }

    @Provides
    public RecipePresenter providesRecipePresenter() {
        return new RecipePresenter(new IngredientPresenterFactory());
    }

    @Provides
    @Singleton
    public RecipeRepository providesRecipeRepository() {
        RecipeRepository recipeRepository = new RecipeInMemoryRepository();
        recipeRepository.add(porkAndBeans());
        recipeRepository.add(creamPie());
        return recipeRepository;
    }

    private Recipe porkAndBeans() {
        Ingredient salt = new UnitLessIngredient("salt");
        Ingredient pepper = new UnitLessIngredient("pepper");
        Ingredient pork = new MassIngredient("Pork", Mass.grams(250));
        Ingredient beans = new MassIngredient("Beans", Mass.grams(20));
        return new Recipe("Pork and Beans", Arrays.asList(salt, pepper, pork, beans));
    }

    private Recipe creamPie() {
        Ingredient salt = new UnitLessIngredient("salt");
        Ingredient pepper = new UnitLessIngredient("pepper");
        Ingredient cream = new MassIngredient("Cream", Mass.grams(200));
        Ingredient flour = new MassIngredient("Flour", Mass.grams(10));
        return new Recipe("Cream pie", Arrays.asList(cream, flour, salt, pepper));
    }

}
