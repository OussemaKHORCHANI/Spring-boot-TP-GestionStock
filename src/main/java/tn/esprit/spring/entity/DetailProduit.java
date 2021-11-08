package tn.esprit.spring.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString

public class DetailProduit {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailProduit")
	private Long idDetailProduit;
	
	@NonNull
	@Column(name="dateCreation")
	private Date dateCreation;
	
	@Column(name="dateDerniereModification")
	private String dateDerniereModification;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="categorieProduit")
	private CategorieProduit categorieProduit;
	
	@OneToOne(mappedBy="detailProduit")
	private Produit produit;

	
	
	
	
	
	
}
