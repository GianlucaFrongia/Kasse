package ch.gibm.gfjw.data;

import ch.gibm.gfjw.data.ProductDao;
import ch.gibm.gfjw.dto.Product;
import ch.gibm.gfjw.dto.ProductImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by gianluca on 06.06.17
 */

public class ProductData implements ProductDao {

	ArrayList<Product> productList = new ArrayList<Product>();
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public List<Product> getProductList() {

		try (Reader reader = new FileReader("products.json")) {
			Type type = new TypeToken<List<ProductImpl>>() {
			}.getType();

			productList = new Gson().fromJson(reader, type);

			return productList;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int deleteProduct(int id) {
		getProductList();
		Optional<Product> matchingProduct = productList.stream().filter(p -> p.getId() == id).findFirst();
		Product p = matchingProduct.get();
		productList.remove(p);

		try (Writer writer = new FileWriter("products.json")) {
			writer.write(gson.toJson(productList));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return id;
	}

	public void addProduct(Product product) {
		getProductList();

		productList.add(product);

		try (Writer writer = new FileWriter("products.json")) {
			writer.write(gson.toJson(productList));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
