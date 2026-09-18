package tw.brad.hibernate.tutor;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import tw.brad.hibernate.entity.Account;
import tw.brad.hibernate.entity.AccountInfo;

public class Brad14 {
	public static void main(String[] args) {
		EntityTransaction transaction = null;
		try(EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("brad");
			EntityManager em = emf.createEntityManager();){
			
			transaction = em.getTransaction();
			transaction.begin();
			
			Account account = new Account();
			account.setEmail("test4@brad.tw");
			account.setName("Test4");
			account.setBirthday(LocalDate.of(1998, 2, 3));
			
			AccountInfo info = new AccountInfo();
			info.setTel("1234567");
			
			account.setAccountinfo(info);
			
			em.persist(account);
			
			
			
			
			
			
			
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction!=null && transaction.isActive()) {
				transaction.rollback();
			}
			System.out.println(e);
		}		
	}
}
