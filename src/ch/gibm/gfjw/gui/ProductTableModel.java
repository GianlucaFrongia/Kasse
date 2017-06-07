package ch.gibm.gfjw.gui;

import javax.swing.table.DefaultTableModel;

public class ProductTableModel extends DefaultTableModel {
	
	public ProductTableModel(){
		
		this.addColumn("ID");
		this.addColumn("Name");
		this.addColumn("Verkaufspreis");
		this.addColumn("Einkaufspreis");
		
//		for (new ProductLogic().getList() prducts: Product()) {
//			this.addRow(new Object[]{prducts.getId(), prducts.getName(), prducts.getResale(), prducts.Price()});
//		}
		
		this.addRow(new Object[]{"1", "Cola", "2.00", "1.50"});
	}
}
