package pl.tom.authservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tom.authservice.auth.TokenGenerator;
import pl.tom.authservice.model.User;
import pl.tom.authservice.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public Optional<User> login(@RequestBody User client, HttpServletRequest request, HttpServletResponse response) {


        if (userService.usernameExists(client)) {
            Optional<User> user = userService.findByUsername(client.getUsername());
            if (client.getPassword().equals(user.get().getPassword())) {
                user.get().setToken(tokenGenerator.get(user.get()));
                Optional<User> credentials = Optional.of(user.get());
                return credentials;
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                Optional<User> credentials = Optional.empty();
                return credentials;
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            Optional<User> credentials = Optional.empty();
            return credentials;
        }
    }

}
