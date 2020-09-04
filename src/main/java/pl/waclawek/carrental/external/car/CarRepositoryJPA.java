package pl.waclawek.carrental.external.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepositoryJPA extends JpaRepository<CarEntity, Integer> {
}
