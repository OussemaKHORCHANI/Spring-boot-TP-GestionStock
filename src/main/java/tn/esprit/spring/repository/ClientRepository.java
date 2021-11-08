package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
	
	@Query(value = "SELECT c FROM Client c WHERE c.dateNaissance BETWEEN '01/01/1995' AND '12/31/1995'", nativeQuery = true)
	public List<Client> customSelectClient();
	
	@Query("SELECT c FROM Client c WHERE c.dateNaissance between '01/01/1995' and '31/12/1995'")
	public List<Client> retrieveClientsByDate();
}
