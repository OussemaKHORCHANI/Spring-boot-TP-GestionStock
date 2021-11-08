package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.service.RayonService;

@RestController
@RequestMapping("/rayon")
public class RayonRestController {
	
	@Autowired
	RayonService rayonService;
	
	// http://localhost:8081/SpringMVC/rayon/retrieveProduit/{id}
	@GetMapping("/retrieveRayon/{id}")
	public Rayon retrieveRayon(@PathVariable("id") Long id){
		return rayonService.retrieveRayon(id);
	}

}
