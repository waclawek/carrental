package pl.waclawek.carrental.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.waclawek.carrental.external.user.UserEntity;

import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(User user){
        if(userRepository.getByUsername(user.getUsername()).isPresent()){
            throw new IllegalStateException("User with this username already exists");
        }

        user.encodePassword(passwordEncoder, user.getPassword());
        userRepository.create(user);
    }

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public int getIdByUsername(String username){
        Optional<User> userOptional = userRepository.getByUsername(username);
        if(userOptional.isPresent()){
            return userOptional.get().getId();
        }
        throw new InvalidParameterException("no user with this username");
    }


    private void deleteById(int id){
        userRepository.deleteById(id);
    }
}
