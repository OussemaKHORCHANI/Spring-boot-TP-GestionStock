package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.FactureRepository;

@Slf4j
@Service
public class FactureService implements IFactureService{
	
	@Autowired
	FactureRepository factureRepository;

	@Override
	public List<Facture> retrieveAllFactures() {
		return (List<Facture>) factureRepository.findAll();
	}

	@Override
	public void cancelFacture(Long id) {
		Facture f = factureRepository.findById(id).get();
		f.setActive(false);
		factureRepository.save(f);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		return factureRepository.findById(id).get();
	}

}
