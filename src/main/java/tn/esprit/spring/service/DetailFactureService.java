package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.DetailFactureRepository;

@Slf4j
@Service
public class DetailFactureService implements IDetailFactureService{
	
	@Autowired
	DetailFactureRepository detailFactureRepository;

	@Override
	public List<DetailFacture> retrieveAllDetailFactures() {
		return (List<DetailFacture>) detailFactureRepository.findAll();
	}

	@Override
	public DetailFacture addDetailFacture(DetailFacture d) {
		return detailFactureRepository.save(d);
	}

	@Override
	public DetailFacture updateDetailFacture(DetailFacture d) {
		DetailFacture df = detailFactureRepository.findById(d.getIdDetailFacture()).get();
		df.setMontantRemise(d.getMontantRemise());
		df.setPourcentageRemise(d.getPourcentageRemise());
		df.setPrixTotal(d.getPrixTotal());
		df.setQte(d.getQte());
		return detailFactureRepository.save(df);
	}

	@Override
	public DetailFacture retrieveDetailFacture(Long id) {
		return detailFactureRepository.findById(id).get();
	}

}
