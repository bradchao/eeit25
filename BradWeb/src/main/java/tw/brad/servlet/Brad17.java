package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Brad17")
public class Brad17 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int lottery = (int)(Math.random()*49+1);
		session.setAttribute("lottery", lottery);
		
		response.setContentType("text/html; charset=UTF8");
		PrintWriter out = response.getWriter();
		out.printf("Brad17<hr />");
		out.printf("Lottery: %d<hr />", lottery);
		out.printf("<a href='Brad19'>Logout</a");
		
	
	}

}
