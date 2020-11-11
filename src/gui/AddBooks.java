package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DaoBook;
import entities.Book;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Window;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddBooks extends JFrame {

	private JPanel contentPane;
	private JTextField Title;
	private JTextField Author;
	private JTextField Price;
	private JTextField RelDate;
	private JTextField Id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooks frame = new AddBooks();
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
	public AddBooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(35, 77, 46, 14);
		contentPane.add(lblNewLabel);
		
		Title = new JTextField();
		Title.setBounds(229, 75, 122, 20);
		contentPane.add(Title);
		Title.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Author");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(35, 114, 58, 14);
		contentPane.add(lblNewLabel_1);
		
		Author = new JTextField();
		Author.setBounds(229, 112, 122, 20);
		contentPane.add(Author);
		Author.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(35, 156, 46, 14);
		contentPane.add(lblNewLabel_2);
		JLabel message = new JLabel("");
		message.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		message.setForeground(new Color(60, 179, 113));
		message.setBounds(118, 271, 200, 14);
		contentPane.add(message);
		
		Price = new JTextField();
		Price.setBounds(229, 154, 122, 20);
		contentPane.add(Price);
		Price.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Release Date(AAAA-MM-JJ)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(35, 199, 184, 14);
		contentPane.add(lblNewLabel_3);
		
		RelDate = new JTextField();
		RelDate.setBounds(229, 196, 122, 20);
		contentPane.add(RelDate);
		RelDate.setColumns(10);
		
		JButton btnAdd = new JButton("Add Book");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DaoBook dao = new DaoBook();
				Date date=Date.valueOf(RelDate.getText());  

				Book b =new Book(Integer.parseInt(Id.getText()),Title.getText(),Author.getText(),
						Double.parseDouble(Price.getText()),date);
				dao.addBook(b);
				message.setText("Book added succecfully !");
				Id.setText("");
				Title.setText("");
				Author.setText("");
				Price.setText("");
				RelDate.setText("");
                /*Grid gr;
				try {
					gr = new Grid();
	                gr.setVisible(true);
 
 


				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/


			}
		});

		btnAdd.setBounds(229, 239, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Id.setText("");
				Title.setText("");
				Author.setText("");
				Price.setText("");
				RelDate.setText("");
			}
		});
		btnReset.setBounds(118, 239, 89, 23);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_4 = new JLabel("ADD NEW BOOK");
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setBounds(158, 11, 161, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Id");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setBounds(35, 38, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		Id = new JTextField();
		Id.setBounds(229, 36, 122, 20);
		contentPane.add(Id);
		Id.setColumns(10);
		
		
	}
}
