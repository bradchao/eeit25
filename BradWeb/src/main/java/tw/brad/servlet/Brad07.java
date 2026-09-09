package tw.brad.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/Brad07")
@MultipartConfig(
		location = "C:\\Users\\User\\git\\repository\\BradWeb\\src\\main\\webapp\\upload"
		)
public class Brad07 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String urip = request.getRemoteAddr();
		
		Part part = request.getPart("upload");
		String type = part.getContentType();
		String name = part.getName();
		long size = part.getSize();
		String sname = part.getSubmittedFileName();
		
		System.out.printf("%s:%s:%s:%d:%s\n", urip, type, name, size, sname);
		if (part.getSize() > 0) {
			part.write(sname);
		}
		
		
		response.setContentType("text/html; charset=UTF-8");
	}

}
