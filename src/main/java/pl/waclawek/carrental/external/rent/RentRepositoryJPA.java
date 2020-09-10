package pl.waclawek.carrental.external.rent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepositoryJPA extends JpaRepository<RentEntity, Integer> {
}
