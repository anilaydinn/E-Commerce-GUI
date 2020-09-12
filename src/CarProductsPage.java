import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarProductsPage extends JFrame {

	private JPanel contentPane;
	private ProductFactory productFactory = new ProductFactory();

	/**
	 * Create the frame.
	 */
	
	public CarProductsPage(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		
		JLabel lblCar1 = new JLabel("");
		lblCar1.setBounds(68, 162, 147, 142);
		contentPane.add(lblCar1);
		BufferedImage imgCar1 = null;
		try {
			imgCar1 = ImageIO.read(new File("img/tesla.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Image resizedImgCar1 = imgCar1.getScaledInstance(lblCar1.getWidth(), lblCar1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon car1Icon = new ImageIcon(resizedImgCar1);
		lblCar1.setIcon(car1Icon);
		lblCar1.addMouseListener(new MouseListener() {
			
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
				Car car = (Car) productFactory.getProduct("CAR");
				car.setBrand("Tesla");
				CarProductDetailsPage carProductDetailsPage = new CarProductDetailsPage(username,car,car1Icon);
				setVisible(false);
				carProductDetailsPage.setVisible(true);
			}
		});
		
		JLabel lblCar2 = new JLabel("");
		lblCar2.setBounds(344, 162, 147, 142);
		contentPane.add(lblCar2);
		BufferedImage imgCar2 = null;
		try {
			imgCar2 = ImageIO.read(new File("img/bmw.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Image resizedImgCar2 = imgCar2.getScaledInstance(lblCar2.getWidth(), lblCar2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon car2Icon = new ImageIcon(resizedImgCar2);
		lblCar2.setIcon(car2Icon);
		lblCar2.addMouseListener(new MouseListener() {
			
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
				Car car = (Car)productFactory.getProduct("CAR");
				car.setBrand("BMW");
				CarProductDetailsPage carProductDetailsPage = new CarProductDetailsPage(username,car,car2Icon);
				setVisible(false);
				carProductDetailsPage.setVisible(true);
			}
		});
		
		JLabel lblCar3 = new JLabel("");
		lblCar3.setBounds(634, 162, 147, 142);
		contentPane.add(lblCar3);
		BufferedImage imgCar3 = null;
		try {
			imgCar3 = ImageIO.read(new File("img/s2000.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Image resizedImgPc3 = imgCar3.getScaledInstance(lblCar3.getWidth(), lblCar3.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon car3Icon = new ImageIcon(resizedImgPc3);
		lblCar3.setIcon(car3Icon);
		lblCar3.addMouseListener(new MouseListener() {
			
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
				Car car = (Car)productFactory.getProduct("CAR");
				car.setBrand("Honda");
				CarProductDetailsPage carProductDetailsPage = new CarProductDetailsPage(username,car,car3Icon);
				setVisible(false);
				carProductDetailsPage.setVisible(true);
			}
		});
		
		ImageIcon userImage = new ImageIcon("img/user.png");
		JLabel lblUserImg = new JLabel("");
		lblUserImg.addMouseListener(new MouseListener() {
			
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
				CustomerAccountPage customerAccountPage = new CustomerAccountPage(username);
				setVisible(false);
				customerAccountPage.setVisible(true);
			}
		});

		lblUserImg.setBounds(797, 12, 49, 44);
		contentPane.add(lblUserImg);
		lblUserImg.setIcon(userImage);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CategoryListPage categoryListPage = new CategoryListPage(username);
				setVisible(false);
				categoryListPage.setVisible(true);
			}
		});
		btnBack.setBounds(12, 446, 136, 44);
		contentPane.add(btnBack);
	
	}
}
