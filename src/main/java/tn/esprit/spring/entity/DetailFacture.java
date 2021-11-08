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

public class DetailFacture {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailFacture")
	private Long idDetailFacture;
	
	@Column(name="qte")
	private int qte;
	
	@Column(name="prixTotal")
	private float prixTotal;
	
	@Column(name="pourcentageRemise")
	private int pourcentageRemise;
	
	@Column(name="montantRemise")
	private float montantRemise;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="detailFacture")
	private Set<Produit> produits;
	
	@ManyToOne
	private Facture facture;

	
	
	
	
	

}
