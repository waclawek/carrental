package pl.waclawek.carrental.domain.client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    void create(Client client);

    Optional<Client> getOne(int id);

    List<Client> getAll();

    void update(Client client);

    void delete(int id);
}
