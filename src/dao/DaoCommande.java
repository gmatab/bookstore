package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Book;
import entities.Commande;

public class DaoCommande {
	List <Commande> commands =new ArrayList<>(); ;
	public void addCommande (Commande comande) {
		java.sql.Connection conn=null;
		String query;
		PreparedStatement st = null ;
		ResultSet res = null ;
		Book b;
		try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","");
		query = "INSERT INTO commande (id,datecommande,prix,idbook,idclient) VALUES (?,?,?,?,?)";
		st = conn.prepareStatement(query);
		st.setInt(1,comande.getId());
		st.setDate(2,comande.getDate_commande());
		st.setDouble(3,comande.getPrix());
		st.setInt(4,comande.getIdBook());
		st.setInt(5,comande.getIdClient());
		st.execute();
		} catch (SQLException ex) { 
			System.out .println("An error occurred while connecting MySQL databse");
			ex.printStackTrace(); }

	}
	public List <Commande> listCommande() throws ClassNotFoundException, SQLException {
		java.sql.Connection conn=null;
		String query;
		PreparedStatement st = null ;
		ResultSet res = null ;
		Commande cm;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","");

		query = "select * from commande";
		st = conn.prepareStatement(query);
		res=st.executeQuery();
		while(res.next()) {

			cm=new Commande(res.getInt("id"),res.getDate("datecommande"),res.getDouble("prix"),res.getInt("idclient"),res.getInt("idbook"));
			commands.add(cm);
			System.out.println(cm);

		}
		return commands;
			
	}
}
