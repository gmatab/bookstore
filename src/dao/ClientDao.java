package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import entities.Book;
import entities.Client;

public class ClientDao {
	public void addClient(Client client) {
		java.sql.Connection conn=null;
		String query;
		PreparedStatement st = null ;
		ResultSet res = null ;
		Book b;
		try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","");
		query = "INSERT INTO book (nom,prenom,email,tel,adress) VALUES (?,?,?,?,?)";
		st = conn.prepareStatement(query);
 		st.setString(1,client.getNom());
		st.setString(2,client.getPrenom());
		st.setString(3,client.getEmail());
		st.setString(4,client.getTel());
		st.setString(5,client.getAdresse());
		st.execute();
		} catch (SQLException ex) { 
			System.out .println("An error occurred while connecting MySQL databse");
			ex.printStackTrace(); }


		
	}
}
