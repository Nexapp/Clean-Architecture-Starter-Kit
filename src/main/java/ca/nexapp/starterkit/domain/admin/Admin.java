package ca.nexapp.starterkit.domain.admin;

import java.security.Principal;

import ca.nexapp.core.authentication.Authenticable;
import ca.nexapp.core.authentication.Password;

public class Admin implements Authenticable, Principal {

    public static final String PRINCIPAL_NAME = "admin-principal";

    private final String email;
    private Password password;

    public Admin(String email, Password password) {
        this.email = email;
        this.password = password;
    }

    public boolean hasEmail(String email) {
        return this.email.equalsIgnoreCase(email);
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Password getPassword() {
        return password;
    }

    @Override
    public void setPassword(Password password) {
        this.password = password;
    }

    @Override
    public String getName() {
        return PRINCIPAL_NAME;
    }

}
