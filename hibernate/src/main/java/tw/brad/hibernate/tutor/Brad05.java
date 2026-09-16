package tw.brad.hibernate.tutor;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tw.brad.hibernate.entity.Account;

public class Brad05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ID:");
		int id = scanner.nextInt();
		System.out.print("Password:");
		String passwd = scanner.next();
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("brad");
		EntityManager em = emf.createEntityManager();
		
		Account account = em.find(Account.class, id);
		String hashPasswd = account.getPasswd();
		if (BCrypt.checkpw(passwd, hashPasswd)) {
			System.out.printf("Welcome, %s", account.getName());
		}else {
			System.out.println("Login Failure");
		}
		
		
		em.close();
		emf.close();		
		
	}

}
