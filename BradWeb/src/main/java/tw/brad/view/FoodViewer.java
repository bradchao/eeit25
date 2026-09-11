package tw.brad.view;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.api.Food;

@WebServlet("/FoodViewer")
public class FoodViewer extends HttpServlet {
	private static final String TEMPLETE_PATH = "C:\\Users\\User\\git\\repository\\BradWeb\\src\\main\\webapp\\WEB-INF\\views\\view1.html";
	private String templete;

	@Override
	public void init() throws ServletException {
		// read tepmlete
		try {
			templete = readTemplete(TEMPLETE_PATH);
		} catch (Exception e) {
			throw new ServletException("Load Templete Failure");
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		List<Food> foods = (List<Food>)request.getAttribute("foods");
		if (foods == null) foods = Collections.emptyList();
		
		Integer page = (Integer)request.getAttribute("page");
		String spage = page != null ? page.toString() : "1";
		
		String tableHtml = bindTable(foods);
		
		String html = templete.replace("{{TABLE}}", tableHtml)
							.replace("{{PAGE}}", spage);
		
		response.getWriter().print(html);
		
		
	}
	
	private String readTemplete(String file) throws Exception {
//		try(InputStream in = getServletContext().getResourceAsStream(file)){
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))){
			if (in == null) {
				throw new IOException("Templete File NOT FOUND");
			}
			return new String(in.readAllBytes(), StandardCharsets.UTF_8);
		}
	}
	
	private String bindTable(List<Food> foods) {
		StringBuffer sb = new StringBuffer();
		sb.append("<table width='100%' border='1'>")
			.append("<thead><tr>")
			.append("<th>編號</th>")
			.append("<th>名稱</th>")
			.append("<th>電話</th>")
			.append("<th>地址</th>")
			.append("<th>圖片</th>")
			.append("</tr></thead>")
			.append("<tbody>");
		
		if (foods.size() == 0) {
			sb.append("<tr><td colspan='5'>沒資料</td></tr>");
		}else {
			for (Food food : foods) {
				sb.append("<tr>");
				sb.append("<td>").append(food.getId()).append("</td>");
				sb.append("<td>").append(food.getName()).append("</td>");
				sb.append("<td>").append(food.getTel()).append("</td>");
				sb.append("<td>").append(food.getCity()).append(food.getTown()).append(food.getAddr()).append("</td>");
				sb.append("<td><img src='").append(food.getPicurl()).append("' width='160px' height='90px'></td>");
				sb.append("</tr>");
			}
		}
		
		sb.append("</tbody></table>");
		
		return sb.toString();
	}

}
