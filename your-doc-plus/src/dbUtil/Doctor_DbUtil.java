package dbUtil;

import java.sql.*;
import java.util.*;

public class Doctor_DbUtil {

	/**
	 * gets all the hospitals
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<HashMap<String, Object>> getHospitals() throws Exception {
		ArrayList<HashMap<String, Object>> hospital_list = new ArrayList<HashMap<String, Object>>();

		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement("SELECT id,name,address FROM hospitals;");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			HashMap<String, Object> h = new HashMap<String, Object>();
			h.put("id", rs.getInt("id"));
			h.put("name", rs.getString("name"));
			h.put("address", rs.getString("address"));
			hospital_list.add(h);
		}

		return hospital_list;
	}

	/**
	 * Creating doctor basic account
	 * 
	 * @param email
	 * @param password
	 * @param name
	 * @param specialization
	 * @param phone
	 * @param address
	 * @param qualification
	 * @param gender
	 * @return
	 * @throws Exception
	 */
	public static boolean createAccount(String email, String password, String name, String specialization, String phone,
			String address, String qualification, String gender) throws Exception {
		boolean created = false;
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement(
				"INSERT INTO doctor(name,email,phone,specialization,qualification,pass,gender,address) VALUES(?,?,?,?,?,?,?,?);");
		pst.setString(1, name);
		pst.setString(2, email);
		pst.setString(3, phone);
		pst.setString(4, specialization);
		pst.setString(5, qualification);
		pst.setString(6, password);
		pst.setString(7, gender);
		pst.setString(8, address);
		int result = pst.executeUpdate();
		if (result == 1)
			created = true;
		return created;
	}

	/**
	 * get the name of the user from email and password
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String accountExist(String email, String password) throws Exception {
		String name = null;
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement("SELECT name FROM doctor WHERE email=? and pass=?;");
		pst.setString(1, email);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();
		if (rs.next())
			name = rs.getString("name");

		return name;
	}

	/**
	 * adds the clinic to soctors account using id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static boolean addClinic(String id, String name, String address, String gfromto) throws Exception {
		boolean added = false;
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement(
				"INSERT INTO `yourdocplus_db`.`clinic` (`did`, `address`, `name`,`gfromto`) VALUES (?,?,?,?);");
		pst.setString(1, id);
		pst.setString(2, address);
		pst.setString(3, name);
		pst.setString(4, gfromto);
		int c = pst.executeUpdate();
		if (c == 1)
			added = true;
		return added;
	}

	/**
	 * get the clinic list from doctors id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<ArrayList<String>> getClinicList(String id) throws Exception {
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement("SELECT * FROM clinic WHERE did=?;");
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			ArrayList<String> p = new ArrayList<String>();
			p.add(rs.getString("name"));
			p.add(rs.getString("address"));
			if (rs.getString("gfromto") != null) {
				p.add(rs.getString("gfromto"));
			} else {
				p.add("-");
			}
			ret.add(p);
		}
		return ret;
	}

	/**
	 * provide clinic id from did cname and address
	 * 
	 * @param did
	 * @param cname
	 * @param address
	 * @return
	 * @throws Exception
	 */
	public static Integer getId(String did, String cname, String address) throws Exception {
		Integer id = null;
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn
				.prepareStatement("SELECT * FROM clinic WHERE(`did` =? and `name`=? and address =? );");
		pst.setString(1, did);
		pst.setString(3, address);
		pst.setString(2, cname);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			id = rs.getInt("id");
			System.out.println(id);
		}

		return id;
	}

	/**
	 * 
	 * @param did
	 * @param cname
	 * @param address
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteCLinic(int id) throws Exception {
		boolean del = false;
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement("DELETE FROM `yourdocplus_db`.`clinic` WHERE (`id` = ?);");
		pst.setInt(1, id);
		int c = pst.executeUpdate();
		System.out.println(c);
		if (c == 1)
			del = true;
		return del;
	}

	/**
	 * 
	 * @param did
	 * @param name
	 * @param address
	 * @return
	 * @throws Exception
	 */
	public static boolean editClinicDetails(String did, String cname, String address, String cname0, String address0,
			String gfromto) throws Exception {
		boolean edited = false;
		Integer id = getId(did, cname0, address0);
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement(
				"UPDATE `yourdocplus_db`.`clinic` SET `address` = ?, `name` = ?, `gfromto`= ? WHERE (`id` = ?);");
		pst.setString(1, address);
		pst.setString(2, cname);
		pst.setString(3, gfromto);
		pst.setInt(4, id);
		int c = pst.executeUpdate();
		if (c == 1)
			edited = true;
		return edited;
	}

	/**
	 * get Account details of the doctor
	 * 
	 * @param did
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<String> getAccountDetails(String did) throws Exception {
		ArrayList<String> ret = new ArrayList<String>();
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement("SELECT * FROM `yourdocplus_db`.`doctor` WHERE `email` = ?;");
		pst.setString(1, did);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			ret.add(rs.getString("name"));
			ret.add(rs.getString("email"));
			ret.add(rs.getString("phone"));
			ret.add(rs.getString("specialization"));
			ret.add(rs.getString("qualification"));
			ret.add(rs.getString("gender"));
			ret.add(rs.getString("address"));
		}
		return ret;
	}

	/**
	 * update account details of the doctor
	 * 
	 * @param id
	 * @param name
	 * @param email
	 * @param phone
	 * @param specialization
	 * @param qualification
	 * @param gender
	 * @param address
	 * @return
	 * @throws Exception
	 */
	public static boolean editAccountDetails(String name, String email, String phone, String specialization,
			String qualification, String gender, String address) throws Exception {
		boolean edited = false;
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement(
				"UPDATE `yourdocplus_db`.`doctor` SET `name` = ? , `email` =?, `phone` = ?, `specialization` = ?,`qualification` = ? , `gender` = ?, `address` =? WHERE (`email` = ?);");
		pst.setString(1, name);
		pst.setString(2, email);
		pst.setString(3, phone);
		pst.setString(4, specialization);
		pst.setString(5, qualification);
		pst.setString(6, gender);
		pst.setString(7, address);
		pst.setString(8, email);
		int c = pst.executeUpdate(); 
		if (c == 1)
			edited = true;
		return edited;

	}
	/**
	 * get the email of the doctor from d_id
	 * @param d_id
	 * @return
	 * @throws Exception
	 */
	public static String getEmail(int d_id) throws Exception{
		String email = null;
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement("SELECT * FROM `doctor` WHERE id = ?;");
		pst.setInt(1, d_id);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
		email = rs.getString("email");
		}
		return null;
	}
}
