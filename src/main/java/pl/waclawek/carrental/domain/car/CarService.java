package pl.waclawek.carrental.domain.car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;

    public void create(Car car){
        repository.create(car);
    }

    public List<Car> findAll(){
        return repository.getAll();
    }

    public Car findById(int id){
        return repository.getOne(id).orElseThrow(()-> new IllegalArgumentException("Car with provided id no not exist"));
    }



}
