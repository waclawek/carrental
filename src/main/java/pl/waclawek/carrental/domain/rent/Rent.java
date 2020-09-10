package pl.waclawek.carrental.domain.rent;

import lombok.*;
import pl.waclawek.carrental.domain.car.Car;
import pl.waclawek.carrental.domain.client.Client;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rent {
    private Integer id;
    private LocalDate rentStart;
    private LocalDate rentEnd;
    private int carId;
    private int clientId;

}
