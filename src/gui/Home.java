package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	// going to borrow code from a gist to move frame.
	

	/**
	 * Create the frame.
	 */
	public Home() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Project : Build a Bookstore");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(0, 229, 346, 27);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            Home.this.setLocation(x - xx, y - xy);  
			}
		});
	
		
		JLabel lblWeGotYou = new JLabel(".... Vermeg-Sesame ....");
		lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeGotYou.setForeground(new Color(240, 248, 255));
		lblWeGotYou.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWeGotYou.setBounds(0, 409, 346, 27);
		panel.add(lblWeGotYou);
		
		JLabel lblNewLabel_1 = new JLabel("realized by :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(0, 267, 346, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Amen Allah Tbini - Ghrissi Mohamed - Ben Alaya Ahmed");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 290, 346, 33);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Framed by :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 331, 346, 33);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mohamed Amine Mezghich");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(0, 364, 346, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setToolTipText("");
		lblNewLabel_5.setIcon(new ImageIcon(Home.class.getResource("/gui/image.jpg")));
		lblNewLabel_5.setBounds(0, 0, 346, 219);
		panel.add(lblNewLabel_5);
		
		Button button = new Button("RESET");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(395, 410, 143, 27);
		contentPane.add(button);
		
		
		
		textField = new JTextField();
		textField.setBounds(395, 38, 283, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("ID");
		lblUsername.setBounds(395, 13, 114, 14);
		contentPane.add(lblUsername);
		
		
		
		JLabel lblEmail = new JLabel("TITLE");
		lblEmail.setBounds(395, 76, 54, 14);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(395, 101, 283, 27);
		contentPane.add(textField_1);
		
		JLabel lblPassword = new JLabel("AUTHOR");
		lblPassword.setBounds(395, 139, 96, 14);
		contentPane.add(lblPassword);
		
		JLabel lblRepeatPassword = new JLabel("PRICE");
		lblRepeatPassword.setBounds(395, 202, 133, 14);
		contentPane.add(lblRepeatPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(395, 164, 283, 27);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(395, 227, 283, 27);
		contentPane.add(passwordField_1);
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(241, 57, 83));
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_close.setBounds(691, 0, 37, 27);
		contentPane.add(lbl_close);
		
		JLabel lblReleaseDateaaaammjj = new JLabel("RELEASE DATE (AAAA-MM-JJ)");
		lblReleaseDateaaaammjj.setBounds(395, 265, 190, 14);
		contentPane.add(lblReleaseDateaaaammjj);
	}
}
