package ca.nexapp.starterkit.domain.users;

import static com.google.common.truth.Truth.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public abstract class UserRepositoryTest {

    private static final String AN_EMAIL = "john.doe@email.com";

    private UserFactory userFactory;
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userFactory = createFactory();
        userRepository = createRepository();
    }

    @Test
    public void canAddAUser() throws UserAlreadyExistException, UserNotFoundException {
        User user = withEmail(AN_EMAIL);

        userRepository.add(user);

        User userFound = userRepository.findByEmail(AN_EMAIL);
        assertThat(userFound).isEqualTo(user);
    }

    @Test(expected = UserAlreadyExistException.class)
    public void cannotAddTheSameUserTwice() throws UserAlreadyExistException {
        User user = withEmail(AN_EMAIL);
        userRepository.add(user);

        userRepository.add(user);
    }

    @Test(expected = UserNotFoundException.class)
    public void canRemoveAUser() throws UserAlreadyExistException, UserNotFoundException {
        User user = withEmail(AN_EMAIL);
        userRepository.add(user);

        userRepository.remove(user);

        userRepository.findByEmail(AN_EMAIL);
    }

    @Test(expected = UserNotFoundException.class)
    public void cannotRemoveANonExistingUser() throws UserNotFoundException {
        User user = withEmail(AN_EMAIL);

        userRepository.remove(user);
    }

    @Test
    public void givenAMulticasedEmail_CanFindTheUserWithItsEmail() throws UserAlreadyExistException, UserNotFoundException {
        User user = withEmail("john.doe@email.com");
        userRepository.add(user);

        User userFound = userRepository.findByEmail("jOHn.doE@emAIl.cOm");

        assertThat(userFound).isEqualTo(user);
    }

    @After
    public void tearDown() {
        userRepository.clear();
    }

    private User withEmail(String email) {
        return userFactory.create(email, "john.doe");
    }

    protected abstract UserFactory createFactory();

    protected abstract UserRepository createRepository();
}
