package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.DaoBook;
import entities.Book;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Grid extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grid frame = new Grid();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Grid() throws SQLException {

				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 450, 210);
		contentPane.add(scrollPane);
		affgrid();
		

		scrollPane.setViewportView(table_1);
		
		btnNewButton = new JButton("delete selected");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)   {
						int row = table_1.getSelectedRow();
						int id = (int)table_1.getModel().getValueAt(row, 0);
						DaoBook dao = new DaoBook();
						dao.deleteBook(id);
						
						DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
						tableModel.removeRow(row);
						lblNewLabel.setText("Successfully deleted");

					 

			}
		});
		btnNewButton.setBounds(67, 251, 153, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Update Selcted");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table_1.getSelectedRow();
				String title = table_1.getModel().getValueAt(row, 1).toString();
				String author = table_1.getModel().getValueAt(row, 2).toString();
				String date1 = table_1.getModel().getValueAt(row, 4).toString();
				int id = (int)table_1.getModel().getValueAt(row, 0);
				double price = (double)table_1.getModel().getValueAt(row, 3);
				DaoBook dao = new DaoBook();
				Date date=Date.valueOf(date1);  
				Book b =new Book(id,title,author,price,date);
				dao.updateBook(b);
				lblNewLabel.setText("Successfully updated");
			}
		});
		btnNewButton_1.setBounds(264, 251, 153, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setForeground(new Color(60, 179, 113));
		lblNewLabel.setBounds(120, 279, 277, 14);
		contentPane.add(lblNewLabel);
		
		
       

   

	}
	public void affgrid () throws SQLException {
		
		java.sql.Connection conn=null;
		String query;
		PreparedStatement st,st1 = null ;
		ResultSet res,res1 = null ;
		Book b;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","");
		System.out.print("xxxx");
		query = "select * from book";
		st = conn.prepareStatement(query);
		st1 = conn.prepareStatement(query);
		res=st.executeQuery();
		res1=st1.executeQuery();
		int j=0;
		while(res1.next()) {j++;}
		Object[][] data = new Object[j][5];
		int i=0;
		while(res.next()) {
			System.out.println(res.getInt("id")+res.getString("title")+res.getString("author")+res.getDouble("price")+res.getDate("releaseDate"));
			data [i][0]=res.getInt("id");
			data [i][1]=res.getString("title");
			data [i][2]=res.getString("author");
			data [i][3] =res.getDouble("price");
			data [i][4] =res.getDate("releaseDate");
			i++;
		}
        String[] columns = new String[] {
                "Id", "Title", "Author", "Price", "ReleaseDate"
            };
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table_1 = new JTable(model) {
		    @Override
		    public boolean isCellEditable(int row, int column) {                
		    	if(column == 0) return false;//the 4th column is not editable
		        return true;
		    };
		};
        table_1.setFont(new Font("Tahoma", Font.ITALIC, 12));;
		table_1.setAutoCreateColumnsFromModel(true);

	}

		
		
	
}
