package tn.enis.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enis.member.entity.EnseignantChercheur;

public interface EnseignantChercheurRepository extends JpaRepository<EnseignantChercheur, Long> {
	List<EnseignantChercheur> findByGrade(String grade);

	List<EnseignantChercheur> findByEtablissement(String etablissement);
}
