import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.fabric.xmlrpc.base.Data;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;

public class AdminManagementPage extends JFrame {

	private JPanel contentPane;
	private DatabaseOperations databaseOperations = DatabaseOperations.getDatabaseOperations();
	private ArrayList<Customer> customers;
	private JTable customerTable;
	private DefaultTableModel model;


	/**
	 * Create the frame.
	 */
	public AdminManagementPage() {
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Admin Management");
	
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminLoginPage adminLoginPage = new AdminLoginPage();
				setVisible(false);
				adminLoginPage.setVisible(true);
			}
		});
		btnLogout.setBounds(29, 393, 156, 51);
		contentPane.add(btnLogout);
		
		JLabel lblCustomerList = new JLabel("Customer List");
		lblCustomerList.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCustomerList.setBounds(455, 12, 148, 15);
		contentPane.add(lblCustomerList);
		
		customerTable = new JTable();
		customerTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Surname", "Username", "Password", "Age", "Gender", "Address", "Phone", "City", "Country", "Balance"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		customerTable.setBounds(45, 46, 934, 330);
		contentPane.add(customerTable);
		model = (DefaultTableModel)customerTable.getModel();
		showCustomers();
		
		double totalIncome = databaseOperations.getTotalIncome();
		JLabel lblTotalIncome = new JLabel("");
		lblTotalIncome.setBounds(479, 411, 513, 15);
		contentPane.add(lblTotalIncome);
		lblTotalIncome.setText("Total Income: " + Double.toString(totalIncome) + " TL");
		
	}
	
	public void showCustomers() {
		model.setRowCount(0);
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		
		customers = databaseOperations.getAllCustomer();
		
		if(customers != null) {
			
			for(Customer customer : customers) {
				Object[] willAdd = {customer.getName(),customer.getSurname(),customer.getUsername(),customer.getPassword(),customer.getAge(),customer.getGender(),customer.getAddress(),customer.getPhone(),customer.getCity(),customer.getCountry(),customer.getBalance()};
				model.addRow(willAdd);
			}
		}
	}
}
