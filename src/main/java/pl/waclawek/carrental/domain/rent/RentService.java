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
    
    public List<Rent> getAllByUserId(int id){
        List<Rent> rents = repository.getAll();

        for (Rent rent : rents) {
            if(!Integer.valueOf(rent.getUserId()).equals(id)){
                rents.remove(rent);
            }
        }
        return rents;

    }

    public List<Rent> getAllByCarId(int id){
        List<Rent> rents = repository.getAll();

        for (Rent rent : rents) {
            if(!Integer.valueOf(rent.getCarId()).equals(id)){
                rents.remove(rent);
            }
        }
        return rents;

    }

}
