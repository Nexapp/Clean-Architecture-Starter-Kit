package ca.nexapp.starterkit.configurations;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class StarterKitConfiguration extends io.dropwizard.Configuration {

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

}
