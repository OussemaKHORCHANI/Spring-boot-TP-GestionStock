package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.service.FactureService;

@RestController
@RequestMapping("/facture")
public class FactureRestController {
	
	@Autowired
	FactureService factureService;
	
	// http://localhost:8081/SpringMVC/facture/retrieve-all-factures
	@GetMapping("/retrieveAllFactures")
	public List<Facture> retrieveAllFactures(){
		return factureService.retrieveAllFactures();
	}
	
	// http://localhost:8081/SpringMVC/facture/cancelfacture/{id}
	@PutMapping("/cancelFacture/{id}")
	public Facture cancelFacture(@PathVariable("id") Long id) {
		factureService.cancelFacture(id);
		return factureService.retrieveFacture(id);
	}

}
