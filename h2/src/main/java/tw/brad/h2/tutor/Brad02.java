package tw.brad.h2.tutor;

import java.util.List;

import org.hibernate.Session;

import tw.brad.h2.entity.Employee;
import tw.brad.h2.util.HibernateUtil;

public class Brad02 {

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			String sql = """
					SELECT EmployeeID, LastName, FirstName, Title
					FROM employees
					ORDER BY Title ASC, LastName DESC
					""";
			List<Employee> es = 
				session.createNativeQuery(sql, Employee.class).getResultList();
			for (Employee e : es) {
				System.out.printf("%d:%s:%s:%s\n", 
						e.getEmployeeId(), e.getTitle(), e.getLastName(), e.getFirstName());
			}
		}
	}

}
