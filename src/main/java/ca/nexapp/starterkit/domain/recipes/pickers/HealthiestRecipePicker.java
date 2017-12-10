package ca.nexapp.starterkit.domain.recipes.pickers;

import java.util.Collection;
import java.util.Optional;

import ca.nexapp.starterkit.domain.recipes.Recipe;
import ca.nexapp.starterkit.domain.recipes.RecipePicker;

public class HealthiestRecipePicker implements RecipePicker {

    @Override
    public Optional<Recipe> pick(Collection<Recipe> recipes) {
        return recipes.stream().findFirst();
    }

}
