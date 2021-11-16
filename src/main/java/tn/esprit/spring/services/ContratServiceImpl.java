package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepositor;

@Service
public class ContratServiceImpl implements IContratService {

	@Autowired
	ContratRepositor contratRepository;

	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);

	
	@Override
	public List<Contrat> retrieveAllContrats() { 
		List<Contrat> contrats = null; 
		try {
	
			l.info("In retrieveAllContrats() : ");
			contrats = (List<Contrat>) contratRepository.findAll();  
			for (Contrat contrat : contrats) {
				l.debug("contrats +++ : " + contrat);
			} 
			l.info("Out of retrieveAllContrats() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllContrats() : " + e);
		}

		return contrats;
	}


	@Override
	public Contrat addContrat(Contrat c) {
		return contratRepository.save(c); 
	}

	@Override 
	public Contrat updateContrat(Contrat c) { 
		return contratRepository.save(c);
	}

	@Override
	public void deleteContrat(int id) {
		contratRepository.deleteById(id);
	}

	@Override
	public Contrat retrieveContrat(int id) {
		l.info("Retreiving Contrat object");
		try {
			Optional<Contrat> u = contratRepository.findById(id);
			if (u.isPresent()) {
				return u.get();
			}
		} catch (Exception e) {
			l.error(e);
		}
		return null;

	}

}
