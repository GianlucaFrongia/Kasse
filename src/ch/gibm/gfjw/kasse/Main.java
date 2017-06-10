package ch.gibm.gfjw.kasse;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.rmi.CORBA.PortableRemoteObjectDelegate;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.gibm.gfjw.data.ProductData;
import ch.gibm.gfjw.dto.Product;
import ch.gibm.gfjw.dto.ProductImpl;
import ch.gibm.gfjw.gui.BackMoney;
import ch.gibm.gfjw.gui.ManageProductPanel;
import ch.gibm.gfjw.gui.View;

/**
 * Created by gianluca on 17.05.17.
 */
public class Main {
	
	public static void main(String[] args) {
		
		ProductData data = new ProductData();
		data.addProduct(new ProductImpl("Cola", 1, 2.00, 1.50));
		data.addProduct(new ProductImpl("Fanta", 2, 4.00, 1.00));
		
//		System.out.println(data.getProductList().get(0).getName());
//		System.out.println(data.getProductList().get(1).getName());
	}
}
