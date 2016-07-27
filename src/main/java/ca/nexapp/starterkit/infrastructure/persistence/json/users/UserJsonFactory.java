package ca.nexapp.starterkit.infrastructure.persistence.json.users;

import ca.nexapp.starterkit.domain.users.User;
import ca.nexapp.starterkit.domain.users.UserFactory;
import ca.nexapp.starterkit.infrastructure.persistence.inmemory.users.UserInMemory;

public class UserJsonFactory implements UserFactory {

    @Override
    public User create(String email, String username) {
        return new UserInMemory(email, username);
    }

}
