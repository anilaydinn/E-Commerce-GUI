import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarProductDetailsPage extends JFrame {

	private JPanel contentPane;
	private Car car;
	private DatabaseOperations databaseOperations = DatabaseOperations.getDatabaseOperations();
	/**
	 * Create the frame.
	 */
	public CarProductDetailsPage(String username,Product product, ImageIcon icon) {
		
		this.car = databaseOperations.getCarByBrand(product.getBrand());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblBrandModel = new JLabel("");
		lblBrandModel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblBrandModel.setBounds(196, 12, 265, 32);
		contentPane.add(lblBrandModel);
		lblBrandModel.setText(this.car.getBrand() + " " + this.car.getModel());
		
		JLabel lblPC1 = new JLabel("");
		lblPC1.setBounds(34, 12, 128, 128);
		contentPane.add(lblPC1);
		lblPC1.setIcon(icon);
		
		JLabel lblPrice = new JLabel("");
		lblPrice.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPrice.setBounds(323, 302, 138, 15);
		contentPane.add(lblPrice);
		lblPrice.setText(Double.toString(this.car.getPrice()) + " TL");
		
		JLabel lblTorque = new JLabel("");
		lblTorque.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTorque.setBounds(196, 68, 265, 15);
		contentPane.add(lblTorque);
		lblTorque.setText("Torque: " + this.car.getTorque());
		
		
		JLabel lblMotorVolume = new JLabel("");
		lblMotorVolume.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMotorVolume.setBounds(196, 124, 295, 15);
		contentPane.add(lblMotorVolume);
		lblMotorVolume.setText("Motor Volume: " + this.car.getMotorVolume());
		
		JLabel lblType = new JLabel("");
		lblType.setFont(new Font("Dialog", Font.BOLD, 16));
		lblType.setBounds(196, 169, 295, 15);
		contentPane.add(lblType);
		lblType.setText("Type: " + this.car.getType());
		
		JLabel lblNumberOfDoors = new JLabel("");
		lblNumberOfDoors.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNumberOfDoors.setBounds(196, 218, 295, 15);
		contentPane.add(lblNumberOfDoors);
		lblNumberOfDoors.setText("Number Of Doors: " + this.car.getNumberOfDoors());
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CarProductsPage carProductsPage = new CarProductsPage(username);
				setVisible(false);
				carProductsPage.setVisible(true);
			}
		});
		btnBack.setBounds(12, 346, 150, 48);
		contentPane.add(btnBack);
		
		JButton btnAddCart = new JButton("Add Cart");
		btnAddCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				databaseOperations.addProductToCart(username, car);
			}
		});
		btnAddCart.setBounds(323, 346, 150, 48);
		contentPane.add(btnAddCart);
		
	}
}
