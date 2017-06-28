/**
 * Interface für ein Productobejekt.
 * 
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */
package ch.gibm.gfjw.dto;

public interface Product {
	
	public String getName();
	public void setName(String name);
	public int getId();
	public void setId(int id);
	public double getResale();
	public void setResale(double resale);
	public double getPrice();
	public void setPrice(double price);
}
