package ca.nexapp.starterkit.rest.mappers.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import ca.nexapp.starterkit.domain.users.UserNotFoundException;

@Provider
public class UserNotFoundMapper implements ExceptionMapper<UserNotFoundException> {

    @Override
    public Response toResponse(UserNotFoundException exception) {
        ErrorException error = new ErrorException("NO_USER", exception.getMessage());
        return Response.status(Status.BAD_REQUEST).entity(error).build();
    }

}
