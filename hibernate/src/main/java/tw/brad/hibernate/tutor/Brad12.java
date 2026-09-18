package tw.brad.hibernate.tutor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import tw.brad.hibernate.entity.Account;
import tw.brad.hibernate.entity.AccountInfo;

public class Brad12 {
	public static void main(String[] args) {
		EntityTransaction transaction = null;
		try(EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("brad");
			EntityManager em = emf.createEntityManager();){
			
			transaction = em.getTransaction();
			transaction.begin();
			
			Account account = em.find(Account.class , 1);
			
			AccountInfo info = account.getAccountinfo();
			if (info == null) {
				info = new AccountInfo();
				info.setMale(true);
				info.setTel("789");
				
				info.setAccount(account);
			
				em.persist(info);
			}
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction!=null && transaction.isActive()) {
				transaction.rollback();
			}
			System.out.println(e);
		}		
	}
}
