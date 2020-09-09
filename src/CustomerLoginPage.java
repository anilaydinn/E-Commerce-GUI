import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CustomerLoginPage extends JFrame {

	private JPanel contentPane;
	private DatabaseOperations databaseOperations = DatabaseOperations.getDatabaseOperations();
	private JTextField tfUsername;
	private JPasswordField pfPassword;

	/**
	 * Create the frame.
	 */
	public CustomerLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Dialog", Font.PLAIN, 20));
		tfUsername.setBounds(137, 244, 368, 41);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String username = tfUsername.getText();
				String password = new String(pfPassword.getPassword());
				
				if(databaseOperations.loginCustomer(username, password)) {
					ProductListPage productListPage = new ProductListPage(username);
					setVisible(false);
					productListPage.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Username or password incorrect !");
					return;
				}
			}
		});
		btnLogin.setBounds(363, 388, 142, 61);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RegisterPage registerPage = new RegisterPage();
				setVisible(false);
				registerPage.setVisible(true);
			}
		});
		btnRegister.setBounds(137, 388, 142, 61);
		contentPane.add(btnRegister);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUsername.setBounds(137, 221, 91, 15);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setBounds(137, 297, 91, 15);
		contentPane.add(lblPassword);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 24));
		lblLogin.setBounds(284, 12, 85, 41);
		contentPane.add(lblLogin);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(137, 324, 368, 41);
		contentPane.add(pfPassword);
	}
}
