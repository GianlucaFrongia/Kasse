/**
 * Schnittstelle zur Data Schicht.
 */
package ch.gibm.gfjw.business;

import java.util.List;

import ch.gibm.gfjw.data.ProductDao;
import ch.gibm.gfjw.data.ProductFactory;
import ch.gibm.gfjw.dto.Product;

public class ProductLogic {
	
	/**
	 * Objekt von ProductData.
	 */
	private ProductDao productDao = ProductFactory.getInstance().createProductDao();
	
	/**
	 * Ruf die Methode addProduct auf den productDao objekt auf. Und fuegt ein Produkt hinzu.
	 * @param product Produkt welches hinzugefügt werden sollte.
	 */
	public void addProduct(Product product){
		productDao.addProduct(product);
	}
	
	/**
	 * Gibt die gesamte Produktlist zurueck.
	 * @return List aller Produkte
	 */
	public List<Product> getList(){
		return productDao.getProductList();
	}
	
	/**
	 * Löscht das gewuenschte Produkt aus der List.
	 * @param id Produkt welches geloescht werden soll
	 */
	public void deleteProduct(int id){
		productDao.deleteProduct(id);
	}

}
