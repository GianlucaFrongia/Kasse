package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import ch.gibm.gfjw.business.ProductLogic;
import ch.gibm.gfjw.business.ShoppingCar;
import ch.gibm.gfjw.dto.Product;
import ch.gibm.gfjw.dto.ProductImpl;

public class testKasse {
	ProductLogic kasse = new ProductLogic();
	ShoppingCar car = new ShoppingCar();

	Product pr = new ProductImpl("Cola", 1, 2.00, 1.50);
	Product pr1 = new ProductImpl("Cola", 1, 2.00, 1.50);
	Product pr2 = new ProductImpl("Cola", 1, 2.00, 1.50);

	@Test
	public void addProduct(){
		kasse.addProduct(pr);
		System.out.print(kasse.getList().get(0).getPrice());
		assertEquals(kasse.getList().get(0).getPrice(),  1.5, 0.0001);
	}	
	@Test
	public void preisBerechnen(){
		car.addProduct(pr);
		car.addProduct(pr1);
		car.addProduct(pr2);
		assertEquals(car.getTotal(),  6, 0.0001);
	}
	
	@Test
	public void preisBerechnenNachLoeschen(){
		car.addProduct(pr);
		car.addProduct(pr1);
		car.addProduct(pr2);
		car.deleteProduct(2);
		assertEquals(car.getTotal(),  4, 0.0001);
	}
	
	
}
