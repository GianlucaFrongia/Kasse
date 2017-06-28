package ch.gibm.gfjw.dto;

import javax.swing.ImageIcon;

/**
 * Coint Objekt.
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */

public class Coint {

	private ImageIcon image;
	private double value;
	private String name;
	
	public Coint(String imageURL, double value, String name) {
		super();
		this.image = new ImageIcon(imageURL);
		this.value = value;
		this.name = name;
	}
	
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(String imageURL) {
		this.image = new ImageIcon(imageURL);
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
