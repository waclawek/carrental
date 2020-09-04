package pl.waclawek.carrental.domain.car;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private Integer id;
    private String make;
    private String model;
    private LocalDate productionDate;
    private BigDecimal dailyRate;
}
