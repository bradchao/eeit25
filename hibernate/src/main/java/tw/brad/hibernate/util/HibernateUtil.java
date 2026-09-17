package tw.brad.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tw.brad.hibernate.entity.Account;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			//cfg.addAnnotatedClass(Account.class);
			
			sessionFactory = cfg.buildSessionFactory();
		}
		return sessionFactory;
	}
	
	
}
