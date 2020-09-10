package pl.waclawek.carrental.domain.rent;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
