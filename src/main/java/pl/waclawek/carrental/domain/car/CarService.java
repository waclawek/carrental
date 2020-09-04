package pl.waclawek.carrental.domain.car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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



}
