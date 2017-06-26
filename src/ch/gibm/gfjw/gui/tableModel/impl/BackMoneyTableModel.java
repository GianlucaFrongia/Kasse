package ch.gibm.gfjw.gui.tableModel.impl;

import static ch.gibm.gfjw.gui.Style.DoubletoCHF;

import javax.swing.table.DefaultTableModel;

import ch.gibm.gfjw.business.MoneyList;
import ch.gibm.gfjw.dto.Coint;
import ch.gibm.gfjw.gui.TableModel;

public class BackMoneyTableModel extends DefaultTableModel implements TableModel{

	private static final long serialVersionUID = 1L;
	private MoneyList moneyList;
	
	public BackMoneyTableModel(MoneyList moneyList) {
		this.moneyList = moneyList;
		
		this.addColumn("Wert");
	}
	
	public MoneyList getMoneyList() {
		return moneyList;
	}

	@Override
	public void reloadList() {
		for (int i = this.getRowCount() - 1; i >= 0; i--) {
			this.removeRow(i);
		}
		for(Coint coint : this.moneyList.getMoneyList()){
			this.addRow(new Object[]{DoubletoCHF(coint.getValue())});
		}
		
		this.addRow(new Object[]{"", ""});
		this.addRow(new Object[]{"Total: " + DoubletoCHF(this.moneyList.getTotal())});
	}
}

