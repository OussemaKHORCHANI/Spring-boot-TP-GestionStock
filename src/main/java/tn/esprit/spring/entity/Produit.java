package tn.esprit.spring.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

public class Produit {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	private Long idProduit;
	
	@Column(name="code")
	private String code;
	
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="prixUnitaire")
	private float prixUnitaire;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> fournisseurs;
	
	@ManyToOne
	private Rayon rayon;
	
	@ManyToOne
	private Stock stock;
	
	@OneToOne
	private DetailProduit detailProduit;
	
	@ManyToOne
	private DetailFacture detailFacture;
	
	
	
	
	
	
	
	

}
