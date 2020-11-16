package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import dao.DaoBook;
import entities.Book;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	 * @throws ClassNotFoundException 
	 */
	public Grid() throws SQLException, ClassNotFoundException {

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
		
		JLabel lblNewLabel_1 = new JLabel("List of Books");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 7, 387, 23);
		contentPane.add(lblNewLabel_1);
		
		
       

   

	}
	public void affgrid () throws SQLException, ClassNotFoundException {
		
		
		DaoBook dao= new DaoBook();
		List <Book> books =new ArrayList<>(); 
		books=dao.listBook();
		int j=books.size();
		Object[][] data = new Object[j][6];
		int i=0;
		ImageIcon icon =new ImageIcon("C:\\Users\\Amen\\eclipse-workspace\\bookstore\\src\\gui\\book.gif");
		for(Book bo : books)
	    {
			System.out.println(bo.getId());

			data [i][0]=bo.getId();
			data [i][1]=bo.getTitle();
			data [i][2]=bo.getAuthor();
			data [i][3] =bo.getPrice();
			data [i][4] =bo.getReleaseDate();
			data [i][5] =new ImageIcon(bo.getCover()) ;
			i++;
	    }
        String[] columns = new String[] {
                "Id", "Title", "Author", "Price", "ReleaseDate","cover"
            };
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table_1 = new JTable(model) {
        	public Class getColumnClass(int column) {
                return (column == 5) ? Icon.class : Object.class;
              }
		    @Override
		    public boolean isCellEditable(int row, int column) {                
		    	if(column == 0) return false;//the 4th column is not editable
		        return true;
		    };
		};

		
		  table_1.setRowHeight(icon.getIconHeight());
		    TableColumnModel columnModel = table_1.getColumnModel();
		   columnModel.getColumn(5).setPreferredWidth( icon.getIconWidth());
		
        table_1.setFont(new Font("Tahoma", Font.ITALIC, 12));;
		table_1.setAutoCreateColumnsFromModel(true);

	}
}
