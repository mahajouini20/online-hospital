package conn.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.entity.User;

@WebServlet("/adminlogin")
public class Adminlogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String email = req.getParameter("email");
			String password = req.getParameter("password");

			HttpSession session = req.getSession();

			if ("mahajouini@gmail.com".equals(email) && "maha123".equals(password)) {
				session.setAttribute("adminObj", new User());
				resp.sendRedirect("admin/index.jsp");
			} else {
				session.setAttribute("errorMsg", "invalid email & password");
				resp.sendRedirect("adminlogin.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
