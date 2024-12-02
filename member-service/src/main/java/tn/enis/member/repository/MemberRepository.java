package tn.enis.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enis.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	Member findByCin(String cin);

	List<Member> findByNomStartingWith(String caractere);

	Member findByEmail(String email);
	List<Member> findByNom(String nom);

}
