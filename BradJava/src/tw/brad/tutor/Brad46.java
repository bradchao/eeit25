package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Brad46 {
	public static void main(String[] args) {
		Brad463 obj = new Brad463();
		
		try(ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir1/test.obj"))){
			oout.writeObject(obj);
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("----");
		try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir1/test.obj"))){
			oin.readObject();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
class Brad461 {
	Brad461(){System.out.println("Brad461()");}
}
class Brad462 extends Brad461 {
	Brad462(){System.out.println("Brad462()");}
}
class Brad463 extends Brad462 implements Serializable{
	Brad463(){System.out.println("Brad463()");}
}

