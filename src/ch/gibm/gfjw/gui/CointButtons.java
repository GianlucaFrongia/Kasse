package ch.gibm.gfjw.gui;

import static java.awt.Color.WHITE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ch.gibm.gfjw.dto.Coint;

public class CointButtons extends JButton{
	
	private static final long serialVersionUID = 1L;
	private Coint coint;

	public CointButtons(BackMoney mainView, Coint coint) {
		this.coint = coint;
		
		this.setIcon(this.coint.getImage());
		this.setBackground(WHITE);
		this.setBorder(null);
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainView.getLblDisplay().setText(Double.toString(coint.getValue()));
//				mainView.getWarenkorb().add(product);
			}
		});
	}
}