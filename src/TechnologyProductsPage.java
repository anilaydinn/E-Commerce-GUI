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

public class TechnologyProductsPage extends JFrame {

	private JPanel contentPane;
	private ProductFactory productFactory = new ProductFactory();

	/**
	 * Create the frame.
	 */
	
	public TechnologyProductsPage(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		
		JLabel lblPC1 = new JLabel("");
		lblPC1.setBounds(69, 58, 147, 142);
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
		lblPC1.addMouseListener(new MouseListener() {
			
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
				Computer computer = (Computer) productFactory.getProduct("COMPUTER");
				computer.setBrand("Asus");
				TechnologyProductDetailsPage productDetailsPage = new TechnologyProductDetailsPage(username,computer,pc1Icon);
				setVisible(false);
				productDetailsPage.setVisible(true);
			}
		});
		
		JLabel lblPC2 = new JLabel("");
		lblPC2.setBounds(345, 58, 147, 142);
		contentPane.add(lblPC2);
		BufferedImage imgPc2 = null;
		try {
			imgPc2 = ImageIO.read(new File("img/pc2.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Image resizedImgPc2 = imgPc2.getScaledInstance(lblPC2.getWidth(), lblPC2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon pc2Icon = new ImageIcon(resizedImgPc2);
		lblPC2.setIcon(pc2Icon);
		lblPC2.addMouseListener(new MouseListener() {
			
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
				Computer computer = (Computer)productFactory.getProduct("COMPUTER");
				computer.setBrand("Monster");
				TechnologyProductDetailsPage productDetailsPage = new TechnologyProductDetailsPage(username,computer,pc2Icon);
				setVisible(false);
				productDetailsPage.setVisible(true);
			}
		});
		
		JLabel lblPC3 = new JLabel("");
		lblPC3.setBounds(635, 58, 147, 142);
		contentPane.add(lblPC3);
		BufferedImage imgPc3 = null;
		try {
			imgPc3 = ImageIO.read(new File("img/pc3.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Image resizedImgPc3 = imgPc3.getScaledInstance(lblPC3.getWidth(), lblPC3.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon pc3Icon = new ImageIcon(resizedImgPc3);
		lblPC3.setIcon(pc3Icon);
		lblPC3.addMouseListener(new MouseListener() {
			
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
				Computer computer = (Computer)productFactory.getProduct("COMPUTER");
				computer.setBrand("Apple");
				TechnologyProductDetailsPage productDetailsPage = new TechnologyProductDetailsPage(username,computer,pc3Icon);
				setVisible(false);
				productDetailsPage.setVisible(true);
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
		
		JLabel lblPhone1 = new JLabel("");
		lblPhone1.setBounds(69, 277, 147, 142);
		contentPane.add(lblPhone1);
		BufferedImage imgPhone1 = null;
		try {
			imgPhone1 = ImageIO.read(new File("img/phone1.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Image resizedImgPhone1 = imgPhone1.getScaledInstance(lblPhone1.getWidth(), lblPhone1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon phone1Icon = new ImageIcon(resizedImgPhone1);
		lblPhone1.setIcon(phone1Icon);
		lblPhone1.addMouseListener(new MouseListener() {
			
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
				Phone phone = (Phone)productFactory.getProduct("PHONE");
				phone.setBrand("Iphone");
				TechnologyProductDetailsPage productDetailsPage = new TechnologyProductDetailsPage(username,phone,phone1Icon);
				setVisible(false);
				productDetailsPage.setVisible(true);
			}
		});
		
		JLabel lblPhone2 = new JLabel("");
		lblPhone2.setBounds(345, 277, 147, 142);
		contentPane.add(lblPhone2);
		BufferedImage imgPhone2 = null;
		try {
			imgPhone2 = ImageIO.read(new File("img/phone2.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Image resizedImgPhone2 = imgPhone2.getScaledInstance(lblPhone2.getWidth(), lblPhone2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon phone2Icon = new ImageIcon(resizedImgPhone2);
		lblPhone2.setIcon(phone2Icon);
		
		JLabel lblPhone3 = new JLabel("");
		lblPhone3.setBounds(635, 277, 147, 142);
		contentPane.add(lblPhone3);
		BufferedImage imgPhone3 = null;
		try {
			imgPhone3 = ImageIO.read(new File("img/phone3.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Image resizedImgPhone3 = imgPhone3.getScaledInstance(lblPhone3.getWidth(), lblPhone3.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon phone3Icon = new ImageIcon(resizedImgPhone3);
		lblPhone3.setIcon(phone3Icon);
	
	}
}
