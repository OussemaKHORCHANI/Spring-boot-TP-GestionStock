package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;

@Slf4j
@Service
public class StockService implements IStockService{
	
	@Autowired
	StockRepository stockRepository;

	@Override
	public List<Stock> retrieveAllStocks() {
		return (List<Stock>) stockRepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock u) {
		Stock s = stockRepository.findById(u.getIdStock()).get();
		s.setLibelleStock(u.getLibelleStock());
		s.setQteMin(u.getQteMin());
		s.setQte(u.getQte());
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long id) {
		return stockRepository.findById(id).get();
	}
	
	

}
