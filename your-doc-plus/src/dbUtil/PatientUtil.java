package dbUtil;

import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;

public class PatientUtil {

	// get the total number users.
	public static int getUserCount() {
		int users = 0;
		try {
			Connection conn = DbConnect.getConnection();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM patient");
			ResultSet rs = pst.executeQuery();
			while (rs.next())
				users++;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return users;
	}
	/**
	 * Creating patient account
	 * @param email
	 * @param password
	 * @param address
	 * @param name
	 * @param age
	 * @param phone
	 * @param gender
	 * @return
	 */
	public static String createPatientAccount(String email, String password,String address, String name, int age, String phone,
			String gender) {
		String ret =null;
		try {
			Connection conn = DbConnect.getConnection();
			PreparedStatement pst = conn.prepareStatement("INSERT INTO patient VALUES(?,?,?,?,?,?,?,CURRENT_TIMESTAMP)");
			pst.setString(1, email);
			pst.setString(2, password);
			pst.setString(3, name);
			pst.setString(4, address);
			pst.setInt(5, age);
			pst.setString(6, gender);
			pst.setString(7, phone);
			pst.execute();
			ret="Account Created";
		} catch (SQLException e) {
			e.printStackTrace();
			ret="Database error";
		}
		return ret;
	}
	/**
	 * Check if account exist and give name
	 * @param email
	 * @param pass
	 * @return
	 */
	public static String login_aut(String email, String pass) {
		String name = null;
		try {
			Connection conn = DbConnect.getConnection();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM patient WHERE email = ? and password = ?");
			pst.setString(1, email);
			pst.setString(2, pass); 
			ResultSet rs = pst.executeQuery(); 
			rs.next();
			name = rs.getString("name");
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return name;
	}

}
