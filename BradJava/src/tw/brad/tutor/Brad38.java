package tw.brad.tutor;

import java.io.File;
import java.io.FileInputStream;

public class Brad38 {

	public static void main(String[] args) {
		File source = new File("dir1/file2.txt");
		byte[] buf = new byte[(int)source.length()];
		try {
			FileInputStream fin = new FileInputStream(source);
			fin.read(buf);
			fin.close();
			
			System.out.println(new String(buf));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
