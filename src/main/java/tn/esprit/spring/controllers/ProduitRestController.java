package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.ProduitService;

@RestController
@RequestMapping("/produit")
public class ProduitRestController {
	
	@Autowired
	ProduitService produitService;
	
	// http://localhost:8081/SpringMVC/produit/retrieve-all-produits
	@GetMapping("/retrieveAllProduits")
	public List<Produit> retrieveAllProduits(){
		return produitService.retrieveAllProduits();
	}
	// http://localhost:8081/SpringMVC/produit/addProduit
	@PostMapping("/addProduit")
	public Produit addProduit(@RequestBody Produit p) {
		return produitService.addProduit(p, p.getRayon().getIdRayon(), p.getStock().getIdStock());
	}
	// http://localhost:8081/SpringMVC/produit/retrieveproduit/{id}
	@GetMapping("/retrieveProduit/{id}")
	public Produit getOneProduit(@PathVariable("id") Long id) {
		return produitService.retrieveProduit(id);
	}

}
