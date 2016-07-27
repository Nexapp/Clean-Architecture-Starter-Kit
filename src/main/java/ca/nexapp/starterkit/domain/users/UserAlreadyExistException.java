package ca.nexapp.starterkit.domain.users;

public class UserAlreadyExistException extends Exception {

    private static final long serialVersionUID = -3364390237991330068L;

    public UserAlreadyExistException(User user) {
        super(user + " already exists");
    }
}
