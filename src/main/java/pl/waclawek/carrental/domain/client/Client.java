package pl.waclawek.carrental.domain.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// REFACTOR! changed architecture that rent is related to user not Client!
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Integer id;
    private String name;
    private String surname;
    private String peselNo;

}
