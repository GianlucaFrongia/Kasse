package ch.gibm.gfjw.kasse;

import java.util.ArrayList;

import ch.gibm.gfjw.data.ProductLogData;
import ch.gibm.gfjw.dto.Product;
import ch.gibm.gfjw.dto.ProductImpl;

/**
 * Created by gianluca on 17.05.17.
 */
public class Main {
	
	public static void main(String[] args) {
		
		//ProductData data = new ProductData();
		ProductLogData dump = new ProductLogData();
//		ArrayList<Product> shoppingCar = new ArrayList<Product>();
//		
//		//	data.deleteProduct(2);
//
//		Product pr = new ProductImpl("Cola", 1, 2.00, 1.50);
////
//		Product pr2 = new ProductImpl("Fanta", 2, 4.00, 1.00);
//
//		shoppingCar.add(pr);
//		shoppingCar.add(pr2);
		System.out.print(dump.getList("2017.06.14"));
		

		//		data.addProduct(pr);
//		data.addProduct(pr2);	
//		for (Product p : data.getProductList()) {
//			System.out.println(data.getProductList().get(0));
//
//		}
//		System.out.println(data.getProductList().get(1));
	}
}
