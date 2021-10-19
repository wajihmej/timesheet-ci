package tn.esprit.spring.services;

import java.util.List;

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
	
			l.info("In retrieveAllUsers() : ");
			contrats = (List<Contrat>) contratRepository.findAll();  
			for (Contrat contrat : contrats) {
				l.debug("contrats +++ : " + contrat);
			} 
			l.info("Out of retrieveAllUsers() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllUsers() : " + e);
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
	public void deleteContrat(String id) {
		contratRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Contrat retrieveContrat(String id) {
		Contrat c = null;
		try{
			c =  contratRepository.findById(Long.parseLong(id)).get(); 
			l.info("Contrat returned : " + c);

		}catch (Exception e) {
			// TODO: handle exception
			l.error("error in retrieveUser() : "+e);
		}
		return c; 

	}

}
