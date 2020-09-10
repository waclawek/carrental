package pl.waclawek.carrental.external.rent;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.waclawek.carrental.domain.car.CarService;
import pl.waclawek.carrental.domain.rent.Rent;
import pl.waclawek.carrental.domain.rent.RentRepository;
import pl.waclawek.carrental.external.car.CarRepositoryJPA;
import pl.waclawek.carrental.external.client.ClientRepositoryJPA;
import pl.waclawek.carrental.external.client.DataBaseClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataBaseRepository implements RentRepository{

    private final RentRepositoryJPA rentRepositoryJPA;
    private final CarRepositoryJPA carRepositoryJPA;
    private final ClientRepositoryJPA clientRepositoryJPA;


    @Override
    public void create(Rent rent) {
        RentEntity rentEntity = RentEntity.builder()
                .id(rent.getId())
                .rentStart(rent.getRentStart())
                .rentEnd(rent.getRentEnd())
                .rentedCar(carRepositoryJPA.getOne(rent.getCarId()))
                .client(clientRepositoryJPA.getOne(rent.getClientId()))
                .build();

        rentRepositoryJPA.save(rentEntity);
    }

    @Override
    public Optional<Rent> getOne(int id) {
        return Optional.empty();
    }

    @Override
    public List<Rent> getAll() {
        return rentRepositoryJPA.findAll()
                .stream()
                .map(mapByDomain())
                .collect(Collectors.toList());
    }

    private Function<RentEntity, Rent> mapByDomain() {
        return rE -> new Rent(rE.getId(),
                rE.getRentStart(),
                rE.getRentEnd(),
                rE.getRentedCar().getId(),
                rE.getClient().getId());
    }

    @Override
    public void update(Rent rent) {

    }

    @Override
    public void delete(int id) {

    }
}
