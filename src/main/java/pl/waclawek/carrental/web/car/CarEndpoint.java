package pl.waclawek.carrental.web.car;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.waclawek.carrental.domain.car.Car;
import pl.waclawek.carrental.domain.car.CarService;


import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarEndpoint {

   private final CarService carService;

    @GetMapping
    List<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    Car getOneById(@PathVariable int id) {
        return carService.findAll().get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createPatient(@RequestBody Car car) {
        carService.create(car);
    }

}
