package ca.nexapp.starterkit.rest.mappers.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import ca.nexapp.starterkit.application.recipes.RecipeNotFoundException;

@Provider
public class RecipeNotFoundMapper implements ExceptionMapper<RecipeNotFoundException> {

    @Override
    public Response toResponse(RecipeNotFoundException exception) {
        ErrorException error = new ErrorException("NO_RECIPE_FOUND");
        return Response.status(Status.BAD_REQUEST).entity(error).build();
    }

}
