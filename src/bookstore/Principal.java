package bookstore;

import java.util.Scanner;

public class Principal {
public static void main (String args[])
	{
	System.out.println("donne la quantite totale");
    Scanner myObj = new Scanner(System.in);
	int qte = myObj.nextInt();
	System.out.println("donne le prix unitaire");
	 double prixU= myObj.nextDouble();
	 Utility u = new Utility();
	 double tot= u.CalculateTotalPrice(qte,prixU);
	System.out.println("le prix totale est : "+tot);

	}
}
