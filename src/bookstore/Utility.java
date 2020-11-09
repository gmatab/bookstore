package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility {
	double CalculateTotalPrice(int qte, double prixU)
	{
				return qte*prixU;
	}
	public static void main (String args[]) throws ClassNotFoundException, SQLException {
		/*System.out.println("donne la quantite totale");
	    Scanner myObj = new Scanner(System.in);
		int qte = myObj.nextInt();
		System.out.println("donne le prix unitaire");
		double prixU= myObj.nextDouble();
		Utility u = new Utility();
		double tot= u.CalculateTotalPrice(qte,prixU);
		System.out.println("le prix totale est : "+tot);*/
	 	Connection conn=null;

		conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","");
		System.out.print(conn);

		//DaoBook da=new DaoBook();
		//da.listBook();
		}
}
