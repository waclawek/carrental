package pl.waclawek.carrental.external.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.waclawek.carrental.domain.client.Client;
import pl.waclawek.carrental.domain.client.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataBaseClientRepository implements ClientRepository {

    private final ClientRepositoryJPA clientRepositoryJPA;

    @Override
    public void create(Client client) {
        ClientEntity clientEntity = ClientEntity.builder()
                .name(client.getName())
                .surname(client.getSurname())
                .peselNo(client.getPeselNo())
                .build();

        clientRepositoryJPA.save(clientEntity);
    }

    @Override
    public Optional<Client> getOne(int id) {
        return clientRepositoryJPA.findById(id).map(mapToDomain());
    }

    @Override
    public List<Client> getAll() {
        return clientRepositoryJPA.findAll()
                .stream()
                .map(mapToDomain())
                .collect(Collectors.toList());
    }

    private Function<ClientEntity, Client> mapToDomain() {
        return cli -> new Client(
                cli.getId(),
                cli.getName(),
                cli.getSurname(),
                cli.getPeselNo());
    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(int id) {
        clientRepositoryJPA.deleteById(id);

    }
}
