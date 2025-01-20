package sn.api.devoirspring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.api.devoirspring.data.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByTelephone(String telephone);
}
