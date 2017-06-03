package ch.gibm.gfjw.dto;

public class Coint {

	private String image;
	private double value;
	private String name;
	
	public Coint(String image, double value, String name) {
		super();
		this.image = image;
		this.value = value;
		this.name = name;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
