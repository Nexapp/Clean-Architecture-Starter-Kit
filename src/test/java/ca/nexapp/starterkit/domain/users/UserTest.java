package ca.nexapp.starterkit.domain.users;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class UserTest {

    @Test
    public void givenTheSameEmail_ShouldHaveTheSameEmail() {
        User user = withEmail("john.doe@email.com");

        assertThat(user.hasEmail("john.doe@email.com")).isTrue();
    }

    @Test
    public void givenTheSameEmailButMulticased_ShouldHaveTheSameEmail() {
        User user = withEmail("john.doe@email.com");

        assertThat(user.hasEmail("jOHn.DoE@emAIl.coM")).isTrue();
    }

    @Test
    public void givenADifferentEmail_ShouldNotHaveTheSameEmail() {
        User user = withEmail("john.doe@email.com");

        assertThat(user.hasEmail("dummy@example.org")).isFalse();
    }

    private User withEmail(String email) {
        User user = mock(User.class, CALLS_REAL_METHODS);
        willReturn(email).given(user).getEmail();
        return user;
    }
}
