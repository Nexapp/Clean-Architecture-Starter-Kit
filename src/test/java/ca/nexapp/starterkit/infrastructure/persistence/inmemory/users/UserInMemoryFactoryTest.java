package ca.nexapp.starterkit.infrastructure.persistence.inmemory.users;

import ca.nexapp.starterkit.domain.users.UserFactory;
import ca.nexapp.starterkit.domain.users.UserFactoryTest;

public class UserInMemoryFactoryTest extends UserFactoryTest<UserInMemory> {

    @Override
    protected UserFactory createFactory() {
        return new UserInMemoryFactory();
    }

    @Override
    protected Class<UserInMemory> instanceOf() {
        return UserInMemory.class;
    }

}
