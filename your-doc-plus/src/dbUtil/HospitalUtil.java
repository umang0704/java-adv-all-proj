package dbUtil;

import java.sql.*;
import java.util.*;

import dynamicUtil.OTPGenerator;

public class HospitalUtil {

	/**
	 * fetches all tiers of hospitals from hospital tiers to ArrayList
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<String> getHospitalTier() throws Exception {
		ArrayList<String> tier = new ArrayList<String>();
		try {
			Connection conn = dbUtil.DbConnect.getConnection();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM hospital_tiers");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				tier.add(rs.getString("id"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return tier;
	}

	/**
	 * creates a hospital account
	 * 
	 * @param email
	 * @param password
	 * @param name
	 * @param phone
	 * @param address
	 * @param tiers
	 * @return
	 * @throws Exception
	 */
	public static boolean createHospitalAccount(String email, String password, String name, String phone,
			String address, String tiers) throws Exception {
		boolean created = false;
		try {
			Connection conn = dbUtil.DbConnect.getConnection();
			PreparedStatement pst = conn.prepareStatement(
					"INSERT INTO hospitals (`name`, `address`, `phone`, `tier`, `password`, `email`) VALUES (?,?,?,?,?,?);");
			pst.setString(1, name);
			pst.setString(2, address);
			pst.setString(3, phone);
			pst.setString(4, tiers);
			pst.setString(5, password);
			pst.setString(6, email);
			pst.execute();
			created = true;
		} catch (Exception ex) {

		}
		return created;
	}

	/**
	 * log in authemtication
	 * 
	 * @param hid
	 * @param hpass
	 * @return
	 * @throws Exception
	 */
	public static HashMap<String, String> isAuth(String hid, String hpass) throws Exception {
		HashMap<String, String> auth = new HashMap<String, String>();
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement("SELECT * FROM `hospitals` WHERE `email`= ? and `password`= ? ;");
		pst.setString(1, hid);
		pst.setString(2, hpass);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			auth.put("h_id", rs.getString("id"));
			auth.put("h_name", rs.getString("name"));
			auth.put("h_email", rs.getString("email"));
		}
		System.out.println(auth);
		return auth;
	}

	/**
	 * get the details of not affiliated doctors
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<HashMap<String, Object>> getUnAffiliatedDictors(int id) throws Exception {
		ArrayList<HashMap<String, Object>> ret = new ArrayList<HashMap<String, Object>>();
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement(
				"SELECT * FROM doctor LEFT JOIN hospitals_doctors_affiliation  ON  doctor.id=hospitals_doctors_affiliation.d_id AND hospitals_doctors_affiliation.h_id=? WHERE hospitals_doctors_affiliation.d_id IS NULL;");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			HashMap<String, Object> d_list = new HashMap<String, Object>();
			d_list.put("d_id", rs.getInt("id"));
			d_list.put("d_name", rs.getString("name"));
			d_list.put("d_email", rs.getString("email"));
			d_list.put("d_phone", rs.getString("phone"));
			d_list.put("d_specialization", rs.getString("specialization"));
			d_list.put("d_qualification", rs.getString("qualification"));
			d_list.put("d_address", rs.getString("address"));
			ret.add(d_list);
		}
		return ret;
	}

	/**
	 * returns the requests from doctors to the hospital
	 * 
	 * @param h_id
	 * @return
	 * @throws Exception
	 */
	public static int getPendingRequest(int h_id) throws Exception {
		int ret = 0;
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement(
				"SELECT * FROM `hospitals_doctors_affiliation` WHERE h_id = ? and d_req_code IS NOT NULL ;");
		pst.setInt(1, h_id);
		ResultSet rs = pst.executeQuery();
		while (rs.next())
			ret++;
		return ret;
	}

	/**
	 * get the pending request for the hospitals from the doctors
	 * 
	 * @param h_id
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<HashMap<String, Object>> getRecievedPendingRequest(int h_id) throws Exception {
		ArrayList<HashMap<String, Object>> ret = new ArrayList<HashMap<String, Object>>();
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement(
				"SELECT * FROM doctor LEFT JOIN hospitals_doctors_affiliation  ON  hospitals_doctors_affiliation.d_req_code IS NOT NULL AND doctor.id=hospitals_doctors_affiliation.d_id AND hospitals_doctors_affiliation.h_id=? WHERE hospitals_doctors_affiliation.d_id IS NOT NULL;");
		pst.setInt(1, h_id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			HashMap<String, Object> p_req = new HashMap<String, Object>();
			p_req.put("d_id", rs.getInt("id"));
			p_req.put("d_name", rs.getString("name"));
			p_req.put("d_email", rs.getString("email"));
			p_req.put("d_phone", rs.getString("phone"));
			p_req.put("d_specialization", rs.getString("specialization"));
			p_req.put("d_qualification", rs.getString("qualification"));
			p_req.put("d_address", rs.getString("address"));
			ret.add(p_req);
		}
		return ret;
	}
	
	/**
	 * get the pending sent request
	 * @param h_id
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<HashMap<String, Object>> getSentPendingRequest(int h_id) throws Exception {
		ArrayList<HashMap<String, Object>> ret = new ArrayList<HashMap<String, Object>>();
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement(
				"SELECT * FROM doctor LEFT JOIN hospitals_doctors_affiliation  ON  hospitals_doctors_affiliation.h_sent_code IS NOT NULL AND doctor.id=hospitals_doctors_affiliation.d_id AND hospitals_doctors_affiliation.h_id=? WHERE hospitals_doctors_affiliation.d_id IS NOT NULL;");
		pst.setInt(1, h_id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			HashMap<String, Object> p_req = new HashMap<String, Object>();
			p_req.put("d_id", rs.getInt("id"));
			p_req.put("d_name", rs.getString("name"));
			p_req.put("d_email", rs.getString("email"));
			p_req.put("d_phone", rs.getString("phone"));
			p_req.put("d_specialization", rs.getString("specialization"));
			p_req.put("d_qualification", rs.getString("qualification"));
			p_req.put("d_address", rs.getString("address"));
			ret.add(p_req);
		}
		return ret;
	}
	
	/**
	 * sends email to selected doctor
	 * @param h_id
	 * @param d_id
	 * @return
	 * @throws Exception
	 */
	public static String sendCodeToDoctor(int h_id,int d_id) throws Exception{
		String code = null;
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement("INSERT INTO `yourdocplus_db`.`hospitals_doctors_affiliation` (`h_id`, `d_id`, `h_sent_code`) VALUES (?,?,?);");
		code = OTPGenerator.generatePaasword();
		System.out.println(code);
		pst.setInt(1, h_id);
		pst.setInt(2, d_id);
		pst.setString(3, code);
		int e = pst.executeUpdate();
		if(e==1) {
			return code;
		}
		return null;

	}
	
	/**
	 * sends code to the doctor who had requested affiliation
	 * @param h_id
	 * @param d_id
	 * @return
	 * @throws Exception
	 */
	public static String sendCodeToDoctorRequest(int h_id,int d_id) throws Exception{
		String code = null;
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement("UPDATE `yourdocplus_db`.`hospitals_doctors_affiliation` SET `h_sent_code` = ?, `d_req_code` = ? WHERE (`h_id` = ? and `d_id` = ?);");
		code = OTPGenerator.generatePaasword();
		System.out.println(code);
		pst.setString(1, code);
		pst.setString(2,null);
		pst.setInt(3, h_id);
		pst.setInt(4, d_id);
		int e = pst.executeUpdate();
		if(e==1) {
			return code;
		}
		return null;

	}
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<HashMap<String, Object>> getAffiliatedDictors(int id) throws Exception {
		ArrayList<HashMap<String, Object>> ret = new ArrayList<HashMap<String, Object>>();
		Connection conn = dbUtil.DbConnect.getConnection();
		PreparedStatement pst = conn.prepareStatement(
				"SELECT * FROM doctor LEFT JOIN hospitals_doctors_affiliation  ON  doctor.id=hospitals_doctors_affiliation.d_id AND hospitals_doctors_affiliation.h_id=? AND hospitals_doctors_affiliation.status = 'true' WHERE hospitals_doctors_affiliation.d_id IS NULL;");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			HashMap<String, Object> d_list = new HashMap<String, Object>();
			d_list.put("d_id", rs.getInt("id"));
			d_list.put("d_name", rs.getString("name"));
			d_list.put("d_email", rs.getString("email"));
			d_list.put("d_phone", rs.getString("phone"));
			d_list.put("d_specialization", rs.getString("specialization"));
			d_list.put("d_qualification", rs.getString("qualification"));
			d_list.put("d_address", rs.getString("address"));
			ret.add(d_list);
		}
		return ret;
	}
}
