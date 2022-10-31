package CRUD.Controller;

import CRUD.Entities.Car;
import CRUD.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @PostMapping("/create")
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable String id) {
        Car car = new Car();
        if(carRepository.existsById(id)) {
            car = carRepository.findById(id).get();
        }
        return car;
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable String id, @RequestParam String type) {
        Optional<Car> findCar = carRepository.findById(id);
        Car car = new Car();
        if(findCar.isPresent()) {
            car = findCar.get();
            car.setType(type);
            carRepository.save(car);
        }
        return car;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCar(@PathVariable String id) {
        if(carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return HttpStatus.NO_CONTENT;
        } else {
            return HttpStatus.CONFLICT;
        }
    }
}
