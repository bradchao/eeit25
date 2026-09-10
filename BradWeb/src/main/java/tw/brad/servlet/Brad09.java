package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/Brad09")
public class Brad09 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	
		response.setContentType("text/html; charset=UTF-8");
		
		String upload = getServletContext().getRealPath("/upload");
		System.out.println(upload);
		
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
		
		System.out.println(System.getProperty("user.dir"));
		System.out.println(request.getServletContext().getRealPath("/"));
		System.out.println(getServletContext().getRealPath("/"));
		
		
	}

}
