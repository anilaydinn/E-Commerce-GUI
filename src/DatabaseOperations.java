import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseOperations {
	
	private Connection con = null;
	private PreparedStatement preparedStatement = null;
	
	//Singleton
	private static DatabaseOperations databaseOperations = new DatabaseOperations();
	
	private DatabaseOperations() {
		String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_name + "?useUnicode=true&characterEncoding=utf8&useSSL=false";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			
			System.out.println("Driver couldn't find...");
		}
		
		try {
			
			con = DriverManager.getConnection(url, Database.username, Database.password);
			System.out.println("Connection succesful...");
		}
		catch(SQLException e) {
			
			System.out.println("Connection failed...");
		}
	}
	
	public static DatabaseOperations getDatabaseOperations() {
		
		return databaseOperations;
	}
	
	public boolean addCustomer(String name, String surname, String username, String password, int age, String gender, String address, String phone, String city, String country) {
		
		String query = "INSERT INTO Customer (name, surname, username, password, age, gender, address, phone, city, country) VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, password);
			preparedStatement.setInt(5, age);
			preparedStatement.setString(6, gender);
			preparedStatement.setString(7, address);
			preparedStatement.setString(8, phone);
			preparedStatement.setString(9, city);
			preparedStatement.setString(10, country);
			
			preparedStatement.executeUpdate();
			return true;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
public boolean loginCustomer(String username, String password) {
		
		String query = "SELECT * FROM Customer WHERE username = ? AND password = ?";
		
		try {
			
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			return rs.next();
		}catch(SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}
}
