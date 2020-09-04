package pl.waclawek.carrental.external.car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.waclawek.carrental.domain.car.Car;
import pl.waclawek.carrental.domain.car.CarRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataBaseCarRepository implements CarRepository {

    CarRepositoryJPA carRepositoryJPA;

    @Override
    public void create(Car car) {
        CarEntity carEntity = CarEntity.builder()
                .make(car.getMake())
                .model(car.getModel())
                .productionDate(car.getProductionDate())
                .dailyRate(car.getDailyRate())
                .build();

        carRepositoryJPA.save(carEntity);
    }

    @Override
    public Optional<Car> getOne(int id) {
        return Optional.empty();
    }

    @Override
    public List<Car> getAll() {
        return carRepositoryJPA.findAll()
                .stream()
                .map(mapToDomain())
                .collect(Collectors.toList());
    }

    private Function<CarEntity, Car> mapToDomain(){
        return carEntity -> new Car(carEntity.getId(),
                carEntity.getMake(),
                carEntity.getModel(),
                carEntity.getProductionDate(),
                carEntity.getDailyRate());

    }

    @Override
    public void update(Car car) {

    }

    @Override
    public void delete(int id) {

    }
}
