package tn.enis.member;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.AllArgsConstructor;
import tn.enis.member.entity.EnseignantChercheur;
import tn.enis.member.entity.Etudiant;
import tn.enis.member.repository.MemberRepository;
import tn.enis.member.service.IMemberService;
@EnableDiscoveryClient
@SpringBootApplication
@AllArgsConstructor
public class MemberServiceApplication implements CommandLineRunner {
    private  MemberRepository membreRepository;
    private IMemberService iMemberService;
  
    public static void main(String[] args) {
        SpringApplication.run(MemberServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        EnseignantChercheur encadrant = EnseignantChercheur.builder()
                .cin("12345678")
                .nom("Slim")
                .prenom("Kenoun")
                .dateNaissance(new Date())
                .email("slim.kenoun@enis.tn")
                .password("password123")
                .grade("Professor")
                .etablissement("ENIS")
                .build();

        membreRepository.save(encadrant);

        Etudiant etudiant = Etudiant.builder()
                .cin("11158486")
                .nom("Mohamed")
                .prenom("Charfi")
                .dateNaissance(new Date())
                .email("mohamed.charfi@enis.tn")
                .password("password456")
                .dateInscription(new Date())
                .diplome("Engineering")
                .sujet("DevOps")
                .encadrant(encadrant)
                .build();


        membreRepository.save(etudiant);

        
        System.out.println("Saved Student: " + etudiant.getNom() + " " + etudiant.getPrenom());
        iMemberService.affecteEtudiantToEnseignat(2L, 1L);
        
    }
    
    
}
