package tw.brad.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.api.Food;
import tw.brad.dao.FoodDao;

@WebServlet("/FoodMain")
public class FoodMain extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 1.
		request.setCharacterEncoding("UTF-8");
		
		int page = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		}catch(Exception e) {}
		
		// 2. Model => Dao
		try {
			List<Food> foods = new FoodDao().queryByPage(page, 10);

			request.setAttribute("foods", foods);
			request.setAttribute("page", page);
			
			
			// 3. Viewer
			request.getRequestDispatcher("").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
