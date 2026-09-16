package tw.brad.hibernate.tutor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tw.brad.hibernate.entity.Account;

public class Brad02 {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("brad");
		EntityManager em = emf.createEntityManager();
		//System.out.println("OK");
		
		em.getTransaction().begin();
		
		Account account = new Account();
		account.setName("newjohn");
		account.setEmail("john@brad.tw");
		
		em.persist(account);
		
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
