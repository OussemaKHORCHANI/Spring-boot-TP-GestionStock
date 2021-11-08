package tn.esprit.spring;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Profession;
import tn.esprit.spring.service.ClientService;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
class SpringBootDataJpaEntityApplicationTests {
	
	@Autowired
	ClientService clientService;
	
	private static final Logger log = LogManager.getLogger(ClientServiceImplTest.class);
	

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testAddClient() throws ParseException {
		Client u = new Client();
		Client c = Client.builder().nom("TESTING").build();
		u.setPrenom("ahmed");
		u.setNom("Salhi");
		u.setEmail("ahmed@salhi");
		u.setPassword("SA43");
		u.setDateNaissance(new java.sql.Date(System.currentTimeMillis()));
		u.setCategorieClient(CategorieClient.Fidele);
		u.setProfession(Profession.Docteur);
		assertTrue(u.getCategorieClient().equals(CategorieClient.Fidele));
		clientService.addClient(u);
		log.info("CLIENT ADDED : "+ u.toString());
	}
	
	@Test
	public void testDeleteClient() {
		clientService.deleteClient(2L);
	}
	

}
