package ca.nexapp.starterkit;

import ca.nexapp.starterkit.rest.modules.RecipeModule;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class StarterKitApplication extends Application<StarterKitConfiguration> {

    public static void main(String[] args) throws Exception {
        new StarterKitApplication().run(args);
    }

    @Override
    public String getName() {
        return "CleanArchitecture-StarterKit";
    }

    @Override
    public void initialize(Bootstrap<StarterKitConfiguration> bootstrap) {
        GuiceBundle<Configuration> guice = GuiceBundle.builder()
                .enableAutoConfig(getClass().getPackage().getName())
                .modules(new RecipeModule())
                .build();
        bootstrap.addBundle(guice);
    }

    @Override
    public void run(StarterKitConfiguration configuration, Environment environment) {
        // Auto-discovery is enable
    }

}
