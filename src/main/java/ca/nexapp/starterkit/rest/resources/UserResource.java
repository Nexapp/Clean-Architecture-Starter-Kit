package ca.nexapp.starterkit.rest.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ca.nexapp.starterkit.application.users.FindUserByEmailUseCase;
import ca.nexapp.starterkit.application.users.UserAssembler;
import ca.nexapp.starterkit.application.users.UserResponse;
import ca.nexapp.starterkit.domain.users.User;
import ca.nexapp.starterkit.domain.users.UserNotFoundException;
import ca.nexapp.starterkit.domain.users.UserRepository;

@Path("user")
public class UserResource {

    @Inject
    private UserRepository userRepository;
    @Inject
    private UserAssembler userAssembler;

    @GET
    @Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findByEmail(@PathParam("email") String email) throws UserNotFoundException {
        User user = new FindUserByEmailUseCase(userRepository).find(email);
        UserResponse userResponse = userAssembler.assembleToDTO(user);
        return Response.ok(userResponse).build();
    }
}
