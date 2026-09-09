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
		
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String sr = "";
		if (x != null && y != null) {
			int r = Integer.parseInt(x) + Integer.parseInt(y);
			sr += r;
		}else {
			x = y = "";
		}
		
		//-----------------------------
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>\n");
		out.print("<h1>Brad Big Company</h1>\n");
		out.print("<hr />\n");
		out.print("<form action='Brad05'>\n");
		out.printf("<input name='x' value='%s' />\n", x);
		out.print("+\n");
		out.printf("<input name='y' value='%s' />\n", y);
		out.print("<input type='submit' value='=' />\n");
		out.printf("<span>%s</span>\n", sr);
		out.print("</form>\n");
		
	}

}
