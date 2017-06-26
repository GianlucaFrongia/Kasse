package ch.gibm.gfjw.dto;

public class TeamPrice extends ProductImpl{
	
	private double resale;

	public TeamPrice(String name, int id, double resale, double price) {
		super(name, id, resale, price);
		this.resale = (super.getResale() * 0.6);
	}
	
	@Override
	public double getResale() {
		return resale;
	}

	@Override
	public void setResale(double resale) {
		this.resale = resale;
	}
}
