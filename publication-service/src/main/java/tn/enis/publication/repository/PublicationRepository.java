package tn.enis.publication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import tn.enis.publication.entities.Publication;
@RepositoryRestController
public interface PublicationRepository extends JpaRepository<Publication, Long> {

    List<Publication> findByTitre(String titre);
    List<Publication> findByLieu(String lieu);
    List<Publication> findByType(String type);
    List<Publication> findBySourcePdf(String sourcePdf);
    List<Publication> findByLien(String lien);
}