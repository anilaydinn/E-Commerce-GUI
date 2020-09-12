import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import com.mysql.fabric.xmlrpc.base.Array;

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
	
	public Computer getComputerByBrand(String brand) {
		String query = "SELECT * FROM Computer WHERE brand = ?";
		Computer computer = new Computer();
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, brand);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				computer.setBrand(rs.getString("brand"));
				computer.setModel(rs.getString("model"));
				computer.setGraphicCard(rs.getString("graphicCard"));
				computer.setOperatingSystem(rs.getString("operatingSystem"));
				computer.setPrice(rs.getDouble("price"));
				computer.setProcessor(rs.getString("processor"));
				computer.setRam(rs.getString("ram"));
			}
			return computer;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Phone getPhoneByBrand(String brand) {
		String query = "SELECt * FROM Phone WHERE brand = ?";
		Phone phone = new Phone();
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, brand);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				phone.setBrand(rs.getString("brand"));
				phone.setModel(rs.getString("model"));
				phone.setDoubleSim(rs.getBoolean("isDoubleSim"));
				phone.setScreenSize(rs.getInt("screenSize"));
				phone.setPrice(rs.getDouble("price"));
				phone.setProcessor(rs.getString("processor"));
				phone.setRam(rs.getString("ram"));
			}
			return phone;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Customer getCustomerByUsername(String username) {
		String query = "SELECT * FROM Customer WHERE username = ?";
		Customer customer = new Customer();
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				
				customer.setName(rs.getString("name"));
				customer.setSurname(rs.getString("surname"));
				customer.setAge(rs.getInt("age"));
				customer.setAddress(rs.getString("address"));
				customer.setBalance(rs.getDouble("balance"));
				customer.setCity(rs.getString("city"));
				customer.setGender(rs.getString("gender"));
				customer.setCountry(rs.getString("country"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("password"));
			}
			return customer;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Car getCarByBrand(String brand) {
		String query = "SELECT * FROM Car WHERE brand = ?";
		Car car = new Car();
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, brand);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				car.setBrand(rs.getString("brand"));
				car.setModel(rs.getString("model"));
				car.setMotorVolume(rs.getInt("motorVolume"));
				car.setNumberOfDoors(rs.getInt("numberOfDoors"));
				car.setPrice(rs.getDouble("price"));
				car.setTorque(rs.getInt("torque"));
				car.setType(rs.getString("type"));
			}
			return car;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void addProductToCart(String username, Product product) {
		String query = "INSERT INTO Cart (username, brand, model, price) VALUES (?,?,?,?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, product.getBrand());
			preparedStatement.setString(3, product.getModel());
			preparedStatement.setDouble(4, product.getPrice());
			
			preparedStatement.executeUpdate();
			return;
		}catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public ListModel<Object> updateJList(String username){
		String query = "SELECT * FROM Cart WHERE username = ?";
		
		try {
			
			DefaultListModel<Object> model = new DefaultListModel<Object>();
			
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, username);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String productString = rs.getString("brand") + " " + rs.getString("model") + " " + rs.getString("price") + " TL";
				model.addElement(productString);
			}
			
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deleteProductByUsername(String username) {
		String query = "DELETE FROM Cart WHERE username = ?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, username);
			
			preparedStatement.execute();
			
			return;
		}catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public double getCurrentCartCost(String username) {
		String query = "SELECT * FROM Cart WHERE username = ?";
		double totalCost = 0;
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, username);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				totalCost += rs.getDouble("price");
			}
			return totalCost;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void setCustomerBalance(String username, double balance) {
		String query = "UPDATE Customer SET balance = ? WHERE username = ?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setDouble(1, balance);
			preparedStatement.setString(2, username);
			
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Customer> getAllCustomer(){
		String query = "SELECT * FROM Customer";
		
		try {
			ArrayList<Customer> customers = new ArrayList<Customer>();
			
			preparedStatement = con.prepareStatement(query);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String city = rs.getString("city");
				String country = rs.getString("country");
				double balance = rs.getDouble("balance");
				
				customers.add(new Customer(username, password, name, surname, age, gender, address, phone, city, country, balance));
			}
			return customers;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean isUsernameExists(String username) {
		String query = "SELECT * FROM Customer WHERE username = ?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, username);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("username") != null) {
					return true;
				}else {
					return false;
				}
			}
			else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void addIncome(double earn) {
		String query="INSERT INTO Income (earn) VALUES (?)";
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setDouble(1, earn);
			
			preparedStatement.executeUpdate();
			return;
		}catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public double getTotalIncome() {
		String query = "SELECT * FROM Income";
		double totalIncome = 0;
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			
			while(rs.next()) {
				totalIncome += rs.getDouble("earn");
			}
			return totalIncome;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
