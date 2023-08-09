package conn.daw;
import java.sql.PreparedStatement;

import java.sql.Connection;


import conn.entity.Appointment;

public class Appointmentdaw {
	private Connection conn;

	public Appointmentdaw(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean AddAppointment(Appointment ap) {
		boolean f = false;

		try {

			String sql = "insert into appointment(fullname,gender,age,appointment_date,email,phno,diseases,spec,address) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, ap.getFullName());
			ps.setString(2, ap.getGender());
			ps.setString(3, ap.getAge());
			ps.setString(4, ap.getAppoinDate());
			ps.setString(5, ap.getEmail());
			ps.setString(6, ap.getPhNo());
			ps.setString(7, ap.getDiseases());
			ps.setString(8, ap.getSpec());
			ps.setString(9, ap.getAddress());
			

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			System.out.println("Data insertion failed: " + e.getMessage());
			e.printStackTrace();
		}

		return f;
	}

}
