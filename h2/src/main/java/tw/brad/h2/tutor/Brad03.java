package tw.brad.h2.tutor;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import tw.brad.h2.entity.Employee;
import tw.brad.h2.util.HibernateUtil;

/* Criteria: 標準查詢
 * Builder CriteriaBuilder => session, get
 */
public class Brad03 {

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			//-------------------
			Root<Employee> root = cq.from(Employee.class);
			//-------------------
			cq.multiselect(List.of(
					root.get("employeeId"),root.get("lastName"),
					root.get("firstName"),root.get("title")
					));
			//---------------------
			cq.orderBy(cb.asc(root.get("title")),cb.desc(root.get("lastName")));
			//---------------------
			List<Employee> es = session.createQuery(cq).getResultList();
			for (Employee e : es) {
				System.out.printf("%d:%s:%s:%s\n", 
						e.getEmployeeId(), e.getTitle(), e.getLastName(), e.getFirstName());
			}
		}

	}

}
