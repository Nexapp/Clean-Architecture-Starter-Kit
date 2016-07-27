package ca.nexapp.starterkit.rest.contexts.filler;

import ca.nexapp.starterkit.domain.users.User;
import ca.nexapp.starterkit.domain.users.UserAlreadyExistException;
import ca.nexapp.starterkit.domain.users.UserFactory;
import ca.nexapp.starterkit.domain.users.UserRepository;

public class DemoUserFiller {

    public void fill(UserRepository userRepository, UserFactory userFactory) {
        User johnDoe = userFactory.create("john.doe@email.com", "john.doe");
        User uncleSam = userFactory.create("uncle.sam@example.org", "uncle.sam");

        try {
            userRepository.add(johnDoe);
            userRepository.add(uncleSam);
        } catch (UserAlreadyExistException e) {
            throw new IllegalStateException(e);
        }
    }
}
