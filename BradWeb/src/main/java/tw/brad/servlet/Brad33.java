package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/Brad33")
public class Brad33 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		if (name == null || name.isBlank()) {
			name = "訪客";
		}
		
		String title = "你好";
		
		request.setAttribute("title", title);
		request.setAttribute("name", name);
		request.setAttribute("time", LocalDateTime.now());
		
		request.getRequestDispatcher("/WEB-INF/views/brad33.jsp")
			.forward(request, response);
		
		
	}

}
