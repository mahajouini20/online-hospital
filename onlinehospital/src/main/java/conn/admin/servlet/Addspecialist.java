package conn.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.daw.Specialistdaw;
import conn.db.DBconnect;

@WebServlet("/addspecialist")
public class Addspecialist extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String specName=req.getParameter("specName");
		Specialistdaw daw= new Specialistdaw(DBconnect.getConn());
	boolean f=daw.addSpecialist(specName); 
	HttpSession session = req.getSession();

	if (f) {
		session.setAttribute("succMsg", "Specialist Added");
		resp.sendRedirect("admin/index.jsp");
	} else {
		session.setAttribute("errorMsg", "something wrong on server");
		resp.sendRedirect("admin/index.jsp");
	}

}
		
	}


