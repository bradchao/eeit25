package tw.brad.hibernate.tutor;

import java.util.List;
import java.util.Scanner;

import tw.brad.hibernate.dao.SCDao;
import tw.brad.hibernate.entity.Course;
import tw.brad.hibernate.entity.Student;

public class Brad23 {

	public static void main(String[] args) {
		SCDao dao = new SCDao();
		
		Student s1;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Student ID:");
		long sid = scanner.nextLong();
		
		s1 = dao.getStudentById(sid);
		System.out.printf("Welcome, %s(%d)", s1.getSname(), s1.getId());
		
		List<Course> courses = dao.getAllCourse();
		for (Course course: courses) {
			System.out.printf("%d: %s\n", course.getId(), course.getCname());
		}
		
		System.out.println("----");
		System.out.print("Course ID:");
		long cid = scanner.nextLong();
		
		s1.addCourse(dao.getCourseById(cid));
		s1 = dao.update(s1);
		
		
		
		
		
	}

}
