package ca.nexapp.starterkit.infrastructure.persistence.admin;

import ca.nexapp.starterkit.domain.admin.AdminRepository;
import ca.nexapp.starterkit.domain.admin.AdminRepositoryTest;

public class AdminInMemoryRepositoryTest extends AdminRepositoryTest {

    @Override
    protected AdminRepository createRepository() {
        return new AdminInMemoryRepository();
    }

}
