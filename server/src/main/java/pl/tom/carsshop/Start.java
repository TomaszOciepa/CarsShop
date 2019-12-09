package pl.tom.carsshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.tom.carsshop.model.*;

@Component
public class Start {

    private UserRepository userRepository;
    private CarRepository carRepository;

    @Autowired
    public Start(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run(){
        User user = new User("user", "user123", "USER");
        userRepository.save(user);

        User admin = new User("admin", "admin123", "ADMIN");
        userRepository.save(admin);

        Car car1 = new Car("BMW", "X5", 200500);
        carRepository.save(car1);
        Car car2 = new Car("MERCEDES", "GLE", 300500);
        carRepository.save(car2);
        Car car3 = new Car("AUDI", "Q7", 200300);
        carRepository.save(car3);
    }
}
