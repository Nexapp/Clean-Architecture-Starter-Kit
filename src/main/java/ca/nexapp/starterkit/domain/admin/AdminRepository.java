package ca.nexapp.starterkit.domain.admin;

import java.util.Optional;

public interface AdminRepository {

    void add(Admin admin);

    Optional<Admin> findByEmail(String email);
}
