package ch.gibm.gfjw.business;

import java.util.ArrayList;

import ch.gibm.gfjw.dto.Product;

public class ShoppingCar {
	
	private ArrayList<Product> shoppingCar = new ArrayList<>();
	
	public Product getProduct(int id){
		return shoppingCar.get(id);
	}
	
	public ArrayList<Product> getShoppingCar() {
		return shoppingCar;
	}

	public void deleteProduct(int id){
		shoppingCar.remove(id);
	}
	
	public Double getTotal(){
		double total = 0;
		for (Product product : shoppingCar) {
			total += product.getResale();
		}
		return total;
	}
	
	public void addProduct(Product product){
		shoppingCar.add(product);
	}
	
	public void  writeShoppingCar(){
	}
}
