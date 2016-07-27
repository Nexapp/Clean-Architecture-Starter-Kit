package ca.nexapp.starterkit.domain.users;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Before;
import org.junit.Test;

public abstract class UserFactoryTest<T> {

    private static final String AN_EMAIL = "john.doe@email.com";
    private static final String A_USERNAME = "john.doe";

    private UserFactory userFactory;

    @Before
    public void setUp() {
        userFactory = createFactory();
    }

    @Test
    public void shouldReturnAnInstanceOf() {
        User user = userFactory.create(AN_EMAIL, A_USERNAME);

        assertThat(user).isInstanceOf(instanceOf());
    }

    @Test
    public void canRetrieveTheEmail() {
        User user = userFactory.create(AN_EMAIL, A_USERNAME);

        assertThat(user.getEmail()).isEqualTo(AN_EMAIL);
    }

    @Test
    public void canRetrieveTheUsername() {
        User user = userFactory.create(AN_EMAIL, A_USERNAME);

        assertThat(user.getUsername()).isEqualTo(A_USERNAME);
    }

    protected abstract UserFactory createFactory();

    protected abstract Class<T> instanceOf();
}
