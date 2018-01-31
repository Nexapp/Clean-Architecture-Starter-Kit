package ca.nexapp.starterkit.rest.modules;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import ca.nexapp.core.authentication.Password;
import ca.nexapp.core.authentication.hashers.PasswordHasher;
import ca.nexapp.core.authentication.salts.SaltGenerator;
import ca.nexapp.starterkit.domain.admin.Admin;
import ca.nexapp.starterkit.domain.admin.AdminRepository;
import ca.nexapp.starterkit.infrastructure.persistence.admin.AdminInMemoryRepository;

public class AdminModule extends AbstractModule {

    @Override
    protected void configure() {

    }

    @Provides
    @Singleton
    public AdminRepository providesAdminRepository(SaltGenerator saltGenerator, PasswordHasher passwordHasher) {
        AdminRepository adminRepository = new AdminInMemoryRepository();
        adminRepository.add(singleAdmin(saltGenerator, passwordHasher));
        return adminRepository;
    }

    private Admin singleAdmin(SaltGenerator saltGenerator, PasswordHasher passwordHasher) {
        Password password = Password.fromPlaintext("qwerty12345", saltGenerator, passwordHasher);
        return new Admin("contact@nexapp.ca", password);
    }

}
