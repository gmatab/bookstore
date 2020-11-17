package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import dao.DaoBook;
import dao.DaoCommande;
import entities.Book;
import entities.Commande;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class GridCommande extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GridCommande frame = new GridCommande();
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
	public GridCommande() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 68, 550, 303);
		contentPane.add(scrollPane);
		affgrid ();

 		scrollPane.setViewportView(table_1);
 		
 		lblNewLabel = new JLabel("liste des commandes :");
 		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
 		lblNewLabel.setBounds(71, 30, 258, 21);
 		contentPane.add(lblNewLabel);
	}
	
public void affgrid () throws SQLException, ClassNotFoundException {
		
		
		DaoCommande dao= new DaoCommande();
		List <Commande> commands =new ArrayList<>(); 
		commands =dao.listCommande();
		int j=commands.size();
		Object[][] data = new Object[j][6];
		int i=0;
		ImageIcon icon =new ImageIcon("C:\\Users\\Amen\\eclipse-workspace\\bookstore\\src\\gui\\iconb.png");
		for(Commande bo : commands)
	    {
			System.out.println(bo.getId());

			data [i][0]=bo.getId();
			data [i][1]=bo.getDate_commande();
			data [i][2]=bo.getPrix();
			data [i][3] =bo.getIdClient();
			data [i][4] =bo.getIdBook();
 			i++;
	    }
        String[] columns = new String[] {
                "Id", "Date Commande", "prix", "id client", "id book"
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
