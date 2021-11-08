package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.DetailFacture;

public interface IDetailFactureService {
	
	List<DetailFacture> retrieveAllDetailFactures();

	DetailFacture addDetailFacture(DetailFacture d);

	DetailFacture updateDetailFacture(DetailFacture d);

	DetailFacture retrieveDetailFacture(Long id);

}
