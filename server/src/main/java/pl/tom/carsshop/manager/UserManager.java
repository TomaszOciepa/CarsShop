package pl.tom.carsshop.manager;

import org.springframework.stereotype.Service;
import pl.tom.carsshop.model.User;
import pl.tom.carsshop.model.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserManager {

    private UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findAll().stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }
}
