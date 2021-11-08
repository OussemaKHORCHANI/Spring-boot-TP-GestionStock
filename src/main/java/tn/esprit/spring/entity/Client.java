package tn.esprit.spring.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idClient")
	private Long idClient;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="dateNaissance")
	private Date dateNaissance;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="categorieClient")
	private CategorieClient categorieClient;
	
	@Column(name="profession")
	private Profession profession;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Facture> factures;
	

	
	
	
	
	

}
