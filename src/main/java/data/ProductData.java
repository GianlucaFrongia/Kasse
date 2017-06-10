package data;

import ch.gibm.gfjw.dao.Product;
import ch.gibm.gfjw.dao.ProductImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gianluca on 06.06.17
 */

public class ProductData implements ProductDao{
    public static void main(String[] args){
                ProductData dumpp = new ProductData();

            Product product1 = new ProductImpl("Fanta", 2,2.5,3.5);
        Product product2 = new ProductImpl("Pepsi", 2,2.5,3.5);
        Product product3 = new ProductImpl("Cola", 2,2.5,3.5);

        dumpp.addProduct(product1);
        dumpp.addProduct(product2);
        dumpp.addProduct(product3);

    }

    public List<Product> getProductList() {


        try (Reader reader = new FileReader("products.json")) {
            Type type = new TypeToken<List<Product>>(){}.getType();

            List<Product> productList = new Gson().fromJson(reader, type);

            return productList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



    public int deleteProduct(int id) {
        return id;
    }

    public void addProduct(Product product) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Product> productList = new ArrayList<Product>();

        try (Writer writer = new FileWriter("products.json", true)) {

            productList.add(product);


            gson.toJson(productList, writer);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


