package ca.nexapp.starterkit.rest.resources;

import static com.google.common.truth.Truth.assertAbout;

import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.ClassRule;

import ca.nexapp.starterkit.StarterKitApplication;
import ca.nexapp.starterkit.configurations.StarterKitConfiguration;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.client.JerseyClientConfiguration;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import io.dropwizard.util.Duration;

public abstract class ResourceTest {

    private static String CONFIG_PATH = ResourceHelpers.resourceFilePath("config.test.yml");

    @ClassRule
    public static final DropwizardAppRule<StarterKitConfiguration> RULE = new DropwizardAppRule<>(StarterKitApplication.class, CONFIG_PATH);

    protected ResponseSubject assertThatResponse(Response response) {
        return assertAbout(ResponseSubject.RESPONSE).that(response);
    }

    protected WebTarget target(String endpoint) {
        return client().target(actualURL(endpoint));
    }

    private static String actualURL(String endpoint) {
        if (endpoint.startsWith("/")) {
            return String.format("http://localhost:%d%s", RULE.getLocalPort(), endpoint);
        }
        return String.format("http://localhost:%d/%s", RULE.getLocalPort(), endpoint);
    }

    protected static Client client() {
        UUID clientId = UUID.randomUUID();
        return new JerseyClientBuilder(RULE.getEnvironment())
                .using(clientConfiguration())
                .build("testing client " + clientId);
    }

    private static JerseyClientConfiguration clientConfiguration() {
        JerseyClientConfiguration configuration = new JerseyClientConfiguration();
        configuration.setTimeout(Duration.seconds(5));
        return configuration;
    }

}
