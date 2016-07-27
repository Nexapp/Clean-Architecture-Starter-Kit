package ca.nexapp.starterkit.domain.users;

public abstract class User {

    public boolean hasEmail(String email) {
        return getEmail().equalsIgnoreCase(email);
    }

    public abstract String getEmail();

    public abstract String getUsername();

}
