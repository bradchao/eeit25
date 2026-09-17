package tw.brad.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import tw.brad.hibernate.entity.Account;
import tw.brad.hibernate.util.HibernateUtil;

public class AccountDao {
	public void addAccount(Account account) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.persist(account);
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	public void delAccount(Account account) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.remove(account);
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	public void updateAccount(Account account) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.merge(account);
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	public Account findById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.find(Account.class, id);
		}catch(Exception e) {
		}		
		return null;
	}
	public List<Account> findAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "FROM Account";
			Query<Account> query = session.createQuery(hql, Account.class);
			return query.getResultList();
		}catch(Exception e) {
		}		
		return null;
	}
}
