package pl.waclawek.carrental.domain.car;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Car {
    private Integer id;
    private String make;
    private String model;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate productionYear;
    private BigDecimal dailyRate;
}
