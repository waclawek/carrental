package pl.waclawek.carrental.domain.rent;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.waclawek.carrental.domain.car.Car;
import pl.waclawek.carrental.domain.client.Client;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rent {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentEnd;
    private int carId;
    private int clientId;

}
