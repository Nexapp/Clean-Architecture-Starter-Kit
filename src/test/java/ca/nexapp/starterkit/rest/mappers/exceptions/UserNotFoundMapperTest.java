package ca.nexapp.starterkit.rest.mappers.exceptions;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.mock;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.Test;

import ca.nexapp.starterkit.domain.users.UserNotFoundException;

public class UserNotFoundMapperTest {

    private UserNotFoundException exception;
    private UserNotFoundMapper mapper;

    @Before
    public void setUp() {
        exception = mock(UserNotFoundException.class);
        mapper = new UserNotFoundMapper();
    }

    @Test
    public void shouldReturnABadRequestStatus() {
        Response response = mapper.toResponse(exception);

        assertThat(response.getStatusInfo()).isEqualTo(Status.BAD_REQUEST);
    }

    @Test
    public void theErrorCodeShouldBeNoUser() {
        Response response = mapper.toResponse(exception);

        String code = ((ErrorException) response.getEntity()).code;
        assertThat(code).isEqualTo("NO_USER");
    }

    @Test
    public void theErrorMessageShouldBeTheExceptionMessage() {
        willReturn("a message").given(exception).getMessage();

        Response response = mapper.toResponse(exception);

        String message = ((ErrorException) response.getEntity()).message;
        assertThat(message).isEqualTo("a message");
    }
}
