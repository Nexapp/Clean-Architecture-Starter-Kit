package ca.nexapp.starterkit.application.recipes;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Matchers.anyCollectionOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;

import ca.nexapp.starterkit.domain.recipes.Recipe;
import ca.nexapp.starterkit.domain.recipes.RecipePicker;
import ca.nexapp.starterkit.domain.recipes.RecipeRepository;

public class RecipeFinderUseCaseTest {

    private Recipe recipe;
    private RecipeRepository recipeRepository;
    private RecipePicker recipePicker;
    private RecipeFinderUseCase recipeFinderUseCase;

    @Before
    public void setUp() {
        recipe = mock(Recipe.class);
        recipeRepository = mock(RecipeRepository.class);
        recipePicker = mock(RecipePicker.class);
        recipeFinderUseCase = new RecipeFinderUseCase(recipeRepository);
    }

    @Test
    public void shouldFindTheRecipes() {
        willReturn(Optional.of(recipe)).given(recipePicker).pick(anyCollectionOf(Recipe.class));

        recipeFinderUseCase.find(recipePicker);

        verify(recipeRepository).findAll();
    }

    @Test
    public void givenFoundRecipes_ShouldPickOneOfThoseRecipe() {
        Set<Recipe> recipes = Sets.newHashSet(mock(Recipe.class), mock(Recipe.class));
        willReturn(recipes).given(recipeRepository).findAll();
        willReturn(Optional.of(recipe)).given(recipePicker).pick(anyCollectionOf(Recipe.class));

        recipeFinderUseCase.find(recipePicker);

        verify(recipePicker).pick(recipes);
    }

    @Test(expected = RecipeNotFoundException.class)
    public void givenNoFoundRecipe_ShouldThrowAnException() {
        willReturn(Optional.empty()).given(recipePicker).pick(anyCollectionOf(Recipe.class));

        recipeFinderUseCase.find(recipePicker);
    }

    @Test
    public void shouldReturnThePickedRecipe() {
        willReturn(Optional.of(recipe)).given(recipePicker).pick(anyCollectionOf(Recipe.class));

        Recipe found = recipeFinderUseCase.find(recipePicker);

        assertThat(found).isEqualTo(recipe);
    }
}
