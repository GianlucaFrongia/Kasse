package ch.gibm.gfjw.kasse;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.gibm.gfjw.gui.BackMoney;
import ch.gibm.gfjw.gui.ManageProductPanel;
import ch.gibm.gfjw.gui.View;

/**
 * Created by gianluca on 17.05.17.
 */
public class Main {
	
	public static void main(String[] args) {
		
//	View view = new View();
	JFrame frame = new JFrame();
	frame.setLayout(new BorderLayout());
	JPanel mangProd = new BackMoney(200.0, new View());
	frame.add(mangProd, BorderLayout.CENTER);
	frame.setVisible(true);
	}
}
