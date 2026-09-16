package tw.brad.hibernate.tutor;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tw.brad.hibernate.entity.Account;

public class Brad06 {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("brad");
		EntityManager em = emf.createEntityManager();
		
		// JPQL
		Account account = em.createQuery(
							"SELECT a FROM Account a WHERE a.email= :email", Account.class)
							.setParameter("email", "brad@brad.tw")
							.getSingleResult();
		
		System.out.println(account.getName());
		
		em.close();
		emf.close();		
		
	}

}
