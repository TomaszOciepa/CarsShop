package pl.tom.authservice.service;

import org.springframework.stereotype.Service;
import pl.tom.authservice.model.User;
import pl.tom.authservice.model.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findAll().stream().filter(user -> user.getUsername().equals(username.toLowerCase())).findFirst();
    }

    public void save(User user) {
        user.setUsername(user.getUsername().toLowerCase());
        user.setRole("USER");
        userRepository.save(user);
    }

    public boolean usernameExists(User user) {
        if (!findByUsername(user.getUsername()).isPresent()) {
            return false;
        } else {
            return true;
        }

    }
}
