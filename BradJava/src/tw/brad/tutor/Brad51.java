package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad51 {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(80);){
			Socket socket = server.accept();
			InputStream in = socket.getInputStream();
			InputStreamReader ir = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(ir);
			
			String line;
			while ( (line = reader.readLine()) != null ) {
				System.out.println(line);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
