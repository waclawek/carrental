package pl.waclawek.carrental.external.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.waclawek.carrental.domain.car.Car;
import pl.waclawek.carrental.domain.user.User;
import pl.waclawek.carrental.domain.user.UserRepository;
import pl.waclawek.carrental.external.car.CarEntity;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataBaseUserRepository implements UserRepository {
    private final UserRepositoryJPA userRepositoryJPA;


    @Override
    public void create(User user) {
        UserEntity userEntity = UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
        userRepositoryJPA.save(userEntity);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.of(userRepositoryJPA.getOne(id)).stream().map(mapToDomain()).findFirst();
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepositoryJPA.findAll().stream()
                .map(mapToDomain())
                .filter(user -> user.getUsername().equals(username))
                .findFirst();

    }

    private Function<UserEntity, User> mapToDomain(){
        return userEntity -> new User(userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getRole());

    }

    @Override
    public List<User> getAll() {
        return userRepositoryJPA.findAll().stream()
                .map(mapToDomain())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        userRepositoryJPA.deleteById(id);
    }
}
