package tw.brad.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.hibernate.entity.Course;
import tw.brad.hibernate.entity.Order;
import tw.brad.hibernate.entity.Student;
import tw.brad.hibernate.util.HibernateUtil;

public class SCDao {
	public void save(Student student) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(student);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				try {
					transaction.rollback();
					System.out.println("rollback");
				}catch(Exception ee) {
					e.printStackTrace();
				}
			}
		}finally {
			if (session != null) {
				session.close();
			}
		}
		
	}
	public void save(Course course) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(course);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				try {
					transaction.rollback();
					System.out.println("rollback");
				}catch(Exception ee) {
					e.printStackTrace();
				}
			}
		}finally {
			if (session != null) {
				session.close();
			}
		}
		
	}
	public Student update(Student student) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.merge(student);
			transaction.commit();
			
			return getStudentById(student.getId());
			
		}catch(Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				try {
					transaction.rollback();
					System.out.println("rollback");
				}catch(Exception ee) {
					e.printStackTrace();
				}
			}
		}finally {
			if (session != null) {
				session.close();
			}
		}		
		return null;
	}
	public Student getStudentById(Long id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.find(Student.class, id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
		}		
		return null;
	}
	public Course getCourseById(Long id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.find(Course.class, id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
		}		
		return null;		
	}
	public List<Course> getAllCourse(){
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("FROM Course", Course.class).getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
		}		
		return null;		
	}
	
}
