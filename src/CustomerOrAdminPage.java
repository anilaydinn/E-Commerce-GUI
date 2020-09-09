import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerOrAdminPage extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerOrAdminPage frame = new CustomerOrAdminPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public CustomerOrAdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnAdmin = new JButton("Admin Login");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminLoginPage adminLoginPage = new AdminLoginPage();
				setVisible(false);
				adminLoginPage.setVisible(true);
			}
		});
		btnAdmin.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAdmin.setBounds(12, 320, 324, 125);
		contentPane.add(btnAdmin);
		
		JButton btnCustomer = new JButton("Customer Login");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CustomerLoginPage customerLoginPage = new CustomerLoginPage();
				setVisible(false);
				customerLoginPage.setVisible(true);
			}
		});
		btnCustomer.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCustomer.setBounds(379, 320, 324, 125);
		contentPane.add(btnCustomer);
	}
}
