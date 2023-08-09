package conn.daw;
import java.sql.Connection ;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conn.entity.User; 
public class Userdaw {
private Connection conn ;

public Userdaw(Connection conn) {
	super();
	this.conn = conn;
} 
public boolean UserRegister(User u) {
	boolean f=false ;
	try {
		String sql="insert into user_dtls(full_name,email,password) values(?,?,?) " ;
		
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,u.getFullname());
		ps.setString(2,u.getEmail());
		ps.setString(3,u.getPassword());
		int i=ps.executeUpdate(); 
		if (i==1)
		{
		f=true ; 	
		}

	}catch(Exception e) {
		e.printStackTrace();	
	}
	return f; 
}


}




