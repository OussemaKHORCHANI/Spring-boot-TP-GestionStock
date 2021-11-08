package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.DetailProduit;

public interface IDetailProduitService {
	
	List<DetailProduit> retrieveAllDetailProduits();

	DetailProduit addDetailProduit(DetailProduit d);

	DetailProduit updateDetailProduit(DetailProduit d);

	DetailProduit retrieveDetailProduit(Long id);

}
