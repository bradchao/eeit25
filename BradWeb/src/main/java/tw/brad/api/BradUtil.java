package tw.brad.api;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;

public class BradUtil {
	public static String calc(String x, String y) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			return (intX + intY) + "";
		}catch(Exception e) {
			return "";
		}
	}
	
	public static String loadView(String source) throws Exception{
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source));
		byte[] buf =bin.readAllBytes();
		bin.close();
		
		return new String(buf);
	}
}
