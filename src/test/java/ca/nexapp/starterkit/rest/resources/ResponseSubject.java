package ca.nexapp.starterkit.rest.resources;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

public class ResponseSubject extends Subject<ResponseSubject, Response> {

    public static final Subject.Factory<ResponseSubject, Response> RESPONSE = new Subject.Factory<ResponseSubject, Response>() {

        @Override
        public ResponseSubject createSubject(FailureMetadata metadata, Response actual) {
            return new ResponseSubject(metadata, actual);
        }

    };

    public ResponseSubject(FailureMetadata metadata, Response subject) {
        super(metadata, subject);
    }

    public void hasStatus(Status... statuses) {
        List<Integer> codes = Stream.of(statuses).map(s -> s.getStatusCode()).collect(Collectors.toList());
        assertThat(actual().getStatus()).isIn(codes);
    }

    public void isOk() {
        hasStatus(Status.OK, Status.NO_CONTENT);
    }

    public void isABadRequest() {
        hasStatus(Status.BAD_REQUEST);
    }

    public void isAConflict() {
        hasStatus(Status.CONFLICT);
    }

    public void isUnauthorized() {
        hasStatus(Status.UNAUTHORIZED);
    }

    public void isARequestTooLarge() {
        hasStatus(Status.REQUEST_ENTITY_TOO_LARGE);
    }
}
