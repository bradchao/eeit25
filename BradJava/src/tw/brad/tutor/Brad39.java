package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad39 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try (FileInputStream fin = new FileInputStream("dir1/coffee.jpg");
			FileOutputStream fout = new FileOutputStream("dir2/mycoffee.jpg")) {

			int b;
			while ( (b = fin.read()) != -1) {
				fout.write(b);
			}
			
			fout.flush();
			System.out.println("Finish:" + (System.currentTimeMillis() - start));
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
