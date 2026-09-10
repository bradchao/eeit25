package tw.brad.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.model.CalcModel;

import java.io.IOException;

@WebServlet("/CalcController")
public class CalcController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 1. Client
		request.setCharacterEncoding("UTF-8");
		
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		
		// 2. Model
		try {
			CalcModel model = new CalcModel(x, y);
			String result = model.plus();
			
			request.setAttribute("x", x);
			request.setAttribute("y", y);
			request.setAttribute("result", result);
		}catch(Exception e) {
			request.setAttribute("x", "");
			request.setAttribute("y", "");
			request.setAttribute("result", "");
		}
		
		// 3. Viewer => forward
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("CalcViewer");
		dispatcher.forward(request, response);
	
	}

}
