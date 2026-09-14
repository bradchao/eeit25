package tw.brad.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tw.brad.api.Member;
import tw.brad.dao.MemberDao;

@WebServlet("/Brad20")
public class Brad20 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		
		MemberDao dao = new MemberDao();
		try {
			Member member =  dao.login(account, passwd);
			if (member != null) {
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				
				response.sendRedirect("Brad21");
				
			}else {
				response.sendRedirect("brad20.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(500, "ERROR");
		}
		
	}

}
