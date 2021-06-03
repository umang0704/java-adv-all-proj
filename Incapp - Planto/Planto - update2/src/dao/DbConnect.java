package dao;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
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
	public boolean addPlant(HashMap<String, Object> plant) throws Exception {
		PreparedStatement p=c.prepareStatement("select name from plants where name=?");
		p.setString(1, (String)plant.get("name"));
		ResultSet rs=p.executeQuery();
		if(rs.next()) {
			return false;
		}else {
			p.close();
			p=c.prepareStatement("insert into plants (name,price,description,category,height,photo,photo1,photo2,quantity) values (?,?,?,?,?,?,?,?,?)");
			p.setString(1, (String)plant.get("name"));
			p.setInt(2, (Integer)plant.get("price"));
			p.setString(3, (String)plant.get("description"));
			p.setString(4, (String)plant.get("category"));
			p.setDouble(5, (Double)plant.get("height"));
			p.setBinaryStream(6, (InputStream)plant.get("photo"));
			p.setBinaryStream(7, (InputStream)plant.get("photo1"));
			p.setBinaryStream(8, (InputStream)plant.get("photo2"));
			p.setInt(9, (Integer)plant.get("quantity"));
			p.executeUpdate();
			return true;
		}
	}
}
