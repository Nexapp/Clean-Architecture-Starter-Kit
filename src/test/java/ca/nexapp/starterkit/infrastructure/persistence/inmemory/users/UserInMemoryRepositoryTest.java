package ca.nexapp.starterkit.infrastructure.persistence.inmemory.users;

import ca.nexapp.starterkit.domain.users.UserFactory;
import ca.nexapp.starterkit.domain.users.UserRepository;
import ca.nexapp.starterkit.domain.users.UserRepositoryTest;

public class UserInMemoryRepositoryTest extends UserRepositoryTest {

    @Override
    protected UserFactory createFactory() {
        return new UserInMemoryFactory();
    }

    @Override
    protected UserRepository createRepository() {
        return new UserInMemoryRepository();
    }

}
