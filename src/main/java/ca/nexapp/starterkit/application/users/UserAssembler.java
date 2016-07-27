package ca.nexapp.starterkit.application.users;

import ca.nexapp.starterkit.domain.users.User;

public class UserAssembler {

    public UserResponse assembleToDTO(User user) {
        return new UserResponse(user.getEmail(), user.getUsername());
    }
}
