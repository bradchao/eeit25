package tw.brad.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tw.brad.api.Member;

@WebServlet("/Brad21")
public class Brad21 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("brad20.html");
			return;
		}
		
		Member member = (Member) session.getAttribute("member");
		if (member == null) {
			response.sendRedirect("brad20.html");
			return;
		}
		
		int lottery = (Integer)session.getAttribute("lottery");
		int[] ary = (int[])session.getAttribute("ary");
		
		
		
		PrintWriter out = response.getWriter();
		out.printf("Welcome, %s<hr />", member.name());
		out.printf("Lottery: %d<br />", lottery);
		out.printf("ary[2]: %d<br/>", ary[2]);
		out.print("<a href='Brad19'>Logout</a>");
		
		
		
		
		
		
		
		
	}

}
