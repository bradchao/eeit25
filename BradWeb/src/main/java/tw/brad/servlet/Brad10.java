package tw.brad.servlet;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Brad10")
public class Brad10 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		double pr = 0.0;
		try {
			pr = Double.parseDouble(request.getParameter("pr")); 	// 50 => 50%
		}catch(Exception e) {}
		
		BufferedImage img = new BufferedImage(800, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(0, 0, 800, 20);
		
		g2d.setColor(Color.RED);
		g2d.fillRect(0, 0, (int)(800*pr/100), 20);
		
		File file = new File(getServletContext().getRealPath("/upload"),"brad.jpg");
		System.out.println(file.getAbsolutePath());
		File file2 = new File("C:\\Users\\User\\git\\repository\\BradWeb\\src\\main\\webapp\\upload","brad.jpg");
		
		response.setContentType("image/jpeg");
		//ImageIO.write(img, "JPEG", response.getOutputStream());
		response.flushBuffer();
		
		ImageIO.write(img, "JPEG", file2);
	}

}
