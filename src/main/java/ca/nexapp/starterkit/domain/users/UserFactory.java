package ca.nexapp.starterkit.domain.users;

public interface UserFactory {

    User create(String email, String username);

}
