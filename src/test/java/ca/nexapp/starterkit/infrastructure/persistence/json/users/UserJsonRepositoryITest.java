package ca.nexapp.starterkit.infrastructure.persistence.json.users;

import ca.nexapp.starterkit.domain.users.UserFactory;
import ca.nexapp.starterkit.domain.users.UserRepository;
import ca.nexapp.starterkit.domain.users.UserRepositoryTest;

public class UserJsonRepositoryITest extends UserRepositoryTest {

    private static final String FILE_PATH = "/ca/nexapp/persistence/json/users.json";

    @Override
    protected UserFactory createFactory() {
        return new UserJsonFactory();
    }

    @Override
    protected UserRepository createRepository() {
        String filePath = getClass().getResource(FILE_PATH).getFile().substring(1);
        return new UserJsonRepository(filePath);
    }

}
