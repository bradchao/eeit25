package tw.brad.websocket;

import java.io.IOException;
import java.util.HashSet;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/myserver")
public class MyServer {
	private static HashSet<Session> sessions;
	
	public MyServer() {
		if (sessions == null) {
			sessions = new HashSet<Session>();
		}
	}
	

	@OnOpen
	public void onOpen(Session session) {
		if (sessions.add(session)) {
			System.out.println("New Session....");
		}
	}
	
	@OnMessage
	public void onMessage(String mesg, Session session) {
		for (Session user : sessions) {
			try {
				user.getBasicRemote().sendText(mesg);
			} catch (IOException e) {
			}
		}
	}
	
	@OnClose
	public void onClose(Session session) {
		sessions.remove(session);
	}
	
	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println("onError");
	}
	
	
	
}
