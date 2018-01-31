package ca.nexapp.starterkit.infrastructure.persistence.admin;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import ca.nexapp.starterkit.domain.admin.Admin;
import ca.nexapp.starterkit.domain.admin.AdminRepository;

public class AdminInMemoryRepository implements AdminRepository {

    private final Set<Admin> admins = new CopyOnWriteArraySet<>();

    @Override
    public void add(Admin admin) {
        admins.add(admin);
    }

    @Override
    public Optional<Admin> findByEmail(String email) {
        return admins.stream()
                .filter(admin -> admin.hasEmail(email))
                .findFirst();
    }

}
