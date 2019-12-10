package pl.tom.apiservice.service;

import org.springframework.stereotype.Service;
import pl.tom.apiservice.model.User;
import pl.tom.apiservice.model.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();

    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void update(User user) {
        user.setUsername(user.getUsername().toLowerCase());
        userRepository.save(user);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
