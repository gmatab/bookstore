package bookstore;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Scanner;
import java.sql.Date;


import dao.DaoBook;
import entities.Book;


public class Principale {
 
public static void main (String args[]) throws ClassNotFoundException, SQLException {
    boolean ex=false ;

 	Connection conn=null;

	conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","");
	Date d=new Date(1997-02-02);
	Book b ;
	DaoBook dao = new DaoBook();
	
	System.out.println("BIENVENUE DANS BOOKSTORE");
	while(!ex) {
		System.out.println("Menu : ");
		System.out.println("1- Ajoutez vous un book  ");
		System.out.println("2- Afficher tous les book  ");
		System.out.println("0- Afficher tous les book  ");

		System.out.println("donnez vous votre choix : ");
	    Scanner myObj = new Scanner(System.in);
		int qte = myObj.nextInt(),id;
		String author,title;
		double price;
		switch (qte)
			{
			case 0:ex=true;break;

			case 1:
				System.out.println("donne une ID");
				id= myObj.nextInt();
			    Scanner myObj2 = new Scanner(System.in);

				System.out.println("donne author");
				author=myObj2.nextLine();
				System.out.println("donne title");
			    Scanner myObj3 = new Scanner(System.in);

				title=myObj3.nextLine();	
				System.out.println("donne price");
			    Scanner myObj4 = new Scanner(System.in);

				price=myObj4.nextDouble();
				b =new Book(id,title,author,price,d);
				dao.addBook(b);
				
				break;
			case 2:

				List <Book> books =new ArrayList<>(); 
				books=dao.listBook();

			    for(Book bo : books)
			    {
			    	System.out.println(bo);

			    }
				break;
			default:
				break;		
			}

	}
	}
}
