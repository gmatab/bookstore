package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;
import java.sql.Date;
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
import javax.swing.DefaultListModel;
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

public class AddCommande extends JFrame {

	private JPanel contentPane;
	private JTextField adresse;
	private JTextField prenom;
	
	int xx,xy;
	public int BookID;
	public Double price;
	public String title;
	private JTextField nom;
	private JTextField email;
	private JTextField tel;

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
	public AddCommande(int a,Double b,String c) throws ClassNotFoundException, SQLException {
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
		panel.setBounds(0, 0, 346, 439);
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
	            AddCommande.this.setLocation(x - xx, y - xy);  
			}
		});
	
		
		JLabel lblWeGotYou = new JLabel(".... Vermeg-Sesame ....");
		lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeGotYou.setForeground(new Color(240, 248, 255));
		lblWeGotYou.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWeGotYou.setBounds(0, 409, 346, 27);
		panel.add(lblWeGotYou);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setToolTipText("");
		lblNewLabel_5.setIcon(new ImageIcon(Home.class.getResource("/gui/image.jpg")));
		lblNewLabel_5.setBounds(0, 0, 346, 219);
		panel.add(lblNewLabel_5);
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
		list.setBounds(50, 295, 247, 82);
		
		panel.add(list);
		DaoBook dbb=new DaoBook();
		List <Book> p=dbb.listBook();
		System.out.println(p);
		int i=0;
		for(Book ag:p) {
			 model.add(i, ag.getTitle());
			 i++;
			//list.addElement(ag.getTitle());
		}
		Button button = new Button("RESET");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prenom.setText("");
				nom.setText("");
				email.setText("");
				tel.setText("");
				//dateChooser.setDate(null);
				adresse.setText("");

			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(383, 388, 143, 41);
		contentPane.add(button);
		
		
		
		adresse = new JTextField();
		adresse.setBounds(393, 324, 283, 27);
		contentPane.add(adresse);
		adresse.setColumns(10);
		
		
		
		JLabel lblEmail = new JLabel("Prenom");
		lblEmail.setBounds(393, 38, 54, 14);
		contentPane.add(lblEmail);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(395, 62, 283, 27);
		contentPane.add(prenom);
		
		JLabel lblPassword = new JLabel("Nom");
		lblPassword.setBounds(395, 108, 96, 14);
		contentPane.add(lblPassword);
		
		JLabel lblRepeatPassword = new JLabel("email");
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
		
		JLabel lblReleaseDateaaaammjj = new JLabel("tel");
		lblReleaseDateaaaammjj.setBounds(392, 240, 190, 14);
		contentPane.add(lblReleaseDateaaaammjj);
		
		
		
		Button button_1 = new Button("Add commande");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int er=0;
				DaoCommande dao = new DaoCommande();
				int index = list.getSelectedIndex();
				int[] items = list.getSelectedIndices();
				System.out.println(items);
				//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				  // LocalDateTime now = LocalDateTime.now();  
				//Date date=Date.valueOf("2222-11-11");  
				//for(Book ag:p) {
					//if(ag.getTitle()==)
					//{
						// er=ag.getId();
						//break;
					//}
				//}
				//java.util.Date date= java.util.Calendar.getInstance().getTime();
				
				//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				//java.util.Date date = new java.util.Date();
				//Calendar calendar = Calendar.getInstance();
				//java.util.Date currentTime = calendar.getTime(); 
				//Long time = currentTime.getTime();
				Date date=Date.valueOf("2222-11-11"); 
				for(int i=0;i<items.length;i++){
				
					
				Book bkk=p.get(items[i]); 
				er=bkk.getId();
				System.out.println(er);
				Commande b =new Commande(date,price,er,2);
				//Client cl= new Client();
				dao.addCommande(b);
				}
				
				//message.setText("Book added succecfully !");
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(34, 139, 34));
		button_1.setBounds(535, 388, 143, 41);
		contentPane.add(button_1);
		
		JLabel lblNewLabel_6 = new JLabel("adresse");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(395, 301, 114, 13);
		contentPane.add(lblNewLabel_6);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(393, 142, 283, 27);
		contentPane.add(nom);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(395, 203, 283, 27);
		contentPane.add(email);
		
		tel = new JTextField();
		tel.setColumns(10);
		tel.setBounds(393, 264, 283, 27);
		contentPane.add(tel);
	}
}
