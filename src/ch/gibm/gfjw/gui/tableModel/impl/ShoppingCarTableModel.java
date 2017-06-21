package ch.gibm.gfjw.gui.tableModel.impl;

import javax.swing.table.DefaultTableModel;

import ch.gibm.gfjw.business.ShoppingCar;
import ch.gibm.gfjw.dto.Product;
import ch.gibm.gfjw.gui.TableModel;

public class ShoppingCarTableModel extends DefaultTableModel implements TableModel {
	
	private static final long serialVersionUID = 1L;
	private ShoppingCar shoppingcCar;
	
	public ShoppingCarTableModel(ShoppingCar shoppingcCar){
		this.shoppingcCar = shoppingcCar;
		this.addColumn("Produkte");
		this.addColumn("Preis");
	}
	
	@Override
	public void reloadList(){
		for (int i = 0; i >= this.getRowCount(); i++) {
			this.removeRow(i);
		}
		for(Product product : this.shoppingcCar.getShoppingCar()){
			this.addRow(new Object[]{product.getName(), product.getResale()});
		}
	}

	public ShoppingCar getShoppingcCar() {
		return shoppingcCar;
	}
}