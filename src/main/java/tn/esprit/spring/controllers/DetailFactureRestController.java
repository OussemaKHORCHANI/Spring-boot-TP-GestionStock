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
import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.service.IDetailFactureService;

@RestController
@RequestMapping("/detailFacture")
public class DetailFactureRestController {
	
	@Autowired
	IDetailFactureService detailFactureService;

	// http://localhost:8081/SpringMVC/detailFacture/retrieve-all-detailFacture
	@GetMapping("/retrieve-all-/detailFacture")
	//@ResponseBody
	public List<DetailFacture> getClients() {
	List<DetailFacture> listDetailFactures = detailFactureService.retrieveAllDetailFactures();
	return listDetailFactures;
	}
	
	
	// http://localhost:8081/SpringMVC/detailFacture/retrieve-detailFacture/8
	@GetMapping("/retrieve-detailFacture/{detailFacture-id}")
	//@ResponseBody
	public DetailFacture retrieveDetailFacture(@PathVariable("detailFacture-id") Long detailFactureId) {
	return detailFactureService.retrieveDetailFacture(detailFactureId);
	}
	
	// http://localhost:8081/SpringMVC/detailFacture/add-detailFacture
	@PostMapping("/add-detailFacture")
	//@ResponseBody
	public DetailFacture addDetailFacture(@RequestBody DetailFacture df)
	{
	DetailFacture detailFacture = detailFactureService.addDetailFacture(df);
	return detailFacture;
	}

	// http://localhost:8081/SpringMVC/detailFacture/modify-detailFacture
	@PutMapping("/modify-detailFacture")
	//@ResponseBody
	public DetailFacture modifyDetailFacture(@RequestBody DetailFacture df) {
	return detailFactureService.updateDetailFacture(df);
	}
	

}
