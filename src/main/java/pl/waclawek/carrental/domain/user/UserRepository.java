package pl.waclawek.carrental.domain.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void create(User user);

    Optional<User> getUserById(int id);

    Optional<User> getByUsername(String username);

    List<User> getAll();

    void deleteById(int id);
}
