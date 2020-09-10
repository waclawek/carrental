package pl.waclawek.carrental.web.rent;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.waclawek.carrental.domain.rent.Rent;
import pl.waclawek.carrental.domain.rent.RentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rent")
public class RentEndpoint {

    private final RentService rentService;

    @GetMapping
    public List<Rent> getAllRents(){
        return rentService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addRent(@RequestBody Rent rent){
        rentService.create(rent);
    }

}
