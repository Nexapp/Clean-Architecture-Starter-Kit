package ca.nexapp.starterkit.domain.users;

public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = 7583127080013322730L;

    public UserNotFoundException(User user) {
        this(user.getEmail());
    }

    public UserNotFoundException(String email) {
        super(email + " cannot be found");
    }

}
