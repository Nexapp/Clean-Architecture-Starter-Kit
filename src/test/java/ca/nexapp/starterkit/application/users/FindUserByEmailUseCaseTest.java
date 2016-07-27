package ca.nexapp.starterkit.application.users;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import ca.nexapp.starterkit.domain.users.User;
import ca.nexapp.starterkit.domain.users.UserNotFoundException;
import ca.nexapp.starterkit.domain.users.UserRepository;

public class FindUserByEmailUseCaseTest {

    private static final String AN_EMAIL = "john.doe@email.com";

    private UserRepository userRepository;

    private FindUserByEmailUseCase findUserByEmailUseCase;

    @Before
    public void setUp() {
        userRepository = mock(UserRepository.class);

        findUserByEmailUseCase = new FindUserByEmailUseCase(userRepository);
    }

    @Test
    public void givenAnExistingUser_ShouldFindIt() throws UserNotFoundException {
        User user = mock(User.class);
        willReturn(user).given(userRepository).findByEmail(AN_EMAIL);

        User userFound = findUserByEmailUseCase.find(AN_EMAIL);

        assertThat(userFound).isEqualTo(user);
    }

    @Test(expected = UserNotFoundException.class)
    public void givenAnUnexistingUser_ShouldNotFindIt() throws UserNotFoundException {
        willThrow(UserNotFoundException.class).given(userRepository).findByEmail(AN_EMAIL);

        findUserByEmailUseCase.find(AN_EMAIL);
    }
}
