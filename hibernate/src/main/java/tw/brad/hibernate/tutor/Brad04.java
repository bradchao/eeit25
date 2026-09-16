package tw.brad.hibernate.tutor;

import java.time.LocalDate;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tw.brad.hibernate.entity.Account;

public class Brad04 {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("brad");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Account account = new Account();
		account.setName("Vivian");
		account.setEmail("vivi@brad.tw");
		account.setPasswd(BCrypt.hashpw("12345678", BCrypt.gensalt()));
		account.setBirthday(LocalDate.of(1999, 1, 2));
		account.setEnable(true);
		
		em.persist(account);
		
		em.getTransaction().commit();
		
		System.out.println(account.getId());
		
		
		em.close();
		emf.close();
		
	}

}
