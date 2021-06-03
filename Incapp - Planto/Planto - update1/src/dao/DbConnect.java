package dao;
import java.sql.*;
public class DbConnect {
	private Connection c;
	public DbConnect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost/plantodb","root", "Incapp@12");
	}
	public String getAdminLogin(String aid,String password) throws Exception{
		PreparedStatement p=c.prepareStatement("select name from admin where aid=? and password=?");
		p.setString(1, aid);
		p.setString(2, password);
		ResultSet rs=p.executeQuery();
		if(rs.next()) {
			return rs.getString("name");
		}else {
			return null;
		}
	}
}
