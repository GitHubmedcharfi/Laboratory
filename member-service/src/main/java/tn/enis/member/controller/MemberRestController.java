package tn.enis.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tn.enis.member.entity.EnseignantChercheur;
import tn.enis.member.entity.Etudiant;
import tn.enis.member.entity.Member;
import tn.enis.member.service.IMemberService;

@AllArgsConstructor
@RestController
public class MemberRestController {

	IMemberService iMemberService;

	@PostMapping(value = "/membres/etudiant")
	public Member addMember(@RequestBody Etudiant etd) {
		return iMemberService.addMember(etd);
	}

	@PostMapping(value = "/membres/enseignat")
	public Member addMember(@RequestBody EnseignantChercheur ens) {
		return iMemberService.addMember(ens);
	}

	@GetMapping(value = "/membres/search/cin")
	public Member findOneMemberByCin(@RequestParam String cin) {
		return iMemberService.findByCin(cin);
	}

	@GetMapping(value = "/membres/search/email")
	public Member findOneMemberByEmail(@RequestParam String email) {
		return iMemberService.findByEmail(email);
	}

	@RequestMapping(value = "/membres", method = RequestMethod.GET)
	public List<Member> findMembres() {
		return iMemberService.findAll();
	}

	@GetMapping(value = "/membres/{id}")
	public Member findOneMemberById(@PathVariable Long id) {
		return iMemberService.findMember(id);
	}

	@DeleteMapping(value = "/membres/{id}")
	public void deleteMembre(@PathVariable Long id) {
		if (iMemberService.findMember(id) != null) {
			iMemberService.deleteMember(id);
		}
	}

	@PutMapping(value = "/membres/etudiant/{id}")
	public Member updatemembre(@PathVariable Long id, @RequestBody Etudiant p) {
		if (iMemberService.findMember(id) != null) {
			p.setId(id);
		}
		return p;
	}

	@PutMapping(value = "/membres/enseignant/{id}")
	public Member updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p) {
		if (iMemberService.findMember(id) != null) {
			p.setId(id);
			return iMemberService.updateMember(p);
		}
		return p;	}
	@PostMapping(value = "/membres/affecter/{idEtd}/{idEns}")
	public void affecterEtudiantToEnseignant(@PathVariable Long idEtd, @PathVariable Long idEns) {
	    iMemberService.affecteEtudiantToEnseignat(idEtd, idEns);
	}

}
