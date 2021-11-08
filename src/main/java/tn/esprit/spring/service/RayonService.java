package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.repository.RayonRepository;

@Slf4j
@Service
public class RayonService implements IRayonService{
	
	@Autowired
	RayonRepository rayonRepository;

	@Override
	public Rayon retrieveRayon(Long id) {
		return rayonRepository.findById(id).get();
	}
	
	

}
