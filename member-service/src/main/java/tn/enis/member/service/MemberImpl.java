package tn.enis.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.enis.member.entity.EnseignantChercheur;
import tn.enis.member.entity.Etudiant;
import tn.enis.member.entity.Member;
import tn.enis.member.repository.EnseignantChercheurRepository;
import tn.enis.member.repository.EtudiantRepository;
import tn.enis.member.repository.MemberRepository;
@AllArgsConstructor
@Service
public  class MemberImpl implements IMemberService {
	
	MemberRepository memberRepository;
	EtudiantRepository etudiantRepository;
	EnseignantChercheurRepository enseignantChercheurRepository;

	public Member addMember(Member m) {
		memberRepository.save(m);
		return m;
	}

	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}

	public Member findMember(Long id) {
		Member m = memberRepository.findById(id).get();
		return m;
	}

	public Member updateMember(Member m) {
		return memberRepository.saveAndFlush(m);

	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public Member findByCin(String cin) {
		return memberRepository.findByCin(cin);
	}

	public Member findByEmail(String eamil) {
		return memberRepository.findByEmail(eamil);
	}

	public void affecteEtudiantToEnseignat(Long idEtd, Long idEns) {
		Etudiant etd = etudiantRepository.findById(idEtd).get();
		EnseignantChercheur ens = enseignantChercheurRepository.findById(idEns).get();
		etd.setEncadrant(ens);
		etudiantRepository.save(etd);
	}

	public List<Member> findByNom(String nom) {
		return memberRepository.findByNom(nom);
	}

	public List<Etudiant> findByDiplome(String diplome) {
		return findByDiplome(diplome);
	}

	public List<EnseignantChercheur> findByGrade(String grade) {
		return enseignantChercheurRepository.findByGrade(grade);
	}

	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}
	public List<Etudiant> findBuEnseignant(EnseignantChercheur ens){
		List <Etudiant> lis = etudiantRepository.findByEncadrant(ens);
		return lis;
	}

}
