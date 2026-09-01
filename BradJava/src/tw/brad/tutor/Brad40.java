package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad40 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try (FileInputStream fin = new FileInputStream("dir1/coffee.jpg");
			FileOutputStream fout = new FileOutputStream("dir3/mycoffee.jpg")) {

			int len; byte[] buf = new byte[4*1024];
			while ( (len = fin.read(buf)) != -1) {
				fout.write(buf,0, len);
			}
			
			fout.flush();
			System.out.println("Finish:" + (System.currentTimeMillis() - start));
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
