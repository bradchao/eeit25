package tw.brad.api;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;

public class BradUtil {
	public static String loadView() throws Exception{
		String source = "C:\\Users\\User\\git\\repository\\BradWeb\\src\\main\\webapp\\views\\view1.html";
		
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source));
		byte[] buf =bin.readAllBytes();
		bin.close();
		
		
		return new String(buf);
	}
}
