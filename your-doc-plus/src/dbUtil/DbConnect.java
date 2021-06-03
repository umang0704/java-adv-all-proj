package dbUtil;
import java.sql.*;
public class DbConnect {
	private static Connection connection;

	public static Connection getConnection() {
		try {
			String dbdriver = "com.mysql.cj.jdbc.Driver";
			String dbpath = "jdbc:mysql://localhost:3306/yourdocplus_db?useSSL=false&allowPublicKeyRetrieval=true";
			String dbid = "root";
			String dbpass = "Umang@123";
			Class.forName(dbdriver);
			connection = DriverManager.getConnection(dbpath, dbid, dbpass);
			
		}catch(Exception ex) {
			
		}
		return connection;
	}
 
	
}
