package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Brad18")
public class Brad18 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		int lottery = (Integer)session.getAttribute("lottery");
		
		PrintWriter out = response.getWriter();
		out.printf("Lottery: %d", lottery);
	}

}
