package tw.brad.tutor;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Brad47 {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("www.iii.org.tw");
			System.out.println(ip.getHostName() + " : " + ip.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
