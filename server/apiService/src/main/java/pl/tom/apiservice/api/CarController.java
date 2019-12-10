package pl.tom.apiservice.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tom.apiservice.model.Car;
import pl.tom.apiservice.model.CarRepository;

import java.util.List;

@RestController
public class CarController {

    private CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @RequestMapping("/cars")
    public List<Car> getCars() {
        return carRepository.findAll();
    }
}
