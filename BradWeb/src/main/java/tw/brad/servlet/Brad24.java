package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Brad24")
public class Brad24 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(req, resp);
		
		System.out.println(request.getMethod());
		
		request.setCharacterEncoding("UTF-8");
		
		String max = request.getParameter("max");
		int lottery = 0;
		if (max != null) {
			try {
				lottery = (int)(Math.random()*Integer.parseInt(max)+1);
			}catch(Exception e) {
				
			}
		}else {
			lottery = (int)(Math.random()*49+1);
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(lottery);
		
	}

	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String max = request.getParameter("max");
		int lottery = 0;
		if (max != null) {
			try {
				lottery = (int)(Math.random()*Integer.parseInt(max)+1);
			}catch(Exception e) {
				
			}
		}else {
			lottery = (int)(Math.random()*49+1);
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(lottery);
	}
	*/
}
