package tw.brad.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Brad37 {
	public static void main(String[] args) {
		String mesg = "\nHello, Brad";
		try {
			FileOutputStream fout = new FileOutputStream("./dir1/file1.txt", true);
			fout.write(mesg.getBytes());
			fout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
