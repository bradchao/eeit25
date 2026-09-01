package tw.brad.tutor;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.brad.api.Student;

public class Brad44 {

	public static void main(String[] args) {
		Student s1 = new Student(50, 80, 90, "Eric");
		s1.getBike().upSpeed().upSpeed().upSpeed().upSpeed();
		System.out.printf("%s:%d:%f:%f\n", s1.getName(), s1.sum(), s1.avg(), s1.getBike().getSpeed());
		
		try(FileOutputStream fout = new FileOutputStream("dir1/s1.student");
				ObjectOutputStream oout = new ObjectOutputStream(fout)){
			
			oout.writeObject(s1);
			oout.flush();
			System.out.println("OK");
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
