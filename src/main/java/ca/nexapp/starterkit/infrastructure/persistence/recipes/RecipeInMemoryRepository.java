package ca.nexapp.starterkit.infrastructure.persistence.recipes;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import ca.nexapp.starterkit.domain.recipes.Recipe;
import ca.nexapp.starterkit.domain.recipes.RecipeRepository;

public class RecipeInMemoryRepository implements RecipeRepository {

    private final Set<Recipe> recipes = new CopyOnWriteArraySet<>();

    @Override
    public void add(Recipe recipe) {
        recipes.add(recipe);
    }

    @Override
    public Set<Recipe> findAll() {
        return recipes;
    }

}
