package tw.brad.hibernate.tutor;

import tw.brad.hibernate.dao.SCDao;
import tw.brad.hibernate.entity.Student;

public class Brad21 {

	public static void main(String[] args) {
		SCDao dao = new SCDao();
		dao.save(new Student("Brad"));
		dao.save(new Student("Andy"));
		dao.save(new Student("Eric"));
		dao.save(new Student("Tony"));
	}

}
