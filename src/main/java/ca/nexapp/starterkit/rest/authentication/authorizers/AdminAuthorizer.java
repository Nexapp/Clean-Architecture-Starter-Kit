package ca.nexapp.starterkit.rest.authentication.authorizers;

import ca.nexapp.starterkit.domain.admin.Admin;
import io.dropwizard.auth.Authorizer;

public class AdminAuthorizer implements Authorizer<Admin> {

    @Override
    public boolean authorize(Admin admin, String role) {
        return role.equalsIgnoreCase(Admin.PRINCIPAL_NAME);
    }

}
