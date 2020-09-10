package pl.waclawek.carrental.external.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositoryJPA extends JpaRepository<ClientEntity, Integer> {
}
