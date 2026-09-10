package tw.brad.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Brad11")
public class Brad11 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("brad111.html");
		RequestDispatcher dispatcher2 = request.getRequestDispatcher("brad112.html");
		
		//---------------
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Brad Big Company</h1>");
		out.println("<hr />");
		dispatcher1.include(request, response);
		out.println("<hr />");
		dispatcher2.include(request, response);
		out.println("<hr />");
		out.println("<div>Footer</div>");
		
		
		
	}

}
