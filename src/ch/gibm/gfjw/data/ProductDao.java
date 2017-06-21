package ch.gibm.gfjw.data;

import ch.gibm.gfjw.dto.Product;

import java.util.List;

/**
 * Created by gianluca on 07.06.17.
 */
public interface ProductDao {
	
    public List<Product> getProductList();
    public void deleteProduct(int id);
    public void addProduct(Product product);

}