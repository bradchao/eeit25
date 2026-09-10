package tw.brad.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.api.BradUtil;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalcViewer")
public class CalcViewer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			String webContent = BradUtil.loadView();
			out.print(webContent);
		}catch(Exception e) {
			
		}
		
	}

}
