package ca.nexapp.starterkit.application.users;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import ca.nexapp.starterkit.domain.users.User;

public class UserAssemblerTest {

    private static final String AN_EMAIL = "john.doe@email.com";
    private static final String A_USERNAME = "john.doe";

    private UserAssembler userAssembler;

    @Before
    public void setUp() {
        userAssembler = new UserAssembler();
    }

    @Test
    public void whenAssemblingToDTO_CanAssemblerTheEmail() {
        User user = user(AN_EMAIL, A_USERNAME);

        UserResponse response = userAssembler.assembleToDTO(user);

        assertThat(response.email).isEqualTo(AN_EMAIL);
    }

    @Test
    public void whenAssemblingToDTO_CanAssemblerTheUsername() {
        User user = user(AN_EMAIL, A_USERNAME);

        UserResponse response = userAssembler.assembleToDTO(user);

        assertThat(response.username).isEqualTo(A_USERNAME);
    }

    private User user(String email, String username) {
        User user = mock(User.class);
        willReturn(email).given(user).getEmail();
        willReturn(username).given(user).getUsername();
        return user;
    }
}
