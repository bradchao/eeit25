package tw.brad.h2.dao;

import org.hibernate.Session;

import tw.brad.h2.entity.Customer;
import tw.brad.h2.util.HibernateUtil;

public class CustomerDao {
	public Customer getById(String id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.find(Customer.class, id);
		}
	}
}
