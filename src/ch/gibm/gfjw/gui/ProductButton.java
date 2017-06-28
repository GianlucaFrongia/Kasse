/**
 * Button für jedes Produkt.
 * 
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */
package ch.gibm.gfjw.gui;

import static ch.gibm.gfjw.gui.Style.BORDER;
import static ch.gibm.gfjw.gui.Style.FONTBOLD;
import static java.awt.Color.WHITE;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ch.gibm.gfjw.dto.Product;
import ch.gibm.gfjw.dto.TeamPrice;


public class ProductButton extends JButton {
	private Product product;
	private static final long serialVersionUID = 1L;
	private View mainview;
	
	public ProductButton(Product product, View minview){
		
		this.product = product;
		this.mainview = minview;
		
		this.setBackground(Color.WHITE);
		this.setText(product.getName());
		this.setBackground(WHITE);
		this.setBorder(BORDER);
		this.setFont(FONTBOLD);
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (mainview.isTeamPrice()){
					mainview.getShoppingCart().addProduct(new TeamPrice(product.getName(), product.getId(), product.getResale(), product.getPrice()));
				} else {
					mainview.getShoppingCart().addProduct(product);
				}
				mainview.getLblDisplay().setText(getProduct().getName());
				mainview.reloadList();
			}
		});
	}

	public Product getProduct() {
		return product;
	}
}