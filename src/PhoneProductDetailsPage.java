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

public class PhoneProductDetailsPage extends JFrame {

	private JPanel contentPane;
	private Phone phone;
	private DatabaseOperations databaseOperations = DatabaseOperations.getDatabaseOperations();
	/**
	 * Create the frame.
	 */
	public PhoneProductDetailsPage(String username,Product product, ImageIcon icon) {
		
		this.phone = databaseOperations.getPhoneByBrand(product.getBrand());
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
		lblBrandModel.setText(this.phone.getBrand() + " " + this.phone.getModel());
		
		JLabel lblPC1 = new JLabel("");
		lblPC1.setBounds(34, 12, 128, 128);
		contentPane.add(lblPC1);
		lblPC1.setIcon(icon);
		
		JLabel lblPrice = new JLabel("");
		lblPrice.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPrice.setBounds(323, 302, 138, 15);
		contentPane.add(lblPrice);
		lblPrice.setText(Double.toString(this.phone.getPrice()) + " TL");
		
		JLabel lblRam = new JLabel("");
		lblRam.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRam.setBounds(196, 68, 265, 15);
		contentPane.add(lblRam);
		lblRam.setText("RAM: " + this.phone.getRam());
		
		
		JLabel lblGraphicCard = new JLabel("");
		lblGraphicCard.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGraphicCard.setBounds(196, 124, 295, 15);
		contentPane.add(lblGraphicCard);
		lblGraphicCard.setText("Screen Size: " + this.phone.getScreenSize());
		
		JLabel lblOperatingSystem = new JLabel("");
		lblOperatingSystem.setFont(new Font("Dialog", Font.BOLD, 16));
		lblOperatingSystem.setBounds(196, 169, 295, 15);
		contentPane.add(lblOperatingSystem);
		lblOperatingSystem.setText("SIM: " + this.phone.getDoubleSim());
		
		JLabel lblProcessor = new JLabel("");
		lblProcessor.setFont(new Font("Dialog", Font.BOLD, 16));
		lblProcessor.setBounds(196, 218, 295, 15);
		contentPane.add(lblProcessor);
		lblProcessor.setText("Processor: " + this.phone.getProcessor());
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TechnologyProductsPage technologyProductsPage = new TechnologyProductsPage(username);
				setVisible(false);
				technologyProductsPage.setVisible(true);
			}
		});
		btnBack.setBounds(12, 346, 150, 48);
		contentPane.add(btnBack);
		
		JButton btnAddCart = new JButton("Add Cart");
		btnAddCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				databaseOperations.addProductToCart(username, phone);
			}
		});
		btnAddCart.setBounds(323, 346, 150, 48);
		contentPane.add(btnAddCart);
	}
}
