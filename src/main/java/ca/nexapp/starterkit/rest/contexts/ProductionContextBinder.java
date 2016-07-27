package ca.nexapp.starterkit.rest.contexts;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import ca.nexapp.starterkit.application.users.UserAssembler;
import ca.nexapp.starterkit.domain.users.UserFactory;
import ca.nexapp.starterkit.domain.users.UserRepository;
import ca.nexapp.starterkit.infrastructure.persistence.inmemory.users.UserInMemoryFactory;
import ca.nexapp.starterkit.infrastructure.persistence.inmemory.users.UserInMemoryRepository;
import ca.nexapp.starterkit.rest.contexts.filler.DemoUserFiller;

public class ProductionContextBinder extends AbstractBinder {

    @Override
    protected void configure() {
        UserRepository userRepository = new UserInMemoryRepository();
        UserFactory userFactory = new UserInMemoryFactory();
        UserAssembler userAssembler = new UserAssembler();

        bind(userRepository).to(UserRepository.class);
        bind(userFactory).to(UserFactory.class);
        bind(userAssembler).to(UserAssembler.class);

        new DemoUserFiller().fill(userRepository, userFactory);
    }

}
