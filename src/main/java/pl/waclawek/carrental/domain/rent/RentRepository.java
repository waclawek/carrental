package pl.waclawek.carrental.domain.rent;

import pl.waclawek.carrental.domain.client.Client;

import java.util.List;
import java.util.Optional;

public interface RentRepository {
    void create(Rent rent);

    Optional<Rent> getOne(int id);

    List<Rent> getAll();

    void update(Rent rent);

    void delete(int id);
}
