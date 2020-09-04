package pl.waclawek.carrental.domain.car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {

    void create(Car car);

    Optional<Car> getOne(int id);

    List<Car> getAll();

    void update(Car car);

    void delete(int id);
}
