package ch.gibm.gfjw.data;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import ch.gibm.gfjw.dto.Product;
import ch.gibm.gfjw.dto.ProductImpl;

/**
 * ProductLogData Klasse
 * Logt (schreibt) die gekauften Produkte
 * 
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */
public class ProductLogData implements ProductLogDAO {
	
	private Date date = new Date();
	private ArrayList<Product> productLog = new ArrayList<Product>();
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private DateFormat dateFormat = new SimpleDateFormat("MM.dd");
	private ArrayList<Product> combined = new ArrayList<Product>();

	/**Schreibt den Inhalt vom shoppingCar in die JSON-Logdatei
	 * @param ArrayList<Product> shoppingCar
	 * 
	 * **/
	@Override
	public void logProducts(ArrayList<Product> shoppingCar) {
		
		File f = new File("productLog-"+ dateFormat.format(date) +".json");
		if(!f.exists() && !f.isDirectory()) { 
			try (Writer writer = new FileWriter("productLog-"+ dateFormat.format(date) +".json")) {
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		combined.addAll(shoppingCar);
		if(getList(dateFormat.format(date)) != null){
			combined.addAll(getList(dateFormat.format(date)));
		}
		try (Writer writer = new FileWriter("productLog-"+ dateFormat.format(date) +".json")) {
			writer.write(gson.toJson(combined));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/***Liest das JSONfile und generiert daraus Produktobjekte 
	 * @return productLog
	 */
	@Override
	public ArrayList<Product> getList(String date) {
		// TODO Auto-generated method stub
		try (Reader reader = new FileReader("productLog-"+ date +".json")) {
			Type type = new TypeToken<List<ProductImpl>>() {
			}.getType();			
			productLog = new Gson().fromJson(reader, type);
			return productLog;


		} catch (IOException e) {
			e.printStackTrace();
		}
		return productLog;
	}	
}
