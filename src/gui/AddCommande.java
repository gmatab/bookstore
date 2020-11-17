package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DaoBook;
import dao.DaoCommande;
import entities.Book;
import entities.Commande;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AddCommande extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public int BookID;
	public Double price;
	public String title;
	private JTextField idc;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCommande frame = new AddCommande(0,0.0,"");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public AddCommande(int a,Double b,String c) {
		this.BookID=a;
		this.price=b;
		this.title=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(41, 55, 45, 13);
		panel.add(lblNewLabel);
		JLabel message = new JLabel("");
		message.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		message.setForeground(new Color(51, 204, 153));
		message.setBounds(149, 366, 302, 25);
		panel.add(message);
		textField = new JTextField();
		textField.setBounds(111, 52, 139, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("prenom:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(41, 104, 59, 13);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 101, 139, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("email:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(41, 160, 45, 13);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 157, 139, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("adresse:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(41, 262, 59, 13);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(111, 208, 139, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("tel:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(41, 211, 45, 13);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(111, 259, 139, 19);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		
		JButton btnNewButton = new JButton("add commande");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaoCommande dao = new DaoCommande();
				Date date=Date.valueOf("2222-11-11");  

				Commande b =new Commande(Integer.parseInt(id.getText()),date,price,BookID,Integer.parseInt(idc.getText()));
				
				dao.addCommande(b);
				message.setText("Book added succecfully !");
				
				
			}
		});
		btnNewButton.setBounds(315, 342, 103, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(188, 342, 85, 21);
		panel.add(btnNewButton_1);
		
		JLabel bookid = new JLabel("");
		bookid.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		bookid.setBounds(399, 86, 139, 13);
		String t="";
		System.out.println(BookID);
		t="Book id: "+this.BookID;
		bookid.setText(t);
		panel.add(bookid);
		JLabel titlel = new JLabel("");
		titlel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		titlel.setBounds(399, 110, 161, 14);
		titlel.setText("Book's title : "+this.title);
		panel.add(titlel);
		
		JLabel pricel = new JLabel("");
		pricel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		pricel.setBounds(399, 135, 161, 25);
		pricel.setText("price : "+this.price);
		panel.add(pricel);
		
		JLabel lblNewLabel_6 = new JLabel("IdClient:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(41, 301, 59, 13);
		panel.add(lblNewLabel_6);
		
		idc = new JTextField();
		idc.setBounds(111, 298, 139, 19);
		panel.add(idc);
		idc.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("id commande");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(399, 262, 117, 13);
		panel.add(lblNewLabel_7);
		
		id = new JTextField();
		id.setBounds(399, 298, 139, 19);
		panel.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Information client :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_8.setBounds(28, 11, 153, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(AddCommande.class.getResource("/gui/iconb.png")));
		lblNewLabel_9.setBounds(397, 187, 64, 64);
		panel.add(lblNewLabel_9);
		
		
		
	
		
	}
}
