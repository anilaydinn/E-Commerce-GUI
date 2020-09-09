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
	
	public boolean addCustomer(Customer customer) {
		
		String query = "INSERT INTO Customer (name, surname, username, password, age, gender, address, phone, city, country) VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getSurname());
			preparedStatement.setString(3, customer.getUsername());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.setInt(5, customer.getAge());
			preparedStatement.setString(6, customer.getGender());
			preparedStatement.setString(7, customer.getAddress());
			preparedStatement.setString(8, customer.getPhone());
			preparedStatement.setString(9, customer.getCity());
			preparedStatement.setString(10, customer.getCountry());
			
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
	
	public boolean loginAdmin(Admin admin) {
		String query = "SELECT * FROM Admin WHERE username = ? AND password = ?";
		
		try {
			
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, admin.getUsername());
			preparedStatement.setString(2, admin.getPassword());
			
			ResultSet rs = preparedStatement.executeQuery();
			
			return rs.next();
		}catch(SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	public double getCustomerCurrentBalance(String username) {
		String query = "SELECT * FROM Customer WHERE username = ?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, username);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				return rs.getDouble("balance");
			}
			else {
				System.out.println("test");
				return 0;
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
	
	}
	
	public void addCashByUsername(double oldMoney,String username,double money) {
		String query = "UPDATE Customer SET balance = "+ oldMoney+ " + ? WHERE username = ?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setDouble(1, money);
			preparedStatement.setString(2, username);
			preparedStatement.execute();
			
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			return;
		}
	}
}
