package pl.tom.apiservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tom.apiservice.model.User;
import pl.tom.apiservice.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.findAll();
    }

    @PutMapping("/update/name/{id}")
    public String updateName(@PathVariable(value = "id") Long id, @RequestBody User update) {

        if (update.getUsername().length() >= 3 && userService.findById(id).isPresent()) {
            Optional<User> user = userService.findById(id);
            user.get().setUsername(update.getUsername().toLowerCase());
            userService.update(user.get());
            return "Updated";
        } else {
            return "brak użytkownika lub za krótka nazwa";
        }
    }

    @PutMapping("/update/password/{id}")
    public String updatePassword(@PathVariable(value = "id") Long id, @RequestBody User update) {

        if (update.getPassword().length() >= 6 && userService.findById(id).isPresent()) {
            Optional<User> user = userService.findById(id);
            user.get().setPassword(update.getPassword());
            userService.update(user.get());
            return "Updated";
        } else {
            return "brak użytkownika lub za krótkie hasło";
        }
    }

    @PutMapping("/update/role/{id}")
    public String updateRole(@PathVariable(value = "id") Long id, @RequestBody User update) {

        if (update.getRole().equals("ADMIN") || update.getRole().equals("USER") && userService.findById(id).isPresent()) {
            Optional<User> user = userService.findById(id);
            user.get().setRole(update.getRole());
            userService.update(user.get());
            return "Updated Role";
        } else {
            return "brak użytkownika lub niepoprawna ROLA";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Long id){

        if (userService.findById(id).isPresent()){
            userService.deleteById(id);
            return "Delete user";
        }else {
            return "user does not exist";
        }
    }



}
