package entities;

import java.sql.Date;

public class Book {
		
	private int id ;
	private String title ;
	private String author ;
	private double price ;
	private Date releaseDate ;
	private String cover;
	
	
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Book(int id, String title, String author, double price, Date releaseDate) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.releaseDate = releaseDate;
	}
	public Book(int id, String title, String author, double price, Date releaseDate,String cover) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.releaseDate = releaseDate;
		this.cover = cover;
	}
	public Book(String title, String author, double price, Date releaseDate,String cover) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.releaseDate = releaseDate;
		this.cover = cover;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", releaseDate="
				+ releaseDate + ", cover=" + cover + "]";
	}
	
	
}
