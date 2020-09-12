import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private DatabaseOperations databaseOperations = DatabaseOperations.getDatabaseOperations();
	private UserFactory userFactory = new UserFactory();

	/**
	 * Create the frame.
	 */
	public AdminLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Admin Login");
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUsername.setBounds(65, 231, 91, 15);
		contentPane.add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Dialog", Font.PLAIN, 20));
		tfUsername.setColumns(10);
		tfUsername.setBounds(65, 254, 368, 41);
		contentPane.add(tfUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setBounds(65, 307, 91, 15);
		contentPane.add(lblPassword);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(65, 334, 368, 41);
		contentPane.add(pfPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = tfUsername.getText();
				String password = new String(pfPassword.getPassword());
				
				Admin admin = (Admin) userFactory.getUser("ADMIN");
				admin.setUsername(username);
				admin.setPassword(password);
				
				if(databaseOperations.loginAdmin(admin)) {
					AdminManagementPage adminManagementPage = new AdminManagementPage();
					setVisible(false);
					adminManagementPage.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "You don't have permission to do this !");
					return;
				}
			}
		});
		btnLogin.setBounds(291, 398, 142, 61);
		contentPane.add(btnLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerOrAdminPage customerOrAdminPage = new CustomerOrAdminPage();
				setVisible(false);
				customerOrAdminPage.setVisible(true);
			}
		});
		btnBack.setBounds(65, 398, 142, 61);
		contentPane.add(btnBack);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setFont(new Font("Dialog", Font.BOLD, 24));
		lblAdminLogin.setBounds(156, 12, 181, 41);
		contentPane.add(lblAdminLogin);
	}
}
