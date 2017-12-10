package ca.nexapp.starterkit.domain.recipes;

import java.util.Set;

public interface RecipeRepository {

    void add(Recipe recipe);

    Set<Recipe> findAll();
}
