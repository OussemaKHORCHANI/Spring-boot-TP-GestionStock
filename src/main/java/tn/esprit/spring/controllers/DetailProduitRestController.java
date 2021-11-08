package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.service.DetailProduitService;

@RestController
@RequestMapping("/detailProduit")
public class DetailProduitRestController {
	
	@Autowired
	DetailProduitService detailProduitService;
	
	@GetMapping("/getAllDetailsProduits")
	public List<DetailProduit> getAllDetailsProduits(){
		return detailProduitService.retrieveAllDetailProduits();
	}
	
	@GetMapping("/getOneDetailProduit/{id}")
	public DetailProduit getOneDetailProduit(@PathVariable("id") Long id) {
		return detailProduitService.retrieveDetailProduit(id);
	}
	
	@PostMapping("/addDetailProduit")
	public DetailProduit addDetailProduit(@RequestBody DetailProduit detailProduit) {
		return detailProduitService.addDetailProduit(detailProduit);
	}
	
	@PutMapping("/updateDetailProduit")
	public DetailProduit updateDetailProduit(@RequestBody DetailProduit detailProduit) {
		return detailProduitService.updateDetailProduit(detailProduit);
	}

}
