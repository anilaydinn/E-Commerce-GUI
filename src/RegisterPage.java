import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfSurname;
	private JTextField tfAge;
	private JTextField tfAddress;
	private JTextField tfPhone;
	private JTextField tfCity;
	private JTextField tfCountry;
	private DatabaseOperations databaseOperations = DatabaseOperations.getDatabaseOperations();
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private UserFactory userFactory = new UserFactory();

	/**
	 * Create the frame.
	 */
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 739);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Dialog", Font.BOLD, 24));
		lblRegister.setBounds(185, 0, 119, 41);
		contentPane.add(lblRegister);
		
		ButtonGroup btnGroup = new ButtonGroup();
		JRadioButton radioMale = new JRadioButton("Male");
		radioMale.setBounds(160, 340, 149, 23);
		contentPane.add(radioMale);
		
		JRadioButton radioFemale = new JRadioButton("Female");
		radioFemale.setBounds(335, 340, 149, 23);
		contentPane.add(radioFemale);
		btnGroup.add(radioMale);
		btnGroup.add(radioFemale);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Dialog", Font.PLAIN, 20));
		tfName.setColumns(10);
		tfName.setBounds(157, 53, 327, 41);
		contentPane.add(tfName);
		
		tfSurname = new JTextField();
		tfSurname.setFont(new Font("Dialog", Font.PLAIN, 20));
		tfSurname.setColumns(10);
		tfSurname.setBounds(157, 106, 327, 41);
		contentPane.add(tfSurname);
		
		tfAge = new JTextField();
		tfAge.setFont(new Font("Dialog", Font.PLAIN, 20));
		tfAge.setColumns(10);
		tfAge.setBounds(157, 158, 327, 41);
		contentPane.add(tfAge);
		
		tfAddress = new JTextField();
		tfAddress.setFont(new Font("Dialog", Font.PLAIN, 20));
		tfAddress.setColumns(10);
		tfAddress.setBounds(157, 371, 327, 41);
		contentPane.add(tfAddress);
		
		tfPhone = new JTextField();
		tfPhone.setFont(new Font("Dialog", Font.PLAIN, 20));
		tfPhone.setColumns(10);
		tfPhone.setBounds(157, 424, 327, 41);
		contentPane.add(tfPhone);
		
		tfCity = new JTextField();
		tfCity.setFont(new Font("Dialog", Font.PLAIN, 20));
		tfCity.setColumns(10);
		tfCity.setBounds(157, 477, 327, 41);
		contentPane.add(tfCity);
		
		tfCountry = new JTextField();
		tfCountry.setFont(new Font("Dialog", Font.PLAIN, 20));
		tfCountry.setColumns(10);
		tfCountry.setBounds(157, 530, 327, 41);
		contentPane.add(tfCountry);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = tfName.getText();
				String surname = tfSurname.getText();
				String username = tfUsername.getText();
				String password = new String(pfPassword.getPassword());
				int age;
				try {
					age = Integer.parseInt(tfAge.getText());
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Please enter your age !");
					return;
				}
				
				String gender;
				if(radioMale.isSelected()) {
					gender = "Male";
				}
				else if(radioFemale.isSelected()) {
					gender = "Female";
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select your gender !");
					return;
				}
				
				String address = tfAddress.getText();
				String phone = tfPhone.getText();
				String city = tfCity.getText();
				String country = tfCountry.getText();
				
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your name !");
					return;
				}
				
				if(surname.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your surname !");
					return;
				}
				
				if(username.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your username !");
					return;
				}
				
				if(password.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your password !");
					return;
				}
				
				if(address.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your adress !");
					return;
				}
				
				if(phone.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your phone number !");
					return;				
				}
				
				if(city.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your city information !");
					return;				
				}
				
				if(country.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your country information !");
					return;				
				}
				
				Customer customer = (Customer) userFactory.getUser("CUSTOMER");
				customer.setName(name);
				customer.setSurname(surname);
				customer.setUsername(username);
				customer.setPassword(password);
				customer.setAge(age);
				customer.setGender(gender);
				customer.setAddress(address);
				customer.setPhone(phone);
				customer.setCity(city);
				customer.setCountry(country);
				
				if(databaseOperations.addCustomer(customer)) {
					JOptionPane.showMessageDialog(null, "Registration succesful !");
					tfName.setText("");
					tfSurname.setText("");
					tfUsername.setText("");
					pfPassword.setText("");
					tfAge.setText("");
					radioMale.setSelected(false);
					radioFemale.setSelected(false);
					tfPhone.setText("");
					tfAddress.setText("");
					tfCity.setText("");
					tfCountry.setText("");
				}
				
				
			}
		});
		btnRegister.setBounds(368, 599, 117, 60);
		contentPane.add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerLoginPage loginPage = new CustomerLoginPage();
				setVisible(false);
				loginPage.setVisible(true);
			}
		});
		btnBack.setBounds(29, 599, 117, 60);
		contentPane.add(btnBack);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(42, 67, 70, 15);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSurname.setBounds(42, 121, 84, 15);
		contentPane.add(lblSurname);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAge.setBounds(42, 173, 84, 15);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGender.setBounds(42, 348, 84, 15);
		contentPane.add(lblGender);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAddress.setBounds(42, 386, 84, 15);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPhone.setBounds(42, 438, 84, 15);
		contentPane.add(lblPhone);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCity.setBounds(42, 492, 84, 15);
		contentPane.add(lblCity);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCountry.setBounds(42, 545, 84, 15);
		contentPane.add(lblCountry);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUsername.setBounds(42, 227, 104, 15);
		contentPane.add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Dialog", Font.PLAIN, 20));
		tfUsername.setColumns(10);
		tfUsername.setBounds(157, 211, 327, 41);
		contentPane.add(tfUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPassword.setBounds(42, 289, 104, 15);
		contentPane.add(lblPassword);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(159, 278, 325, 40);
		contentPane.add(pfPassword);
	}
}
