package pl.tom.apiservice.service;

import org.springframework.stereotype.Service;
import pl.tom.apiservice.model.Car;
import pl.tom.apiservice.model.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAll(){
        return carRepository.findAll();
    }

    public Optional<Car> findById(Long id){
        return carRepository.findById(id);
    }

    public void save(Car car){
        carRepository.save(car);
    }

    public void deleteById(Long id){
        carRepository.deleteById(id);
    }
}
