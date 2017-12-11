package ca.nexapp.starterkit;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import com.codahale.metrics.health.HealthCheck;

import ca.nexapp.starterkit.domain.admin.Admin;
import ca.nexapp.starterkit.domain.admin.AdminRepository;
import ca.nexapp.starterkit.rest.authentication.authenticators.AdminAuthenticator;
import ca.nexapp.starterkit.rest.authentication.authorizers.AdminAuthorizer;
import ca.nexapp.starterkit.rest.modules.AdminModule;
import ca.nexapp.starterkit.rest.modules.AuthenticationModule;
import ca.nexapp.starterkit.rest.modules.RecipeModule;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class StarterKitApplication extends Application<StarterKitConfiguration> {

    private GuiceBundle<Configuration> guice;

    public static void main(String[] args) throws Exception {
        new StarterKitApplication().run(args);
    }

    @Override
    public String getName() {
        return "CleanArchitecture-StarterKit";
    }

    @Override
    public void initialize(Bootstrap<StarterKitConfiguration> bootstrap) {
        guice = GuiceBundle.builder()
                .enableAutoConfig(getClass().getPackage().getName())
                .modules(new RecipeModule(),
                        new AuthenticationModule(),
                        new AdminModule())
                .build();
        bootstrap.addBundle(guice);
    }

    @Override
    public void run(StarterKitConfiguration configuration, Environment environment) {
        environment.healthChecks().register("health", new HealthCheck() {

            @Override
            protected Result check() throws Exception {
                return Result.healthy();
            }
        });

        environment.jersey().register(new AuthDynamicFeature(adminAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(Admin.class));
    }

    private BasicCredentialAuthFilter<Admin> adminAuthFilter() {
        AdminRepository adminRepository = guice.getInjector().getInstance(AdminRepository.class);

        return new BasicCredentialAuthFilter.Builder<Admin>()
                .setAuthenticator(new AdminAuthenticator(adminRepository))
                .setAuthorizer(new AdminAuthorizer())
                .setRealm("AdminRealm")
                .buildAuthFilter();
    }

}
