package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Brad05")
public class Brad05 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>\n");
		out.print("<h1>Brad Big Company</h1>\n");
		out.print("<hr />\n");
		out.print("<form action='Brad05'>\n");
		out.print("<input type='number' name='x'/>\n");
		out.print("+\n");
		out.print("<input name='y'/>\n");
		out.print("<input type='submit' value='=' />\n");
		out.print("<span></span>\n");
		out.print("</form>\n");
		
	}

}
