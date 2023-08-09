package conn.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.daw.Appointmentdaw;
import conn.db.DBconnect;
import conn.entity.Appointment;
 import javax.servlet.annotation.WebServlet;
@WebServlet("/addappointment")
public class AppointmentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullname = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String appoint_date = req.getParameter("appoint_date");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String diseases = req.getParameter("diseases");
		 String spec=req.getParameter("spec");		
		 String address = req.getParameter("address");

		Appointment ap = new Appointment(fullname, gender, age, appoint_date, email, phno, diseases,spec,
				address);

		Appointmentdaw dao = new Appointmentdaw(DBconnect.getConn());
		HttpSession session = req.getSession();
		

		if (dao.AddAppointment(ap)) {
			session.setAttribute("succMsg", "Appointment Sucessfully");
			resp.sendRedirect("user_appointment.jsp");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
			resp.sendRedirect("user_appointment.jsp");
		}

	}

	}


