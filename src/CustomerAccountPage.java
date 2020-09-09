import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerAccountPage extends JFrame {

	private JPanel contentPane;
	private DatabaseOperations databaseOperations = DatabaseOperations.getDatabaseOperations();

	/**
	 * Create the frame.
	 */
	public CustomerAccountPage(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JLabel lblBalance = new JLabel("Balance: ");
		lblBalance.setFont(new Font("Dialog", Font.BOLD, 16));
		lblBalance.setBounds(400, 12, 194, 26);
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
		btnAddCash.setBounds(410, 50, 117, 25);
		contentPane.add(btnAddCash);
	}

}
