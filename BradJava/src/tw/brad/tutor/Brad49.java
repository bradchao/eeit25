package tw.brad.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Brad49 {

	public static void main(String[] args) {
//		while(true) {
			byte[] buf = new byte[1024];	// 000000....
			try (DatagramSocket socket = new DatagramSocket(8888);){
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				
				String urIP =  packet.getAddress().getHostAddress();
				int len = packet.getLength();
				byte[] data = packet.getData();
				String mesg = new String(data, 0, len);
				System.out.printf("%s:%s\n", urIP, mesg);
//				if (mesg.equals("quit")) {
//					break;
//				}
			} catch (Exception e) {
				e.printStackTrace();
			}
//		}

	}

}
