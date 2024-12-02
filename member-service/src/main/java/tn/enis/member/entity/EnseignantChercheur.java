package tn.enis.member.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@Entity 
@DiscriminatorValue("ens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class EnseignantChercheur extends Member implements Serializable {
	private String grade;
	private String etablissement ;
	public EnseignantChercheur(@NonNull String cin, @NonNull String nom, @NonNull String prenom,
			@NonNull Date dateNaissance, @NonNull String email, @NonNull String password, String grade,
			String etablissement) {
		super(cin, nom, prenom, dateNaissance, email, password);
		this.grade = grade;
		this.etablissement = etablissement;
	}
	

}
