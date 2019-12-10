package pl.tom.authservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tom.authservice.auth.TokenGenerator;
import pl.tom.authservice.model.User;
import pl.tom.authservice.service.UserService;

import java.util.Optional;


@RestController
public class LoginController {

    private UserService userService;
    private TokenGenerator tokenGenerator;

    @Autowired
    public LoginController(UserService userService, TokenGenerator tokenGenerator) {
        this.userService = userService;
        this.tokenGenerator = tokenGenerator;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        if (userService.usernameExists(user)) {
            Optional<User> credentials = userService.findByUsername(user.getUsername());
            if (user.getPassword().equals(credentials.get().getPassword())) {
                return tokenGenerator.get(credentials.get());
            } else {
                return "Incorrect password";
            }
        } else {
            return "Username not found";
        }
    }

}
