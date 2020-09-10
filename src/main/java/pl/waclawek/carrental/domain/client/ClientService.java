package pl.waclawek.carrental.domain.client;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;
import pl.waclawek.carrental.domain.car.CarRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public void create(Client client){
        clientRepository.create(client);
    }

    public List<Client> findAll(){
        return clientRepository.getAll();
    }

    public void update(Client client){
        clientRepository.update(client);
    }

    public Client getOneById(int id){
        return clientRepository.getOne(id)
                .orElseThrow(() -> new IllegalArgumentException("Client with given id not exists"));
    }
}
