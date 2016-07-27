package ca.nexapp.starterkit.infrastructure.persistence.json.users;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import ca.nexapp.starterkit.domain.users.User;
import ca.nexapp.starterkit.domain.users.UserAlreadyExistException;
import ca.nexapp.starterkit.domain.users.UserNotFoundException;
import ca.nexapp.starterkit.domain.users.UserRepository;
import ca.nexapp.starterkit.infrastructure.persistence.inmemory.users.UserInMemory;

public class UserJsonRepository implements UserRepository {

    private final String filePath;

    public UserJsonRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void add(User user) throws UserAlreadyExistException {
        Set<User> users = readFile();
        boolean added = users.add(user);
        if (!added) {
            throw new UserAlreadyExistException(user);
        }

        writeToFile(users);
    }

    @Override
    public void remove(User user) throws UserNotFoundException {
        Set<User> users = readFile();
        boolean removed = users.remove(user);
        if (!removed) {
            throw new UserNotFoundException(user);
        }

        writeToFile(users);
    }

    @Override
    public User findByEmail(String email) throws UserNotFoundException {
        Set<User> users = readFile();
        for (User user : users) {
            if (user.hasEmail(email)) {
                return user;
            }
        }
        throw new UserNotFoundException(email);
    }

    @Override
    public void clear() {
        writeToFile(new HashSet<>());
    }

    private void writeToFile(Set<User> users) {
        try {
            Path path = Paths.get(filePath);
            String json = gson().toJson(users);
            Files.deleteIfExists(path);
            Files.write(path, json.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private Set<User> readFile() {
        try {
            Path path = Paths.get(filePath);
            String json = new String(Files.readAllBytes(path));
            if (json.isEmpty()) {
                return new HashSet<>();
            }
            return gson().fromJson(json, type());
        } catch (IOException e) {
            return new HashSet<>();
        }
    }

    private Gson gson() {
        return new GsonBuilder().create();
    }

    private Type type() {
        return new TypeToken<Set<UserInMemory>>() {
        }.getType();
    }

}
