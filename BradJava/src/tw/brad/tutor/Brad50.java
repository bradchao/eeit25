package tw.brad.tutor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad50 {

	public static void main(String[] args) {
		String mesg = "1234567\n7654321\nabcdefg";
		try (Socket socket = new Socket(InetAddress.getByName("10.0.100.160"), 7777);
				OutputStream out = socket.getOutputStream();){
			
			out.write(mesg.getBytes());
			out.flush();
			System.out.println("TCP Send success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
