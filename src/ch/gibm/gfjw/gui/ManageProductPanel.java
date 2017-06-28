/**
 * Windows um die Produkte zu verwalten.
 */
package ch.gibm.gfjw.gui;
 
import static ch.gibm.gfjw.gui.Style.createButton;
import static ch.gibm.gfjw.gui.Style.createJPanel;
import static ch.gibm.gfjw.gui.Style.createTable;
import static ch.gibm.gfjw.gui.Style.createScrollPane;
import static java.awt.Color.WHITE;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ch.gibm.gfjw.business.ProductLogic;
import ch.gibm.gfjw.dto.Product;
import ch.gibm.gfjw.dto.ProductImpl;

public class ManageProductPanel extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel productView;
	private JTable tblProductList;
	private JButton btnRemoveProduct, btnSave, btnBack, btnAdd;
	private ProductLogic logic = new ProductLogic();
	private DefaultTableModel model = new DefaultTableModel();
	private View view;
	
	public ManageProductPanel(View view) {
		
		this.view = view;
		
		this.getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10));
		this.setSize(500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(10, 10));
		this.getContentPane().setBackground(WHITE);
		this.getRootPane().setBackground(WHITE);
		
		tblProductList = createTable(model);
		
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Verkaufspreis");
		model.addColumn("Einkaufspreis");
		
		for (Product product : logic.getList()) {
			model.addRow(new Object[]{Integer.toString(product.getId()), product.getName(), Double.toString(product.getResale()), Double.toString(product.getPrice())});
		}
		
		productView = createJPanel(new GridLayout(1, 3, 20, 20));
		this.add(productView, BorderLayout.SOUTH);
		this.add(createScrollPane(tblProductList), BorderLayout.CENTER);
		
		btnRemoveProduct = createButton(productView, new ImageIcon("images/Buttons/Trash.png"));
		btnSave = createButton(productView, new ImageIcon("images/Buttons/checkmark.png"));
		btnBack = createButton("Abbrechen");
		btnAdd = createButton(productView, new ImageIcon("images/buttons/plus.png"));
		this.add(btnBack, BorderLayout.NORTH);
		
		btnSave.addActionListener(this);
		btnRemoveProduct.addActionListener(this);
		btnBack.addActionListener(this);
		btnAdd.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSave){
			if (model.getRowCount() != 0){
				for (Product product : logic.getList()) {
					logic.deleteProduct(product.getId());
				}
				Vector data = this.model.getDataVector();
				for(int i = 0; i < data.size(); i++) {
				    Vector<String> row = (Vector)data.get(i);
				    if(row != null) {
						Product product = new ProductImpl();
						product.setId(Integer.parseInt(row.get(0)));
						product.setName(row.get(1));
						product.setPrice(Double.parseDouble(row.get(3)));
						product.setResale(Double.parseDouble(row.get(2)));
						logic.addProduct(product);
				    }
				}
			}
			this.dispose();
			this.view.loadProductbuttons();
		}
		if (e.getSource() == btnRemoveProduct) {
			if (model.getRowCount() != 0 && tblProductList.getSelectedRow() >= 0){
				model.removeRow(tblProductList.getSelectedRow());
				tblProductList.repaint();
			}
			
		}
		if (e.getSource() == btnBack) {
			this.dispose();
		}
		if (e.getSource() == btnAdd){
			model.addRow(new Object[]{Integer.toString(model.getRowCount() + 1), "Name", "0.00", "0.00"});
			tblProductList.repaint();
		}
	}
}