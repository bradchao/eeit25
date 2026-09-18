package tw.brad.hibernate.tutor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import tw.brad.hibernate.entity.Account;
import tw.brad.hibernate.entity.AccountInfo;

public class Brad17 {
	public static void main(String[] args) {
		EntityTransaction transaction = null;
		try(EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("brad");
			EntityManager em = emf.createEntityManager();){
			
			transaction = em.getTransaction();
			transaction.begin();
			
			Account account = em.find(Account.class, 7);
			em.remove(account);
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction!=null && transaction.isActive()) {
				transaction.rollback();
			}
			System.out.println(e);
		}		
	}
}
