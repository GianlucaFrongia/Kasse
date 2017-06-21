package ch.gibm.gfjw.data;

import java.util.ArrayList;

import ch.gibm.gfjw.dto.Product;
/**
 * ProductLogDAO Klasse
 * Sucht, Löscht und schreibt Produkte in die JSON Datei
 * 
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */
public interface ProductLogDAO{
	
	public void logProducts(ArrayList<Product> shoppingCar);
    public ArrayList<Product> getList(String date);
}
