package pl.tom.carsshop.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello";
    }
}
