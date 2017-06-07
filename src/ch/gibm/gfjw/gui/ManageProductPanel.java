package ch.gibm.gfjw.gui;
 
import static ch.gibm.gfjw.gui.Style.createJPanel;
import static ch.gibm.gfjw.gui.Style.createButton;
import static java.awt.Color.WHITE;
import static ch.gibm.gfjw.gui.Style.FONTBOLD;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ManageProductPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel productView;
	private JTable productList;
	private JButton btnRemoveProduct, btnSave, btnBack;
	
	public ManageProductPanel() {
		
		this.setLayout(new BorderLayout(10, 10));
		this.setBackground(WHITE);
		
		productList = new JTable(new ProductTableModel());
		productList.setFont(FONTBOLD);
		productList.setRowHeight(30);
		
		productView = createJPanel(new GridLayout(1, 2, 20, 20));
		this.add(productView, BorderLayout.SOUTH);
		this.add(productList, BorderLayout.CENTER);
		
		btnRemoveProduct = createButton(productView, new ImageIcon("images/Buttons/Trash.png"));
		btnSave = createButton(productView, new ImageIcon("images/Buttons/checkmark.png"));
		btnBack = createButton(this, BorderLayout.NORTH, "< Zurück");
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSave){
			
		}
		if (e.getSource() == btnRemoveProduct) {
			
		}
		if (e.getSource() == btnBack) {
			
		}
	}
	
	
}

