package tw.brad.h2.tutor;

import java.util.List;

import org.hibernate.Session;

import tw.brad.h2.entity.Employee;
import tw.brad.h2.util.HibernateUtil;

public class Brad04 {

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = """
					FROM Employee e
					ORDER BY e.title ASC, e.lastName DESC
					""";
			List<Employee> es = 
				session.createQuery(hql, Employee.class).getResultList();
			for (Employee e : es) {
				System.out.printf("%d:%s:%s:%s\n", 
						e.getEmployeeId(), e.getTitle(), e.getLastName(), e.getFirstName());
			}
		}
	}

}
