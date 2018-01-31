package ca.nexapp.starterkit.application.recipes;

import java.util.Set;

import ca.nexapp.starterkit.domain.recipes.Recipe;
import ca.nexapp.starterkit.domain.recipes.RecipePicker;
import ca.nexapp.starterkit.domain.recipes.RecipeRepository;

public class RecipeFinderUseCase {

    private final RecipeRepository recipeRepository;

    public RecipeFinderUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe find(RecipePicker recipePicker) {
        Set<Recipe> recipes = recipeRepository.findAll();
        return recipePicker.pick(recipes).orElseThrow(RecipeNotFoundException::new);
    }
}
