package ca.nexapp.starterkit.infrastructure.persistence.inmemory.users;

import ca.nexapp.starterkit.domain.users.User;
import ca.nexapp.starterkit.domain.users.UserFactory;

public class UserInMemoryFactory implements UserFactory {

    @Override
    public User create(String email, String username) {
        return new UserInMemory(email, username);
    }

}
