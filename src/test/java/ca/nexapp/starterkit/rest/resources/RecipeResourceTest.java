package ca.nexapp.starterkit.rest.resources;

import javax.ws.rs.core.Response;

import org.junit.Test;

public class RecipeResourceTest extends ResourceTest {

    @Test
    public void canFindAllTheRecipes() {
        Response response = target("/recipes").request().get();

        assertThatResponse(response).isOk();
    }

    @Test
    public void canFindTheHealthiestRecipe() {
        Response response = target("/recipes/healthiest").request().get();

        assertThatResponse(response).isOk();
    }
}
