package ca.nexapp.starterkit.infrastructure.persistence.inmemory.users;

import java.util.HashSet;
import java.util.Set;

import ca.nexapp.starterkit.domain.users.User;
import ca.nexapp.starterkit.domain.users.UserAlreadyExistException;
import ca.nexapp.starterkit.domain.users.UserNotFoundException;
import ca.nexapp.starterkit.domain.users.UserRepository;

public class UserInMemoryRepository implements UserRepository {

    private final Set<User> users = new HashSet<>();

    @Override
    public void add(User user) throws UserAlreadyExistException {
        boolean added = users.add(user);
        if (!added) {
            throw new UserAlreadyExistException(user);
        }
    }

    @Override
    public void remove(User user) throws UserNotFoundException {
        boolean removed = users.remove(user);
        if (!removed) {
            throw new UserNotFoundException(user);
        }
    }

    @Override
    public User findByEmail(String email) throws UserNotFoundException {
        for (User user : users) {
            if (user.hasEmail(email)) {
                return user;
            }
        }
        throw new UserNotFoundException(email);
    }

    @Override
    public void clear() {
        users.clear();
    }

}
