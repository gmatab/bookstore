package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
//import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.toedter.calendar.JDateChooser;

import dao.DaoBook;
import dao.DaoCommande;
import entities.Book;
import entities.Commande;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class Home extends JFrame {

	private JPanel contentPane;
	
	int xx,xy;
	public int BookID;
	public Double price;
	public String title;
	private JTable table2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(0,0.0,"");
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Home(int a,Double b,String c) throws ClassNotFoundException, SQLException {
		this.BookID=a;
		this.price=b;
		this.title=c;
		
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
		panel.setBounds(0, 0, 261, 439);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Project : Build a Bookstore");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(-17, 229, 276, 27);
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
		lblWeGotYou.setBounds(-46, 412, 346, 27);
		panel.add(lblWeGotYou);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setToolTipText("");
		lblNewLabel_5.setIcon(new ImageIcon(Home.class.getResource("/gui/image.jpg")));
		lblNewLabel_5.setBounds(0, 0, 259, 219);
		panel.add(lblNewLabel_5);
		DefaultListModel model = new DefaultListModel();
		DaoBook dbb=new DaoBook();
		List <Book> p=dbb.listBook();
		System.out.println(p);
		int i=0;
		for(Book ag:p) {
			 model.add(i, ag.getTitle());
			 i++;
			//list.addElement(ag.getTitle());
		}
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 64, 396, 375);
		affgrid();
		contentPane.add(scrollPane);
		
		//table = new JTable();
		scrollPane.setViewportView(table2);
		
		JLabel lblNewLabel_1 = new JLabel("List of commandes");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(412, 28, 135, 13);
		contentPane.add(lblNewLabel_1);
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
        table2 = new JTable(model) {
         
		    @Override
		    public boolean isCellEditable(int row, int column) {                
		    	if(column == 0) return false;//the 4th column is not editable
		        return true;
		    };
		};

		
		 
        table2.setFont(new Font("Tahoma", Font.ITALIC, 12));;
		table2.setAutoCreateColumnsFromModel(true);

	}
}
