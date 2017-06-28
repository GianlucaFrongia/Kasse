/**
 * Tablemodel für den Shoppingcar in der Mainview.
 * 
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */

package ch.gibm.gfjw.gui.tableModel.impl;

import static ch.gibm.gfjw.gui.Style.DoubletoCHF;

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
		for (int i = this.getRowCount() - 1; i >= 0; i--) {
			this.removeRow(i);
		}
		for(Product product : this.shoppingcCar.getShoppingCar()){
			this.addRow(new Object[]{product.getName(), DoubletoCHF(product.getResale())});
		}
		this.addRow(new Object[]{"", ""});
		this.addRow(new Object[]{"Total", DoubletoCHF(this.shoppingcCar.getTotal())});
	}
	
	@Override
	public boolean isCellEditable(int row, int column){
      return false;
    }

	public ShoppingCar getShoppingcCar() {
		return shoppingcCar;
	}
}
