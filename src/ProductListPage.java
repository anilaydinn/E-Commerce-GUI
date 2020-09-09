import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class ProductListPage extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public ProductListPage(String username) {
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
	}

}
