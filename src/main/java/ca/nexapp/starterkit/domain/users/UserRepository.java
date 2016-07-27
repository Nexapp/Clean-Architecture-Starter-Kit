package ca.nexapp.starterkit.domain.users;

public interface UserRepository {

    void add(User user) throws UserAlreadyExistException;

    void remove(User user) throws UserNotFoundException;

    User findByEmail(String email) throws UserNotFoundException;

    void clear();
}
