package pl.tom.carsshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.tom.carsshop.auth.TokenGenerator;
import pl.tom.carsshop.model.User;
import pl.tom.carsshop.manager.UserManager;

import java.util.Optional;


@RestController
public class LogInController {

    private UserManager userManager;
    private TokenGenerator tokenGenerator;

    @Autowired
    public LogInController(UserManager userManager, TokenGenerator tokenGenerator) {
        this.userManager = userManager;
        this.tokenGenerator = tokenGenerator;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){

        Optional<User> credentials = userManager.findByUsername(user.getUsername());
        if (!credentials.isPresent()) {
            return "Username not found";
        }

        if (user.getPassword().equals(credentials.get().getPassword())){
            return tokenGenerator.get(user);

        }else {
            return "Incorrect password";
        }


    }
}
