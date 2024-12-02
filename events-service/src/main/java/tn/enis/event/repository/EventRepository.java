package tn.enis.event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import tn.enis.event.entities.Evente;

@RepositoryRestController
public interface EventRepository extends JpaRepository<Evente, Long> {
    List<Evente> findByLieu(String lieu);
    List<Evente> findByTitre(String titre);
}
