package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

import tw.brad.api.Student;

public class Brad45 {

	public static void main(String[] args) {
		try (FileInputStream fin = new FileInputStream("dir1/s1.student");
				ObjectInputStream oin = new ObjectInputStream(fin)) {
			
			Student obj = (Student)oin.readObject();
//			if (obj instanceof Student) {
//				System.out.println("Yes");
//			}
			
			System.out.printf("%s:%d:%f:%f\n", obj.getName(), obj.sum(), obj.avg(), obj.getBike().getSpeed());
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
