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

public class Facture {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idFacture")
	private Long idFacture;
	
	@Column(name="montantRemise")
	private float montantRemise;
	
	@Column(name="montantFacture")
	private float montantFacture;
	
	@Column(name="dateFacture")
	private Date dateFacture;
	
	@Column(name="active")
	private Boolean active;
	
	@ManyToOne
	private Client client;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	private Set<DetailFacture> detailsFactures;
	
	
	
	
	

}
