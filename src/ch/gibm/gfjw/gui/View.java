package ch.gibm.gfjw.gui;
import static java.awt.Color.WHITE;
import static ch.gibm.gfjw.gui.Style.FONT;
import static ch.gibm.gfjw.gui.Style.createButton;
import static ch.gibm.gfjw.gui.Style.createJPanel;
import static ch.gibm.gfjw.gui.Style.createLabel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel lblDisplay;
	private JTable tblProductView;
	private DefaultTableModel modelProductList = new DefaultTableModel();
	private JButton btnEnter, btnDelete, btnTeam, btnSettings;
    private JPanel mainView, productButtonView , manageProductView, showProductView, menuBarView, productView;
//    private ManageProductPanel manageProductPanel = new ManageProductPanel();
//    private ShoppingCart shoppingCart = new ShoppingCart();
    
	public View () {
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("Images/mylogo.png"));
		
		this.setTitle("GK Kasse");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(0, 0);
		this.setSize(1070, 1000);
		this.getRootPane().setBorder(new EmptyBorder(15, 10, 10, 10));
		this.getRootPane().setBackground(WHITE);
		this.getContentPane().setBackground(WHITE);
		this.setLayout(new BorderLayout(30,30));
		
		mainView = createJPanel(new BorderLayout(10, 10));
		productButtonView = createJPanel(new GridLayout(4,4,20,20));
		showProductView = createJPanel(new BorderLayout(50, 50));
		manageProductView = createJPanel(new GridLayout(6, 1, 10, 50));
		menuBarView = createJPanel(new GridLayout(1, 20, 20, 20));
		productView = createJPanel(new CardLayout(10, 10));
		
		lblDisplay = createLabel(400, 50);
		
		tblProductView = new JTable(modelProductList);
		tblProductView.setFont(FONT);
		tblProductView.setSize(400, 700);
		tblProductView.setRowHeight(30);
		modelProductList.addColumn("Produkte");
		modelProductList.addColumn("Preis");

		btnEnter = createButton(manageProductView, new ImageIcon("images/Buttons/checkmark.png"));
		btnDelete = createButton(manageProductView, new ImageIcon("images/Buttons/Trash.png"));
		btnTeam = createButton(manageProductView, new ImageIcon("images/Buttons/Team.png"));
		btnSettings = createButton(menuBarView, new ImageIcon("images/Buttons/settings.png"));
		
	    
		this.add(mainView, BorderLayout.CENTER);
		this.add(showProductView, BorderLayout.EAST);
		this.add(menuBarView, BorderLayout.NORTH);
		mainView.add(productView, BorderLayout.CENTER);
		mainView.add(manageProductView, BorderLayout.EAST);
		productView.add(productButtonView, BorderLayout.CENTER);
		showProductView.add(lblDisplay, BorderLayout.NORTH);
		showProductView.add(new JScrollPane(tblProductView), BorderLayout.CENTER);
		
//		for (new ProductLogic().getList() : product) {
//			productButtonView.add(new ProductButton(product, this));
//		}
		
		modelProductList.addRow(new Object[]{"Total"});
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		 		 
	    if (e.getSource() == this.btnEnter){
	    	   
	    }
	    
	    else if (e.getSource() == this.btnDelete){
	    	modelProductList.removeRow(tblProductView.getSelectedRow());
	    }
	     
	    else if (e.getSource() == this.btnTeam){
	    }
	     
	    else if (e.getSource() == this.btnSettings){
	    }
	}

	public JLabel getLblDisplay() {
		return lblDisplay;
	}

	public DefaultTableModel getModelProductList() {
		return modelProductList;
	}

	public JButton getBtnEnter() {
		return btnEnter;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

//	public ShoppingCart getShoppingCart() {
//		return shoppingCart;
//	}
}