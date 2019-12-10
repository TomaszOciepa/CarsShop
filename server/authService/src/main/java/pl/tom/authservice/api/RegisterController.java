package pl.tom.authservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.tom.authservice.service.UserService;
import pl.tom.authservice.model.User;

@RestController
public class RegisterController {

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String addUser(@RequestBody User user) {
        if (userService.usernameExists(user)) {
            return "username is taken";
        } else {
            userService.save(user);
            return "user account created";
        }
    }
}
