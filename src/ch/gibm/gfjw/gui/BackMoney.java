/**
 * erstellt einen Button für jedes Geld schein.
 */
package ch.gibm.gfjw.gui;
import static java.awt.Color.WHITE;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import ch.gibm.gfjw.gui.TableModel;
import ch.gibm.gfjw.business.MoneyList;
import ch.gibm.gfjw.dto.Coint;

public class BackMoney extends JPanel{

	private static final long serialVersionUID = 1L;
	private View view;
	private Coint[] coints = {
			new Coint("images/Franken/CHF005.jpg", 0.05, "005CHF"),
			new Coint("images/Franken/CHF010.jpg", 0.10, "01CHF"),
			new Coint("images/Franken/CHF020.jpg", 0.20, "02CHF"),
			new Coint("images/Franken/CHF050.jpg", 0.50, "05CHF"),
			new Coint("images/Franken/CHF1.jpg", 1.00, "1CHF"),
			new Coint("images/Franken/CHF2.jpg", 2.00, "2CHF"),
			new Coint("images/Franken/CHF5.jpg", 5.00, "5CHF"),
			new Coint("images/Franken/CHF10.jpg", 10.00, "10CHF"),
			new Coint("images/Franken/CHF20.jpg", 20.00, "20CHF"),
			new Coint("images/Franken/CHF50.jpg", 50.00, "50CHF"),
			new Coint("images/Franken/CHF100.jpg", 100.00, "100CHF"),
			new Coint("images/Franken/CHF200.jpg", 200.00, "200CHF"),
	};
	
	public BackMoney(View mainFrame) {
		
		this.view = mainFrame;
		this.setLayout(new GridLayout(3, 4));
		
		for(Coint coint : coints){
			this.add(new CointButtons(this, coint));
		}
		
		this.setBackground(WHITE);
		this.setLayout(new GridLayout(3, 4));
		
		this.setVisible(true);
	}
	
	public JLabel getLblDisplay(){
		return view.getLblDisplay();
	}
	
	public TableModel getModelProductList(){
		return view.getModelProductList();
	}
	
	public MoneyList getMoneyList(){
		return this.view.getCointList();
	}
	
	public void reloadList(){
		view.reloadList();
	}
	
	public Double getPurchaseTotal(){
		return view.getShoppingCart().getTotal();
	}
}