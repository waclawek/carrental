package pl.waclawek.carrental.external.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.waclawek.carrental.domain.user.User;
import pl.waclawek.carrental.domain.user.UserRepository;
import pl.waclawek.carrental.domain.user.UserService;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataBaseUserRepository implements UserRepository {
    private final UserRepositoryJPA userRepositoryJPA;


    @Override
    public void create(User user) {
        UserEntity userEntity = new UserEntity().builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole().toString())
                .build();
        userRepositoryJPA.save(userEntity);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
