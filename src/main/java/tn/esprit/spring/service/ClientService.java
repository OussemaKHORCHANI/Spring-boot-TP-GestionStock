package tn.esprit.spring.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.ClientRepository;

@Service
@Slf4j
public class ClientService implements IClientService{
	
	@Autowired
	ClientRepository clientRepository;
	
	EntityManager entityManager;

	@Override
	public List<Client> retrieveAllClients() {
		return (List<Client>) clientRepository.findAll();
	}

	@Override
	public Client addClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
		System.out.println("CLIENT DELETED");
	}

	@Override
	public Client updateClient(Client c) {
		Client a = clientRepository.findById(c.getIdClient()).get();
		a.setCategorieClient(c.getCategorieClient());
		a.setDateNaissance(c.getDateNaissance());
		a.setEmail(c.getEmail());
		a.setNom(c.getNom());
		a.setPrenom(c.getPrenom());
		a.setPassword(c.getPassword());
		a.setProfession(c.getProfession());
		return clientRepository.save(a);
	}

	@Override
	public Client retrieveClient(Long id) {
		return clientRepository.findById(id).get();
	}
	

	@Override
	public List<Client> customSelectClient() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Client> query = builder.createQuery(Client.class);
		Root<Client> i = query.from(Client.class);
		query.select(i);
		query.where(builder.between(i.get("dateNaissance"), "01/01/1995", "12/31/1995"));
		return entityManager.createQuery(query).getResultList();
	}

}
