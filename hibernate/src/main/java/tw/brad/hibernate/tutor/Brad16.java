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

public class Brad16 {
	public static void main(String[] args) {
		EntityTransaction transaction = null;
		try(EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("brad");
			EntityManager em = emf.createEntityManager();){
			
			transaction = em.getTransaction();
			transaction.begin();
			
			Account account = em.find(Account.class, 1);
			AccountInfo info = account.getAccountinfo();
			
			Path path = Path.of("dir1/ball3.png");
			byte[] data = Files.readAllBytes(path);
			info.setIcon(data);
			
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction!=null && transaction.isActive()) {
				transaction.rollback();
			}
			System.out.println(e);
		}		
	}
}
