package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.ProduitRepository;

@Slf4j
@Service
public class ProduitService implements IProduitService {
	
	@Autowired
	ProduitRepository produitRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		return (List<Produit>) produitRepository.findAll();
	}

	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		RayonService rs = new RayonService();
		Rayon r = rs.retrieveRayon(idRayon);
		StockService ss = new StockService();
		Stock s = ss.retrieveStock(idStock);
		DetailProduitService dps = new DetailProduitService();
		DetailProduit dp = new DetailProduit();
		dp.setDateCreation(new java.sql.Date(System.currentTimeMillis()));
		dp.setCategorieProduit(null);
		p.setRayon(r);
		p.setStock(s);
		p.setDetailProduit(dp);
		produitRepository.save(p);
		dps.addDetailProduit(dp);
		return p;
	}

	@Override
	public Produit retrieveProduit(Long id) {
		return produitRepository.findById(id).get();
	}
	
	

}
