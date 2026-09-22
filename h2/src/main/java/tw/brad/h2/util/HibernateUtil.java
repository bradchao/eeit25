package tw.brad.h2.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tw.brad.h2.entity.Customer;
import tw.brad.h2.entity.Employee;
import tw.brad.h2.entity.Order;
import tw.brad.h2.entity.OrderDetail;
import tw.brad.h2.entity.Product;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			cfg.addAnnotatedClass(Customer.class);
			cfg.addAnnotatedClass(Employee.class);
			cfg.addAnnotatedClass(Order.class);
			cfg.addAnnotatedClass(OrderDetail.class);
			cfg.addAnnotatedClass(Product.class);
			
			sessionFactory = cfg.buildSessionFactory();
		}
		return sessionFactory;
	}
	
	
}
