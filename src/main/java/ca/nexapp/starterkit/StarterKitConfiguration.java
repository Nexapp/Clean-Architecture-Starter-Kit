package ca.nexapp.starterkit;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class StarterKitConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    public String template;

    @NotEmpty
    @JsonProperty
    public String defaultName = "Stranger";

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;
}
