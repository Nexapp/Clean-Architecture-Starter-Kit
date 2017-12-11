package ca.nexapp.starterkit.domain.admin;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import ca.nexapp.core.authentication.Password;
import ca.nexapp.core.authentication.hashers.PasswordHasher;
import ca.nexapp.core.authentication.salts.SaltGenerator;

public class AdminTest {

    @Test
    public void givenTheSameEmail_ShouldHaveIt() {
        Admin admin = anAdmin("john.doe@email.com");

        assertThat(admin.hasEmail("john.doe@email.com")).isTrue();
    }

    @Test
    public void givenADifferentEmail_ShouldNotHaveIt() {
        Admin admin = anAdmin("john.doe@email.com");

        assertThat(admin.hasEmail("uncle.sam@yahoo.ca")).isFalse();
    }

    private Admin anAdmin(String email) {
        Password password = Password.fromPlaintext("qwerty12345", mock(SaltGenerator.class), mock(PasswordHasher.class));
        return new Admin(email, password);
    }
}
