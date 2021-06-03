package dao;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
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
	public String getUserLogin(String email,String password) throws Exception{
		PreparedStatement p=c.prepareStatement("select name from users where email=? and password=?");
		p.setString(1, email);
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
	public ArrayList<HashMap> getAllPlants() throws Exception {
		PreparedStatement p=c.prepareStatement("select * from plants order by name");
		ResultSet rs=p.executeQuery();
		ArrayList<HashMap> allPlants=new ArrayList();
		while(rs.next()) {
			HashMap<String,Object> plant=new HashMap<String, Object>();
			plant.put("plant_id",rs.getInt("plant_id"));
			plant.put("name",rs.getString("name"));
			plant.put("price",rs.getInt("price"));
			plant.put("category",rs.getString("category"));
			plant.put("height",rs.getDouble("height"));
			plant.put("quantity",rs.getInt("quantity"));
			allPlants.add(plant);
		}
		return allPlants;
	}
	public HashMap<String,Object> getPlantByID(int i) throws Exception {
		PreparedStatement p=c.prepareStatement("select * from plants where plant_id=?");
		p.setInt(1, i);
		ResultSet rs=p.executeQuery();
		HashMap<String,Object> plant=null;
		if(rs.next()) {
			plant=new HashMap<String, Object>();
			plant.put("plant_id",rs.getInt("plant_id"));
			plant.put("name",rs.getString("name"));
			plant.put("description",rs.getString("description"));
			plant.put("price",rs.getInt("price"));
			plant.put("category",rs.getString("category"));
			plant.put("height",rs.getDouble("height"));
			plant.put("quantity",rs.getInt("quantity"));
		}
		return plant;
	}
	public byte[] getPhoto(int plant_id,int photo_no) throws Exception{
		PreparedStatement p;
		if(photo_no==1)
			p=c.prepareStatement("select photo from plants where plant_id=?");
		if(photo_no==2)
			p=c.prepareStatement("select photo1 from plants where plant_id=?");
		else
			p=c.prepareStatement("select photo2 from plants where plant_id=?");
		p.setInt(1, plant_id);
		ResultSet rs=p.executeQuery();
		byte []photo=null;
		if(rs.next()) {
			photo=rs.getBytes(1);
		}
		return photo;
	}
	public boolean deletePlant(int plant_id) throws Exception {
		PreparedStatement p=c.prepareStatement("delete from plants where plant_id=?");
		p.setInt(1, plant_id);
		int result=p.executeUpdate();
		if(result!=0)
			return true;
		else
			return false;
	}
	public ArrayList<HashMap> getPlantLikeName(String name) throws Exception {
		PreparedStatement p=c.prepareStatement("select * from plants where name like ?");
		p.setString(1, "%"+name+"%");
		ResultSet rs=p.executeQuery();
		ArrayList<HashMap> allPlants=new ArrayList();
		while(rs.next()) {
			HashMap<String,Object> plant=new HashMap<String, Object>();
			plant.put("plant_id",rs.getInt("plant_id"));
			plant.put("name",rs.getString("name"));
			plant.put("price",rs.getInt("price"));
			plant.put("category",rs.getString("category"));
			plant.put("quantity",rs.getInt("quantity"));
			allPlants.add(plant);
		}
		return allPlants;
	}
	public boolean setUser(HashMap<String,String> user) throws Exception {
		PreparedStatement p=c.prepareStatement("insert into users (email,password,name,phone) values(?,?,?,?)");
		p.setString(1, user.get("email"));
		p.setString(2, user.get("password"));
		p.setString(3, user.get("name"));
		p.setString(4, user.get("phone"));
		try{
			p.executeUpdate();
			return true;
		}catch(java.sql.SQLIntegrityConstraintViolationException ex) {
			return false;
		}
	}
	public boolean addCart(int plant_id,String email) throws Exception {
		PreparedStatement pp=c.prepareStatement("select * from plants where plant_id=? and quantity>0");
		pp.setInt(1, plant_id);
		ResultSet r=pp.executeQuery();
		if(r.next()) {
			pp.close();
			PreparedStatement p=c.prepareStatement("select cart_id from cart where email=? and plant_id=?");
			p.setString(1,email);
			p.setInt(2,plant_id);
			ResultSet rs=p.executeQuery();
			if(rs.next()) {
				int cart_id=rs.getInt("cart_id");
				p.close();
				p=c.prepareStatement("update cart set quantity=quantity+1 where cart_id="+cart_id);
				p.executeUpdate();
				return true;
			}else {
				p.close();
				p=c.prepareStatement("insert into cart (email,plant_id,quantity) values (?,?,1)");
				p.setString(1, email);
				p.setInt(2, plant_id);
				p.executeUpdate();
				return true;
			}
		}else {
			return false;
		}
	}
	public int getCartCount(String email) throws Exception  {
		PreparedStatement p=c.prepareStatement("select quantity from cart where email=?");
		p.setString(1, email);
		ResultSet rs=p.executeQuery();
		int count=0;
		while(rs.next()) {
			count += rs.getInt("quantity");
		}
		return count;
	}
	public ArrayList<HashMap> getCartPlantbyEmail(String email) throws Exception {
		PreparedStatement p=c.prepareStatement("select * from cart where email=?");
		p.setString(1, email);
		ResultSet rs=p.executeQuery();
		ArrayList<HashMap> allPlants=new ArrayList();
		while(rs.next()) {
			HashMap<String,Object> plant=new HashMap<String, Object>();
			plant.put("plant_id",rs.getInt("plant_id"));
			plant.put("quantity",rs.getInt("quantity"));
			plant.put("cart_id",rs.getInt("cart_id"));
			allPlants.add(plant);
		}
		return allPlants;
	}
	public boolean updateCart(int quantity,int cart_id) throws Exception {
		PreparedStatement p=c.prepareStatement("update cart set quantity=? where cart_id=?");
		p.setInt(1, quantity);
		p.setInt(2, cart_id);
		int result=p.executeUpdate();
		if(result!=0)
			return true;
		else
			return false;
	}
	public boolean deleteFromCart(int cart_id) throws Exception {
		PreparedStatement p=c.prepareStatement("delete from cart where cart_id=?");
		p.setInt(1, cart_id);
		int result=p.executeUpdate();
		if(result!=0)
			return true;
		else
			return false;
	}
	public ArrayList<String> getAddress(String email) throws Exception {
		PreparedStatement p=c.prepareStatement("select * from user_address where email=?");
		p.setString(1, email);
		ResultSet rs=p.executeQuery();
		ArrayList<String> addresses=new ArrayList();
		while(rs.next()) {
			addresses.add(rs.getString("address"));
		}
		return addresses;
	}
}
