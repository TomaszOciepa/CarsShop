package pl.tom.carsshop.manager;

import org.springframework.stereotype.Service;
import pl.tom.carsshop.model.User;
import pl.tom.carsshop.model.UserRepository;
import java.util.Optional;

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
