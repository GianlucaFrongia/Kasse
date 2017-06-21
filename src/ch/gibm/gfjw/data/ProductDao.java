package ch.gibm.gfjw.data;

import ch.gibm.gfjw.dto.Product;

import java.util.List;

/**
 * ProductDao Klasse
 * Interface
 * 
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */
public interface ProductDao {
	
    public List<Product> getProductList();
    public void deleteProduct(int id);
    public void addProduct(Product product);

}