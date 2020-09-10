package pl.waclawek.carrental.web.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.waclawek.carrental.domain.client.Client;
import pl.waclawek.carrental.domain.client.ClientService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientEndpoint {

    private final ClientService clientService;

    @GetMapping
    List<Client> getAllClients(){
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    Client getOneById(@PathVariable int id){
        return clientService.getOneById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createPatient(@RequestBody Client client){
        clientService.create(client);
    }
}
