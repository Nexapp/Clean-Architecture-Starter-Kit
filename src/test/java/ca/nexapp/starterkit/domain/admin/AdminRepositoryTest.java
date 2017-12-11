package ca.nexapp.starterkit.domain.admin;

import static com.google.common.truth.Truth.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import ca.nexapp.core.authentication.Password;
import ca.nexapp.core.authentication.hashers.SHA512PasswordHasher;
import ca.nexapp.core.authentication.salts.SecureRandomSaltGenerator;

public abstract class AdminRepositoryTest {

    private static final String AN_EMAIL = "john.doe@email.com";

    private AdminRepository adminRepository;

    @Before
    public void setUp() {
        adminRepository = createRepository();
    }

    @Test
    public void canAddAnAdmin() {
        Admin john = anAdmin(AN_EMAIL);
        adminRepository.add(john);

        Optional<Admin> found = adminRepository.findByEmail(AN_EMAIL);

        assertThat(found).isEqualTo(Optional.of(john));
    }

    @Test
    public void givenAnUnexistingAdmin_WhenFindingByEmail_ShouldReturnNoResult() {
        Optional<Admin> found = adminRepository.findByEmail(AN_EMAIL);

        assertThat(found).isEqualTo(Optional.empty());
    }

    private Admin anAdmin(String email) {
        Password password = Password.fromPlaintext("qwerty12345", new SecureRandomSaltGenerator(), new SHA512PasswordHasher());
        return new Admin(email, password);
    }

    protected abstract AdminRepository createRepository();
}
