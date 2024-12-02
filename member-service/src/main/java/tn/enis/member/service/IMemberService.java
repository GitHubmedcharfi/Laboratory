package tn.enis.member.service;

import java.util.List;

import tn.enis.member.entity.EnseignantChercheur;
import tn.enis.member.entity.Etudiant;
import tn.enis.member.entity.Member;

	public interface IMemberService {
		//Crud sur les membres
		public Member addMember(Member m);
		public void deleteMember(Long id) ;
		public Member updateMember(Member p) ;
		public Member findMember(Long id) ;
		public List<Member> findAll();
		//Filtrage par propriété
		public Member findByCin(String cin);
		public Member findByEmail(String email);
		public List<Member> findByNom(String nom);
		//recherche spécifique des étudiants
		public List<Etudiant> findByDiplome(String diplome);
		//recherche spécifique des enseignants
		public List<EnseignantChercheur> findByGrade(String grade);
		public List<EnseignantChercheur> findByEtablissement(String etablissement);
		public void affecteEtudiantToEnseignat(Long idEtd,Long idEns);
		public List<Etudiant> findBuEnseignant(EnseignantChercheur ens);
		}

