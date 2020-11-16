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
		lblNewLabel.setBounds(156, 54, 45, 13);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(244, 52, 139, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("prenom:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(156, 103, 59, 13);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(244, 101, 139, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("email:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(156, 159, 45, 13);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(244, 157, 139, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("adresse:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(156, 264, 59, 13);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(244, 208, 139, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("tel:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(156, 210, 45, 13);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(244, 262, 139, 19);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("add commande");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaoCommande dao = new DaoCommande();
				Date date=Date.valueOf("2222-11-11");  

				Commande b =new Commande(Integer.parseInt(id.getText()),date,price,BookID,Integer.parseInt(idc.getText()));
				
				dao.addCommande(b);
				//message.setText("Book added succecfully !");
				
				
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
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(494, 86, 74, 13);
		String t="";
		System.out.println(BookID);
		t="with ID  "+this.BookID;
		lblNewLabel_5.setText(t);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("IdClient:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(156, 303, 59, 13);
		panel.add(lblNewLabel_6);
		
		idc = new JTextField();
		idc.setBounds(244, 301, 139, 19);
		panel.add(idc);
		idc.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("id commande");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(156, 23, 117, 13);
		panel.add(lblNewLabel_7);
		
		id = new JTextField();
		id.setBounds(244, 21, 139, 19);
		panel.add(id);
		id.setColumns(10);
		
	}
}
