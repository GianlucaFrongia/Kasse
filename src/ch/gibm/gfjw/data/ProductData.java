package ch.gibm.gfjw.data;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import ch.gibm.gfjw.dto.Product;
import ch.gibm.gfjw.dto.ProductImpl;

/**
 * ProductData Klasse
 * Sucht, Löscht und schreibt Produkte in die JSON Datei
 * 
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */

public class ProductData implements ProductDao {
	/**
	 * Produkte werden in productList geaddet
	 */
	ArrayList<Product> productList = new ArrayList<Product>();
	
	/**
	 * Gson Objekt erstellen mit
	 * setPrettyPrinting() für Lesbaren JSON
	 * */
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	/**List die Json datei aus und Wandelt die JSON Produkt in Produkte Objekte
	 * @return productList
	 * */
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

	/**
	 * Löscht ein Produkt.
	 * Reihenfolge -> JSON lesen und in die ArrayList füllen -> Mit stream wird dann das Produkt mit der Passenden ID guscht und gelöscht
	 * -> Anschliessend wird die JSON Datei geupdatet
	 *@param int id 
	 */
	public void deleteProduct(int id) {
		getProductList();
		Optional<Product> matchingProduct = productList.stream().filter(p -> p.getId() == id).findFirst();
		Product p = matchingProduct.get();
		productList.remove(p);

		try (Writer writer = new FileWriter("products.json")) {
			writer.write(gson.toJson(productList));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * getProductList Aufruf für die aktuellen Produkte
	 * Anschliessend wir das Produkt in die ArrayList geaddet
	 * @param Product
	 * */

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
