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

public class ProductDetailsPage extends JFrame {

	private JPanel contentPane;
	private Product product;
	private Computer computer;
	private Car car;
	private Phone phone;
	/**
	 * Create the frame.
	 */
	public ProductDetailsPage(Product product) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBrandModel = new JLabel("");
		lblBrandModel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblBrandModel.setBounds(196, 12, 265, 32);
		contentPane.add(lblBrandModel);
		
		lblBrandModel.setText(product.getBrand() + " " + product.getModel());
		
		JLabel lblPC1 = new JLabel("");
		lblPC1.setBounds(34, 12, 128, 128);
		contentPane.add(lblPC1);
		BufferedImage imgPc1 = null;
		try {
			imgPc1 = ImageIO.read(new File("img/pc1.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Image resizedImgPc1 = imgPc1.getScaledInstance(lblPC1.getWidth(), lblPC1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon pc1Icon = new ImageIcon(resizedImgPc1);
		lblPC1.setIcon(pc1Icon);
		
		JLabel lblPrice = new JLabel("");
		lblPrice.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPrice.setBounds(323, 302, 138, 15);
		contentPane.add(lblPrice);
		lblPrice.setText(Double.toString(product.getPrice()) + " TL");
	}

}
