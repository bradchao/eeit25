package tw.brad.hibernate.tutor;

import tw.brad.hibernate.dao.SCDao;
import tw.brad.hibernate.entity.Course;

public class Brad22 {

	public static void main(String[] args) {
		SCDao dao = new SCDao();
		
		dao.save(new Course("Java"));
		dao.save(new Course("JDBC"));
		dao.save(new Course("Tomcat"));
		dao.save(new Course("Hibernate"));
		dao.save(new Course("Spring Boot"));
	}

}
