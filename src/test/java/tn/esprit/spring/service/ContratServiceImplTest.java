
package tn.esprit.spring.service;

 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.ContratServiceImpl;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.services.UserServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ContratServiceImplTest {
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);
	

		@Autowired
		IContratService cs; 
	
		@Test
		@Order(1)
		public void testRetrieveAllContrats() {
			List<Contrat> listContrats = cs.retrieveAllContrats(); 
			// if there are 7 users in DB : 
			Assertions.assertEquals(3, listContrats.size());			
		}
		
		
		@Test
		@Order(2)
		public void testAddContart() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			Float flo = (float) 15.09;
			Contrat c = new Contrat(d,"CVP", flo); 
			Contrat contratAdded = cs.addContrat(c); 
			Assertions.assertEquals(c.getTypeContrat(), contratAdded.getTypeContrat());
		}
	 
		@Test
		@Order(3)
		public void testModifyUser() throws ParseException   {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			Float flo = (float) 22.09;
			Contrat c = new Contrat(2,d,"CDI", flo); 
			Contrat contratUpdated  = cs.updateContrat(c); 
			Assertions.assertEquals(c.getTypeContrat(), contratUpdated.getTypeContrat());
		}
	
		@Test
		@Order(4)
		public void testRetrieveContrat() {
			Contrat contratRetrieved = cs.retrieveContrat(19); 
			Assertions.assertNotNull(contratRetrieved);
		}
		
		@Test
		@Order(5)
		public void testDeleteContrat() {
			cs.deleteContrat(26);
			Assertions.assertNull(cs.retrieveContrat(26));
		}
		
		
		// 5 tests unitaires  
 
}





