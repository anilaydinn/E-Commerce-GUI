import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class CustomerAccountPage extends JFrame {

	private JPanel contentPane;
	private DatabaseOperations databaseOperations = DatabaseOperations.getDatabaseOperations();
	private Customer customer;
	private DefaultListModel<Object> listModel;

	/**
	 * Create the frame.
	 */
	public CustomerAccountPage(String username) {
		
		listModel = (DefaultListModel<Object>) databaseOperations.updateJList(username);
		customer = databaseOperations.getCustomerByUsername(username);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList jlCart = new JList();
		jlCart.setBounds(287, 107, 286, 228);
		contentPane.add(jlCart);
		jlCart.setModel(listModel);
			
		JLabel lblBalance = new JLabel("Balance: ");
		lblBalance.setFont(new Font("Dialog", Font.BOLD, 16));
		lblBalance.setBounds(281, 12, 313, 26);
		contentPane.add(lblBalance);
		setLocationRelativeTo(null);
		
		lblBalance.setText("Balance: " + Double.toString(databaseOperations.getCustomerCurrentBalance(username)) + " TL");
		
		JButton btnAddCash = new JButton("Add Cash");
		btnAddCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String addCash = JOptionPane.showInputDialog("How much will you add ?");
				double money = Double.parseDouble(addCash);
				databaseOperations.addCashByUsername(databaseOperations.getCustomerCurrentBalance(username),username,money);
				lblBalance.setText("Balance: " + Double.toString(databaseOperations.getCustomerCurrentBalance(username)) + " TL");
			}
		});
		btnAddCash.setBounds(456, 50, 117, 25);
		contentPane.add(btnAddCash);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CategoryListPage categoryListPage = new CategoryListPage(username);
				setVisible(false);
				categoryListPage.setVisible(true);
			}
		});
		btnBack.setBounds(27, 346, 140, 63);
		contentPane.add(btnBack);
		
		JLabel lblName = new JLabel("");
		lblName.setBounds(47, 32, 222, 15);
		contentPane.add(lblName);
		lblName.setText("Name: " + customer.getName());
		
		JLabel lblSurname = new JLabel("");
		lblSurname.setBounds(47, 59, 222, 15);
		contentPane.add(lblSurname);
		lblSurname.setText("Surname: " + customer.getSurname());
		
		JLabel lblAge = new JLabel("");
		lblAge.setBounds(47, 86, 222, 15);
		contentPane.add(lblAge);
		lblAge.setText("Age: " + Integer.toString(customer.getAge()));
		
		JLabel lblCity = new JLabel("");
		lblCity.setBounds(47, 113, 222, 15);
		contentPane.add(lblCity);
		lblCity.setText("City: " + customer.getCity());
		
		JLabel lblAddress = new JLabel("");
		lblAddress.setBounds(47, 140, 222, 15);
		contentPane.add(lblAddress);
		lblAddress.setText("Address: " + customer.getAddress());
		
		JLabel lblCountry = new JLabel("");
		lblCountry.setBounds(47, 167, 222, 15);
		contentPane.add(lblCountry);
		lblCountry.setText("Country: " + customer.getCountry());
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double userBalance = databaseOperations.getCustomerCurrentBalance(username);
				double currentCartCost = databaseOperations.getCurrentCartCost(username);
				
				if(listModel.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Cart is empty!");
				}
				else if(userBalance > currentCartCost) {
					databaseOperations.deleteProductByUsername(username);
					jlCart.setModel(databaseOperations.updateJList(username));
					lblBalance.setText("Balance: " + Double.toString(userBalance - currentCartCost) + " TL");
					databaseOperations.setCustomerBalance(username, userBalance - currentCartCost);
					databaseOperations.addIncome(currentCartCost);
					JOptionPane.showMessageDialog(null, "Purchase successful !");
				}
				else {
					JOptionPane.showMessageDialog(null, "You don't have enough money!");
				}
			}
		});
		btnBuy.setBounds(457, 346, 117, 63);
		contentPane.add(btnBuy);
		
		JLabel lblCart = new JLabel("Cart");
		lblCart.setBounds(281, 86, 39, 15);
		contentPane.add(lblCart);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.clear();
				databaseOperations.deleteProductByUsername(username);
			}
		});
		btnClear.setBounds(287, 347, 117, 63);
		contentPane.add(btnClear);
	}
}
