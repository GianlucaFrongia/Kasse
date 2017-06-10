package main.java.data;

import ch.gibm.gfjw.dto.Product;

import java.util.List;

/**
 * Created by gianluca on 07.06.17.
 */
public interface ProductDao {
    public List<Product> getProductList();

    public int deleteProduct(int id);
    public void addProduct(Product product);

}
