package pl.tom.carsshop.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tom.carsshop.model.Car;
import pl.tom.carsshop.model.CarRepository;

import java.util.List;

@RestController
public class CarController {

    private CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @RequestMapping("/test")
    public String test(){
        return "TEST is working";
    }

    @RequestMapping("/cars")
    public List<Car> getCars(){
        return carRepository.findAll();
    }
}
