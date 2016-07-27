package ca.nexapp.starterkit.infrastructure.persistence.inmemory.users;

import java.util.Objects;

import ca.nexapp.starterkit.domain.users.User;

public class UserInMemory extends User {

    private final String email;
    private final String username;

    public UserInMemory(String email, String username) {
        this.email = email;
        this.username = username;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, username);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UserInMemory)) {
            return false;
        }

        UserInMemory other = (UserInMemory) obj;
        return Objects.equals(email, other.email)
                && Objects.equals(username, other.username);
    }

    @Override
    public String toString() {
        return email;
    }

}
