package ca.nexapp.starterkit.rest.mappers.exceptions;

public class ErrorException {

    public String code;
    public String message;

    public ErrorException(String code) {
        this(code, null);
    }

    public ErrorException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
