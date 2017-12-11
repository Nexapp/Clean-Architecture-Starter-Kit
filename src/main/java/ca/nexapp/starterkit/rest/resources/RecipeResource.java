package ca.nexapp.starterkit.rest.resources;

import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ca.nexapp.starterkit.application.recipes.RecipeFinderUseCase;
import ca.nexapp.starterkit.domain.admin.Admin;
import ca.nexapp.starterkit.domain.recipes.Recipe;
import ca.nexapp.starterkit.domain.recipes.RecipeRepository;
import ca.nexapp.starterkit.domain.recipes.pickers.HealthiestRecipePicker;
import ca.nexapp.starterkit.rest.parameters.UnitDisplayParameter;
import ca.nexapp.starterkit.rest.presenters.recipes.RecipePresenter;
import ca.nexapp.starterkit.rest.presenters.recipes.RecipeResponse;

@Path("/recipes")
@Produces(MediaType.APPLICATION_JSON)
public class RecipeResource {

    private RecipeRepository recipeRepository;
    private RecipePresenter recipePresenter;

    @Inject
    public RecipeResource(RecipeRepository recipeRepository, RecipePresenter recipePresenter) {
        this.recipeRepository = recipeRepository;
        this.recipePresenter = recipePresenter;
    }

    @GET
    public RecipeResponse[] findAllRecipes(@BeanParam UnitDisplayParameter unit) {
        Set<Recipe> recipes = recipeRepository.findAll();
        return recipePresenter.present(recipes, unit.value());
    }

    @GET
    @Path("healthiest")
    public RecipeResponse findHealthiestRecipe(@BeanParam UnitDisplayParameter unit) {
        RecipeFinderUseCase recipeFinderUseCase = new RecipeFinderUseCase(recipeRepository);
        Recipe recipe = recipeFinderUseCase.find(new HealthiestRecipePicker());
        return recipePresenter.present(recipe, unit.value());
    }

    @POST
    @RolesAllowed(Admin.PRINCIPAL_NAME)
    public Response add() {
        return Response.noContent().build();
    }
}
