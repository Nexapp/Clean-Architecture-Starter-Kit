package ca.nexapp.starterkit.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.codahale.metrics.health.HealthCheck;

@Path("/ping")
@Produces(MediaType.APPLICATION_JSON)
public class PingResource extends HealthCheck {

    @GET
    @Timed
    public Response ping() {
        return Response.noContent().build();
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }

}
