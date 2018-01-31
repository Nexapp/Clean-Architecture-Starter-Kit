package ca.nexapp.starterkit.rest.authentication.authenticators;

import java.util.Optional;

import ca.nexapp.starterkit.domain.admin.Admin;
import ca.nexapp.starterkit.domain.admin.AdminRepository;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class AdminAuthenticator implements Authenticator<BasicCredentials, Admin> {

    private final AdminRepository adminRepository;

    public AdminAuthenticator(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Optional<Admin> authenticate(BasicCredentials credentials) throws AuthenticationException {
        Optional<Admin> found = adminRepository.findByEmail(credentials.getUsername());
        if (!found.isPresent()) {
            return Optional.empty();
        }
        Admin admin = found.get();
        if (!admin.matches(credentials.getPassword())) {
            return Optional.empty();
        }
        return found;
    }

}
