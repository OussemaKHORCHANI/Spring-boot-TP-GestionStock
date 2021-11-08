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

public class Stock {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private long idStock;
	
	@Column(name="qte")
	private int qte;
	
	@Column(name="qteMin")
	private int qteMin;
	
	@Column(name="libelleStock")
	private String libelleStock;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Produit> produits;
	
	

}
