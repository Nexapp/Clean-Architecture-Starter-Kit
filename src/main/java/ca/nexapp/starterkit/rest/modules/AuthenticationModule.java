package ca.nexapp.starterkit.rest.modules;

import com.google.inject.AbstractModule;

import ca.nexapp.core.authentication.hashers.PasswordHasher;
import ca.nexapp.core.authentication.hashers.SHA512PasswordHasher;
import ca.nexapp.core.authentication.salts.SaltGenerator;
import ca.nexapp.core.authentication.salts.SecureRandomSaltGenerator;

public class AuthenticationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SaltGenerator.class).to(SecureRandomSaltGenerator.class);
        bind(PasswordHasher.class).to(SHA512PasswordHasher.class);
    }

}
