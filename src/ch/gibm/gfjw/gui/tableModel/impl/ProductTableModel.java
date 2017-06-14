package ch.gibm.gfjw.gui.tableModel.impl;

import javax.swing.table.DefaultTableModel;

import ch.gibm.gfjw.gui.TableModel;

public class ProductTableModel extends DefaultTableModel implements TableModel{
	
	private static final long serialVersionUID = 1L;

	public ProductTableModel(){
		
		this.addColumn("ID");
		this.addColumn("Name");
		this.addColumn("Verkaufspreis");
		this.addColumn("Einkaufspreis");
		
//		for (new ProductLogic().getList() prducts: Product()) {
//			this.addRow(new Object[]{prducts.getId(), prducts.getName(), prducts.getResale(), prducts.Price()});
//		}
		
		this.addRow(new Object[]{"1", "Cola", "2.00", "1.50"});
		this.addRow(new Object[]{"2", "Fanta", "2.00", "1.50"});
	}

	@Override
	public void reloadList() {
		
	}
}
