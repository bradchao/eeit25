package tw.brad.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.api.Bike;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Brad12")
public class Brad12 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("Brad13");
		
		request.setAttribute("z", 7);	// int => auto-boxing Integer

		Bike b1 = new Bike();
		b1.upSpeed().upSpeed().upSpeed().upSpeed();
		request.setAttribute("bike", b1);
		
		//---------------
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		out.println("<h1>Brad Big Company</h1>");
		out.println("<hr />");
		dispatcher1.include(request, response);
		out.println("<hr />");
		out.println("<div>Footer</div>");
		
	}

}
