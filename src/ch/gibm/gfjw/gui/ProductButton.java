package ch.gibm.gfjw.gui;

import static ch.gibm.gfjw.gui.Style.BORDER;
import static ch.gibm.gfjw.gui.Style.FONT;
import static java.awt.Color.WHITE;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ch.gibm.gfjw.dto.Product;


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
		this.setFont(FONT);
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainview.getLblDisplay().setText(getProduct().getName());
				mainview.getShoppingCart().addProduct(product);
				mainview.reloadList();
			}
		});
	}

	public Product getProduct() {
		return product;
	}
}