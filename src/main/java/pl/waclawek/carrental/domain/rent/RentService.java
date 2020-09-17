package pl.waclawek.carrental.domain.rent;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.waclawek.carrental.domain.user.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentService {

    private final RentRepository repository;


    public void create(Rent rent){
        repository.create(rent);
    }

   public List<Rent> getAll(){
       return repository.getAll();
    }
    
    public List<Rent> getAllByClientId(int id){
        List<Rent> rents = repository.getAll();

        for (Rent rent : rents) {
            if(!Integer.valueOf(rent.getClientId()).equals(id)){
                rents.remove(rent);
            }
        }
        return rents;

    }

}
