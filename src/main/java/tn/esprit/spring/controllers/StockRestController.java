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

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockRestController {
	
	@Autowired
	StockService stockService;
	
	// http://localhost:8081/SpringMVC/stock/retrieve-all-stocks
	@GetMapping("/retrieveAllStocks")
	public List<Stock> retrieveAllStocks(){
		return stockService.retrieveAllStocks();
	}
	// http://localhost:8081/SpringMVC/stock/addStock
	@PostMapping("/addStock")
	public Stock addStock(@RequestBody Stock s) {
		return stockService.addStock(s);
	}
	// http://localhost:8081/SpringMVC/stock/retrieveStock/{id}
	@GetMapping("/retrieveStock/{id}")
	public Stock retrieveStock(@PathVariable("id") Long id) {
		return stockService.retrieveStock(id);
	}
	// http://localhost:8081/SpringMVC/stock/updateStock
	@PutMapping("/updateStock")
	public Stock updateStock(@RequestBody Stock s) {
		return stockService.updateStock(s);
	}
		
}
