package ca.nexapp.starterkit.domain.recipes.pickers;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;

import ca.nexapp.starterkit.domain.recipes.Recipe;
import ca.nexapp.starterkit.domain.recipes.RecipePicker;

public class HealthiestRecipePickerTest {

    @Test
    public void shouldPickTheFirstRecipe() {
        Recipe first = mock(Recipe.class);
        Recipe second = mock(Recipe.class);
        Recipe third = mock(Recipe.class);
        RecipePicker picker = new HealthiestRecipePicker();

        Optional<Recipe> picked = picker.pick(Arrays.asList(first, second, third));

        assertThat(picked).isEqualTo(Optional.of(first));
    }
}
