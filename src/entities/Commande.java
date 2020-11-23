package entities;

import java.sql.Date;
import java.util.ArrayList;

public class Commande {
	private int id;
	private Date date_commande;	
	private Double prix;
	private ArrayList <Book> lb;
	private int idClient;
	private int idBook ;

	


		public Commande(int id, Date date_commande, Double prix,int idClient, int idBook) {
		this.id = id;
		this.date_commande = date_commande;
		this.prix = prix;
		this.idClient = idClient;
		this.idBook = idBook;
	}
		public Commande( Date date_commande, Double prix,int idClient, int idBook) {
			this.date_commande = date_commande;
			this.prix = prix;
			this.idClient = idClient;
			this.idBook = idBook;
		}
		public int getIdBook() {
		return idBook;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_commande() {
		return date_commande;
	}
	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
 
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
 	@Override
public String toString() {
	return "Commande [id=" + id + ", date_commande=" + date_commande + ", prix=" + prix 
			+ ", idClient=" + idClient + ", idBook=" + idBook + "]";
}
	

}
