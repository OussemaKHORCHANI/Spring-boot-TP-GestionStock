package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.repository.DetailProduitRepository;

@Slf4j
@Service
public class DetailProduitService implements IDetailProduitService{
	
	@Autowired
	DetailProduitRepository detailProduitRepository;

	@Override
	public List<DetailProduit> retrieveAllDetailProduits() {
		return (List<DetailProduit>) detailProduitRepository.findAll();
	}

	@Override
	public DetailProduit addDetailProduit(DetailProduit d) {
		return detailProduitRepository.save(d);
	}

	@Override
	public DetailProduit updateDetailProduit(DetailProduit d) {
		DetailProduit dp = detailProduitRepository.findById(d.getIdDetailProduit()).get();
		dp.setCategorieProduit(d.getCategorieProduit());
		dp.setDateCreation(d.getDateCreation());
		dp.setDateDerniereModification(d.getDateDerniereModification());
		return detailProduitRepository.save(dp);
	}

	@Override
	public DetailProduit retrieveDetailProduit(Long id) {
		return detailProduitRepository.findById(id).get();
	}

}
