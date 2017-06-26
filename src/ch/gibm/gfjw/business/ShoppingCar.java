/**
 * ShoppingCar Klasse
 * 
 * 
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */
package ch.gibm.gfjw.business;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

import ch.gibm.gfjw.data.ProductFactory;
import ch.gibm.gfjw.data.ProductLogDAO;
import ch.gibm.gfjw.dto.Product;
import ch.gibm.gfjw.dto.ProductImpl;

public class ShoppingCar {
	
	/**
	 * Neuer Arraylist für alle eingekauften Produkte.
	 */
	private ArrayList<Product> shoppingCar = new ArrayList<>();
	
	/**
	 * Gibt ein Produkt nach ID aus.
	 * @param id des gewünschten Produktes.
	 * @return Ein Product Objekt des gewuenschten Produktes.
	 */
	public Product getProduct(int id){
		return shoppingCar.get(id);
	}
	
	/**
	 * Gibt alle Product Objekte in dem ShoppingCar-ArrayList aus.
	 * @return ArrayList aller Objekte.
	 */
	public ArrayList<Product> getShoppingCar() {
		return shoppingCar;
	}

	/**
	 * Loescht ein Produkt Objekt aus dem ShoppingCar.
	 * @param id ID des gewuenschten Coint Objekt.
	 */
	public void deleteProduct(int id){
		shoppingCar.remove(id);
	}
	
	/**
	  * Berechnet das Total.
	  * @return Total
	  */
	public Double getTotal(){
		double total = 0;
		for (Product product : shoppingCar) {
			total += product.getResale();
		}
		return total;
	}
	
	/**
	 * Fuegt ein Produkt hinzu.
	 * @param product Produkt das hinzugefuegt werden soll.
	 */
	public void addProduct(Product product){
		shoppingCar.add(product);
	}
	
	/**
	 * Schreibt die Liste in ein Dokument.
	 */
	public void  writeShoppingCar(){
		ProductLogDAO log = ProductFactory.getInstance().createProdctLogDAO();
		ArrayList<Product> productList = new ArrayList<Product>();
		for (Product product : getShoppingCar()){
			if (product.getClass().getName().equals("ch.gibm.gfjw.dto.TeamPrice")){
				productList.add(new ProductImpl(product.getName(), product.getId(), product.getResale(), product.getPrice()));
			} else {
				productList.add(product);
			}
		}
		log.logProducts(productList);
	}
}
