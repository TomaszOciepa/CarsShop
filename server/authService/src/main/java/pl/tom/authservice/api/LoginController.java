package pl.tom.authservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tom.authservice.auth.TokenGenerator;
import pl.tom.authservice.model.Credentials;
import pl.tom.authservice.model.User;
import pl.tom.authservice.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
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
    public Credentials login(@RequestBody User client, HttpServletResponse response) throws IOException {
        Credentials credentials = new Credentials();

        if (userService.usernameExists(client)) {
            Optional<User> user = userService.findByUsername(client.getUsername());
            if(client.getPassword().equals(user.get().getPassword())) {
                 credentials.setUser(user.get());
                 credentials.setToken(tokenGenerator.get(user.get()));
                return credentials;
            } else {
                response.sendError(403, "Incorrect login or password");
                return credentials;
            }
        } else {
            response.sendError(403, "Incorrect login or password");
            return credentials;
        }
    }

}
