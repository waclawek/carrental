package pl.waclawek.carrental.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.waclawek.carrental.domain.user.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.getByUsername(username)
        .map(user -> new User(user.getUsername(), user.getPassword(), mapRole(user.getRole())))
        .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
    private List<GrantedAuthority> mapRole(String role) {
        //dodajemy prefix ROLE_ - jesli sprawdzamy czy uzytkownik ma role to bez prefixu
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
        return Collections.singletonList(authority);
    }


}
