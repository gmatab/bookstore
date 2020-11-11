package dao;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import entities.Book;

public class DaoBook {


	List <Book> books =new ArrayList<>(); ;
	public void addBook(Book book) {
		java.sql.Connection conn=null;
		String query;
		PreparedStatement st = null ;
		ResultSet res = null ;
		Book b;
		try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","");
		query = "INSERT INTO book (id,title,author,price,releaseDate,cover) VALUES (?,?,?,?,?,?)";
		st = conn.prepareStatement(query);
		st.setInt(1,book.getId());
		st.setString(2,book.getTitle());
		st.setString(3,book.getAuthor());
		st.setDouble(4,book.getPrice());
		st.setDate(5,book.getReleaseDate());
		st.setString(6,book.getCover());
		st.execute();
		} catch (SQLException ex) { 
			System.out .println("An error occurred while connecting MySQL databse");
			ex.printStackTrace(); }


		
	}
	public void updateBook(Book book) {
		java.sql.Connection conn=null;
		String query;
		PreparedStatement st = null ;
		ResultSet res = null ;
		Book b;
		try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","");
	     query = "update book set title = ?,author = ? , price = ? , releaseDate = ? where  id = ?";
		st = conn.prepareStatement(query);
		st.setString(1,book.getTitle());
		st.setString(2,book.getAuthor());
		st.setDouble(3,book.getPrice());
		st.setDate(4,book.getReleaseDate());
		st.setInt(5,book.getId());

		st.execute();
		} catch (SQLException ex) { 
			System.out .println("An error occurred while connecting MySQL databse");
			ex.printStackTrace(); }


		
	}
	public void deleteBook(int id) {
		java.sql.Connection conn=null;
		String query;
		PreparedStatement st = null ;
		ResultSet res = null ;
		Book b;
		try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","");
	     query = "delete from book where  id = ?";
		st = conn.prepareStatement(query);
		st.setInt(1,id);

		st.execute();
		} catch (SQLException ex) { 
			System.out .println("An error occurred while connecting MySQL databse");
			ex.printStackTrace(); }


		
	}
	
	public List <Book> listBook() throws ClassNotFoundException, SQLException {
		java.sql.Connection conn=null;
		String query;
		PreparedStatement st = null ;
		ResultSet res = null ;
		Book b;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","");

		query = "select * from book";
		st = conn.prepareStatement(query);
		res=st.executeQuery();
		while(res.next()) {

			b=new Book(res.getInt("id"),res.getString("title"),res.getString("author"),res.getDouble("price"),res.getDate("releaseDate"),res.getString("cover"));
			books.add(b);
		}
		return books;
			
	}

}
