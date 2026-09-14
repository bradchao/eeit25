package tw.brad.websocket;

import java.io.IOException;
import java.util.HashSet;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/mycenter")
public class MyCenter {
	private static HashSet<Session> sessions;
	private static Session teacherSession;
	private static boolean isTeacherExist;
	
	public MyCenter() {
		if (sessions == null) {
			sessions = new HashSet<>();
			isTeacherExist = false;
		}
	}
	
	@OnOpen
	public void onopen(Session session) {
		sessions.add(session);
	}
	
	@OnMessage
	public void onmesg(String mesg, Session session) {
		if (!isTeacherExist && mesg.contains("isTeacher")) {
			isTeacherExist = true;
			teacherSession = session;
			System.out.println("Teacher enter....");
		}else if (teacherSession == session) {
			for (Session student : sessions) {
				try {
					student.getBasicRemote().sendText(mesg);
				} catch (IOException e) {
				}
			}
		}
	}
	
	@OnClose
	public void onclose(Session session) {
		sessions.remove(session);
	}
	
	@OnError
	public void onerror(Session session, Throwable t) {
		System.out.println("ERROR:");
	}
	
}
