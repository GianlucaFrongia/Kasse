/**
 * Teamprodukt berechnet immer 6O prozent auf den resale attribut.
 * 
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */
package ch.gibm.gfjw.dto;

public class TeamPrice extends ProductImpl{
	
	private double resale;

	public TeamPrice(String name, int id, double resale, double price) {
		super(name, id, resale, price);
		this.resale = resale;
	}
	
	@Override
	public double getResale() {
		return super.getPrice();
	}

	@Override
	public void setResale(double resale) {
		this.resale = resale;
	}
}
