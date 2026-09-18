package tw.brad.hibernate.tutor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import tw.brad.hibernate.entity.Account;
import tw.brad.hibernate.entity.AccountInfo;

public class Brad13 {
	public static void main(String[] args) {
		EntityTransaction transaction = null;
		try(EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("brad");
			EntityManager em = emf.createEntityManager();){
			
			transaction = em.getTransaction();
			transaction.begin();
			
			Account account = em.find(Account.class , 1);
			
			AccountInfo info = account.getAccountinfo();
			if (info != null) {
				String tel = info.getTel();
				System.out.println(tel);
				
				Account a1 = info.getAccount();
				if (account == a1) {
					System.out.println("OK");
				}
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
