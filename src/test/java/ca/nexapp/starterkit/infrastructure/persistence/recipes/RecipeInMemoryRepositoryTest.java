package ca.nexapp.starterkit.infrastructure.persistence.recipes;

import ca.nexapp.starterkit.domain.recipes.RecipeRepository;
import ca.nexapp.starterkit.domain.recipes.RecipeRepositoryTest;

public class RecipeInMemoryRepositoryTest extends RecipeRepositoryTest {

    @Override
    protected RecipeRepository createRepository() {
        return new RecipeInMemoryRepository();
    }

}
