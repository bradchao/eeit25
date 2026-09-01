package tw.brad.tutor;

import java.io.File;

public class Brad36 {

	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		
		File dir = new File("c:/brad/dir2");
		System.out.println(dir.exists());
		
		File root = new File(".");
		System.out.println(root.getAbsolutePath());
		File dir1 = new File("./dir3");
		System.out.println(dir1.exists());
				
	}

}
