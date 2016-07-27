package ca.nexapp.starterkit.infrastructure.persistence.json.users;

import ca.nexapp.starterkit.domain.users.UserFactory;
import ca.nexapp.starterkit.domain.users.UserFactoryTest;
import ca.nexapp.starterkit.infrastructure.persistence.inmemory.users.UserInMemory;

public class UserJsonFactoryTest extends UserFactoryTest<UserInMemory> {

    @Override
    protected UserFactory createFactory() {
        return new UserJsonFactory();
    }

    @Override
    protected Class<UserInMemory> instanceOf() {
        return UserInMemory.class; // no need to create a class UserJson, the InMemory fits pretty great
    }

}
