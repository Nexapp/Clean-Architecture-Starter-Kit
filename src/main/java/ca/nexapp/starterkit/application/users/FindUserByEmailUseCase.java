package ca.nexapp.starterkit.application.users;

import ca.nexapp.starterkit.domain.users.User;
import ca.nexapp.starterkit.domain.users.UserNotFoundException;
import ca.nexapp.starterkit.domain.users.UserRepository;

public class FindUserByEmailUseCase {

    private final UserRepository userRepository;

    public FindUserByEmailUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User find(String email) throws UserNotFoundException {
        return userRepository.findByEmail(email);
    }
}
