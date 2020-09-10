package pl.waclawek.carrental.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    @NotEmpty(message = "Username have to be filled")
    private String username;
    @NotEmpty(message = "Password have to be filled")
    private String password;
    private ROLE role;

    public void encodePassword(PasswordEncoder passwordEncoder, String providedPassword){
        this.password = passwordEncoder.encode(providedPassword);
    }

}
