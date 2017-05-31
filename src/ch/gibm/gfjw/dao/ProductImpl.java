package ch.gibm.gfjw.dao;

public class ProductImpl implements Product{

	private String name;
	private int id;
	private double resale;
	private double price;
	
	public ProductImpl(String name, int id, double resale, double price) {
		super();
		this.name = name;
		this.id = id;
		this.resale = resale;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getResale() {
		return resale;
	}
	
	public void setResale(double resale) {
		this.resale = resale;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
