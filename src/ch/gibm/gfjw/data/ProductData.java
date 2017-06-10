package ch.gibm.gfjw.data;

import ch.gibm.gfjw.data.ProductDao;
import ch.gibm.gfjw.dto.Product;
import ch.gibm.gfjw.dto.ProductImpl;
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
        productList.add(product);

        try (Writer writer = new FileWriter("products.json", true)) {
            writer.write(gson.toJson(productList));
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


