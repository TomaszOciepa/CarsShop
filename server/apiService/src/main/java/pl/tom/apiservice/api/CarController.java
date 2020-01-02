package pl.tom.apiservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tom.apiservice.model.Car;
import pl.tom.apiservice.service.CarService;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/car")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public List<Car> getCars() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getById(@PathVariable(value = "id") Long id) {
        return carService.findById(id);
    }

    @PostMapping("/")
    public String create(@RequestBody Car car) {
        if (car.getMark().length() >= 3 && car.getModel().length() >= 2 && car.getPrice() > 0) {
            carService.save(car);
            return "create new car";
        } else {
            return "Wrong data!";
        }
    }

    @PutMapping("/{id}")
    public String update(@PathVariable(value = "id") Long id, @RequestBody Car carUpdate) {
        Optional<Car> car = carService.findById(id);
        if (car.isPresent()) {
            car.get().setMark(carUpdate.getMark());
            car.get().setModel(carUpdate.getModel());
            car.get().setPrice(carUpdate.getPrice());
            carService.save(car.get());
            return "Car is updated";
        } else {
            return "car does not exist";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        if (carService.findById(id).isPresent()) {
            carService.deleteById(id);
            return "Car is deleted";
        } else {
            return "car does not exist";
        }

    }
}
