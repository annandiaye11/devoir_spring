package sn.api.devoirspring.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.api.devoirspring.data.entities.Commande;

import java.awt.print.Pageable;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    Page<Commande> findByClientId(Long clientId, Pageable pageable);
}
