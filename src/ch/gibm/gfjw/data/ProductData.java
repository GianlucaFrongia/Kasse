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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by gianluca on 06.06.17
 */

public class ProductData implements ProductDao{


    public List<Product> getProductList() {
    		
    		ArrayList<Product> list = new ArrayList<>();
    		JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("products.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            
            list.add(new ProductImpl((String) jsonObject.get("name"),
            		(Integer) jsonObject.get("id"), 
            		(Double) jsonObject.get("resale"), 
            		(Double) jsonObject.get("price")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return list;

    }
    	
    	 	
//        try (Reader reader = new FileReader("products.json")) {
//            Type type = new TypeToken<List<ProductImpl>>(){}.getType();
//
//            List<Product> productList = new Gson().fromJson(reader, type);
//
//            return productList;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }



    public int deleteProduct(int id) {
        return id;
    }

    public void addProduct(Product product) {
    	
    	JsonArray list = new JsonArray(obj);
    	
    	JSONObject obj = new JSONObject();
        obj.put("id", product.getId());
        obj.put("name", product.getName());
        obj.put("resale", product.getResale());
        obj.put("price", product.getPrice());

        try (FileWriter file = new FileWriter("products.json", true)) {
        	
            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);
    }
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//        List<Product> productList = new ArrayList<Product>();
//        productList.add(product);
//
//        try (Writer writer = new FileWriter("products.json", true)) {
//            writer.write(gson.toJson(productList));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}


