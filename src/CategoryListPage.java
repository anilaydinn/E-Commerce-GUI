import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CategoryListPage extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public CategoryListPage(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		ImageIcon userImage = new ImageIcon("img/user.png");
		JLabel lblUserImg = new JLabel("");
		lblUserImg.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CustomerAccountPage customerAccountPage = new CustomerAccountPage(username);
				setVisible(false);
				customerAccountPage.setVisible(true);
			}
		});
		lblUserImg.setBounds(825, 12, 49, 44);
		contentPane.add(lblUserImg);
		lblUserImg.setIcon(userImage);
		
		ImageIcon technologyImage = new ImageIcon("img/computer.png");
		JLabel lblTechnology = new JLabel("");
		lblTechnology.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TechnologyProductsPage technologyProductPage = new TechnologyProductsPage(username);
				setVisible(false);
				technologyProductPage.setVisible(true);
			}
		});
		lblTechnology.setBounds(171, 156, 128, 128);
		contentPane.add(lblTechnology);
		lblTechnology.setIcon(technologyImage);
		
		ImageIcon carImage = new ImageIcon("img/car.png");
		JLabel lblAutomotive = new JLabel("");
		lblAutomotive.setBounds(583, 156, 128, 128);
		contentPane.add(lblAutomotive);
		lblAutomotive.setIcon(carImage);
		lblAutomotive.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CarProductsPage carProductsPage = new CarProductsPage(username);
				setVisible(false);
				carProductsPage.setVisible(true);
			}
		});
		
		JLabel lblTechnologyText = new JLabel("Technology");
		lblTechnologyText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTechnologyText.setBounds(195, 296, 115, 19);
		contentPane.add(lblTechnologyText);
		
		JLabel lblAutomotiveText = new JLabel("Automotive");
		lblAutomotiveText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAutomotiveText.setBounds(593, 296, 115, 19);
		contentPane.add(lblAutomotiveText);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerLoginPage customerLoginPage = new CustomerLoginPage();
				setVisible(false);
				customerLoginPage.setVisible(true);
			}
		});
		btnLogout.setBounds(746, 456, 128, 58);
		contentPane.add(btnLogout);
		
		
	}
}
