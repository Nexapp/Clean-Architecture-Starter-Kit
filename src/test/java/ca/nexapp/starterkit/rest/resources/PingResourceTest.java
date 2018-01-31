package ca.nexapp.starterkit.rest.resources;

import javax.ws.rs.core.Response;

import org.junit.Test;

public class PingResourceTest extends ResourceTest {

    @Test
    public void canPingTheAPI() {
        Response response = target("ping").request().get();

        assertThatResponse(response).isOk();
    }
}
