package tw.brad.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.api.Bike;

@WebServlet("/Brad13")
public class Brad13 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		Integer z = (Integer)(request.getAttribute("z"));
		
		Bike b1 = (Bike)request.getAttribute("bike");
	
		
		PrintWriter out = response.getWriter();
		out.println("Brad13<br />");
		out.printf("x = %s; y = %s; z = %d", x, y, z);
		out.println(b1);
		
	}

}
