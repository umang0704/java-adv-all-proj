package servlet;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletContext;

public class DbData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/call?useSSL=false", "root", "Umang@123");
			Statement st = c.createStatement();

			String fileName = "C:\\Users\\hp\\Desktop\\Contacts2020.txt";
			Path path = Paths.get(fileName);
			Scanner scanner = new Scanner(path);

			scanner.useDelimiter(System.getProperty("line.separator")); 
			int i=0;
			while (scanner.hasNext()) {
				String line = scanner.next();
				boolean newContact = false;
				if (line.contains("FN:")) {
					st.executeUpdate("insert into call.call(id,name) values("+ ++i +",'"+line.substring(4)+"')");
				}
			} 
			scanner.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
