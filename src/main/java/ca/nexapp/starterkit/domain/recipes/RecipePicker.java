package ca.nexapp.starterkit.domain.recipes;

import java.util.Collection;
import java.util.Optional;

public interface RecipePicker {

    Optional<Recipe> pick(Collection<Recipe> recipes);
}
