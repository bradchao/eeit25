package tw.brad.hibernate.tutor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tw.brad.hibernate.entity.Account;

public class Brad03 {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("brad");
		EntityManager em = emf.createEntityManager();
		//System.out.println("OK");
		
		em.getTransaction().begin();
		Account account = em.find(Account.class, 1);
		System.out.println(account.getId());
		System.out.println(account.getEmail());
		System.out.println(account.getName());
		
		account.setName("NewBrad");
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
