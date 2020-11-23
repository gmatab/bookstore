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
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;

import dao.DaoBook;
import entities.Book;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBooks extends JFrame {

	private JPanel contentPane;
	private JTextField file;
	private JTextField Title;
	
	int xx,xy;
	private JTextField Author;
	private JTextField price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooks frame = new AddBooks();
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
	public AddBooks() {
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
	            AddBooks.this.setLocation(x - xx, y - xy);  
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
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(395, 264, 283, 27);
		contentPane.add(dateChooser);
		Button button = new Button("RESET");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Title.setText("");
				Author.setText("");
				price.setText("");
				dateChooser.setDate(null);
				file.setText("");

			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(383, 388, 143, 41);
		contentPane.add(button);
		
		
		
		file = new JTextField();
		file.setBounds(393, 324, 283, 27);
		contentPane.add(file);
		file.setColumns(10);
		
		
		
		JLabel lblEmail = new JLabel("TITLE");
		lblEmail.setBounds(393, 38, 54, 14);
		contentPane.add(lblEmail);
		
		Title = new JTextField();
		Title.setColumns(10);
		Title.setBounds(395, 62, 283, 27);
		contentPane.add(Title);
		
		JLabel lblPassword = new JLabel("AUTHOR");
		lblPassword.setBounds(395, 108, 96, 14);
		contentPane.add(lblPassword);
		
		JLabel lblRepeatPassword = new JLabel("PRICE");
		lblRepeatPassword.setBounds(395, 179, 133, 14);
		contentPane.add(lblRepeatPassword);
		
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
		lblReleaseDateaaaammjj.setBounds(392, 240, 190, 14);
		contentPane.add(lblReleaseDateaaaammjj);
		
		
		
		Button button_1 = new Button("Add Book");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///
				DaoBook dao = new DaoBook();
				//Date date=Date.valueOf(RelDate.getText());  
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		        // sdf.format(dateChooser.getDate());
				Book b =new Book(Title.getText(),Author.getText(),
						Double.parseDouble(price.getText()),sdf.format(dateChooser.getDate()),file.getText());
				
				dao.addBook(b);
				//message.setText("Book added succecfully !");
				Title.setText("");
				Author.setText("");
				price.setText("");
				dateChooser.setDate(null);
				file.setText("");
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(34, 139, 34));
		button_1.setBounds(535, 388, 143, 41);
		contentPane.add(button_1);
		
		JLabel lblNewLabel_6 = new JLabel("file");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(395, 301, 114, 13);
		contentPane.add(lblNewLabel_6);
		
		Author = new JTextField();
		Author.setColumns(10);
		Author.setBounds(393, 142, 283, 27);
		contentPane.add(Author);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(395, 203, 283, 27);
		contentPane.add(price);
	}
}
