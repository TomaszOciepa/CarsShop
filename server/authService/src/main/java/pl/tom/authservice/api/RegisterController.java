package pl.tom.authservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.tom.authservice.service.UserService;
import pl.tom.authservice.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class RegisterController {

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String addUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        if (userService.usernameExists(user)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "username is taken";
        } else {

            if (user.getUsername().length() < 3 || user.getPassword().length() < 6) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return "required: username min 3 char and password min 6 char";
            } else {
                userService.save(user);
                response.setStatus(HttpServletResponse.SC_OK);
                return "user account created";
            }
        }

    }
}
