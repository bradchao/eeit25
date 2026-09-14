package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Brad16")
public class Brad16 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//HttpSession session = request.getSession(false);	// 沒有 => null
		HttpSession session = request.getSession(true);	// 沒有 => new 
		if (session  == null) {
			System.out.println("none");
		}else {
			System.out.println("session");
			session.invalidate();
		}
		
		
	}

}
