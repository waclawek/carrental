package pl.waclawek.carrental.external.rent;

import lombok.*;
import pl.waclawek.carrental.domain.car.Car;
import pl.waclawek.carrental.domain.client.Client;
import pl.waclawek.carrental.external.car.CarEntity;
import pl.waclawek.carrental.external.client.ClientEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rents")
public class RentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate rentStart;
    private LocalDate rentEnd;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity rentedCar;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;


}
