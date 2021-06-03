package dbUtil;

import java.sql.*;

public class DbUtilGenric {
	/**
	 * Sents email with password
	 * @param email
	 * @param table
	 * @return
	 * @throws Exception
	 */
	public static boolean changePasswordEmail(String email,String table) throws Exception {
		boolean ret=false;
		Connection conn=DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from patient where email=?"); 
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			String pass = rs.getString("password");
			if(pass!=null) {
				dynamicUtil.Send_email.sendEmail(email,"Your Doc+ | Password retrieval", "Your Current Password for "+ email+" is "+pass+".\n\n Kindly Change Your Password using this.\n\n Your Doc +\n IT Team.");
				ret = true;
			}
		}
		return ret;
	}
}
