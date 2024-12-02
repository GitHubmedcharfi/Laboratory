package tn.enis.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enis.member.entity.EnseignantChercheur;
import tn.enis.member.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	List<Etudiant> findByDiplome(String diplome);

	List<Etudiant> findByDiplomeOrderByDateInscriptionDesc(String diplome);
    List<Etudiant> findByEncadrant(EnseignantChercheur ens);
}
