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

import ch.gibm.gfjw.business.MoneyList;
import ch.gibm.gfjw.business.ShoppingCar;
import ch.gibm.gfjw.dto.ProductImpl;
import ch.gibm.gfjw.gui.tableModel.impl.BackMoneyTableModel;
import ch.gibm.gfjw.gui.tableModel.impl.ShoppingCarTableModel;
import ch.gibm.gfjw.gui.TableModel;

public class View extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel lblDisplay;
	private JTable tblProductView;
	private TableModel modelProductList;
	private JButton btnEnter, btnDelete, btnTeam, btnSettings;
    private JPanel mainView, productButtonView , manageProductView, showProductView, menuBarView, switchView;
    private JPanel backMoney = new BackMoney(this);
    private ShoppingCar shoppingCar;
    private MoneyList cointList;
    private Boolean teamPrice = false;
    
	public View() {
		this.shoppingCar = new ShoppingCar();
		this.modelProductList = new ShoppingCarTableModel(shoppingCar);
		
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
		switchView = createJPanel(new CardLayout(10, 10));
		
		lblDisplay = createLabel(400, 50);
		
		tblProductView = new JTable();
		tblProductView.setModel(modelProductList);
		tblProductView.setFont(FONT);
		tblProductView.setBackground(WHITE);
		tblProductView.setSize(400, 700);
		tblProductView.setRowHeight(30);

		btnEnter = createButton(manageProductView, new ImageIcon("images/Buttons/checkmark.png"));
		btnDelete = createButton(manageProductView, new ImageIcon("images/Buttons/Trash.png"));
		btnTeam = createButton(manageProductView, new ImageIcon("images/Buttons/Team.png"));
		btnSettings = createButton(menuBarView, new ImageIcon("images/Buttons/settings.png"));
		
	    
		this.add(mainView, BorderLayout.CENTER);
		this.add(showProductView, BorderLayout.EAST);
		this.add(menuBarView, BorderLayout.NORTH);
		mainView.add(switchView, BorderLayout.CENTER);
		mainView.add(manageProductView, BorderLayout.EAST);
		switchView.add(productButtonView, BorderLayout.CENTER);
		switchView.add(backMoney, BorderLayout.CENTER);
		
		showProductView.add(lblDisplay, BorderLayout.NORTH);
		showProductView.add(new JScrollPane(tblProductView), BorderLayout.CENTER);
		
//		for (Product product : new ProductLogic().getList()) {
//			productButtonView.add(new ProductButton(product, this));
//		}
		
		productButtonView.add(new ProductButton(new ProductImpl("Cola", 1, 2.50, 2.00), this));
		productButtonView.add(new ProductButton(new ProductImpl("Fanta", 1, 2.50, 2.00), this));
		
		btnDelete.addActionListener(this);
		btnEnter.addActionListener(this);
		btnSettings.addActionListener(this);
		btnTeam.addActionListener(this);
		
		this.setVisible(true);
		backMoney.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		 		 
	    if (e.getSource() == this.btnEnter){
	    	   if(productButtonView.isVisible() == true){
	    		   shoppingCar.writeShoppingCar();
	    		   productButtonView.setVisible(false);
	    		   backMoney.setVisible(true);
	    		   cointList = new MoneyList();
	    		   modelProductList = new BackMoneyTableModel(cointList);
	    	   }else if(backMoney.isVisible() == true){
	    		   lblDisplay.setText("Nächster Kunde");
	    		   backMoney.setVisible(false);
	    		   productButtonView.setVisible(true);
	    		   shoppingCar = new ShoppingCar();
	    		   modelProductList = new ShoppingCarTableModel(shoppingCar);
	    		   this.repaint();
	    	   }
	    	   tblProductView.setModel(modelProductList);
	    }
	    
	    else if (e.getSource() == this.btnDelete){
	    	if (modelProductList.getRowCount() > 2){
		    	if(productButtonView.isVisible() == true){
		    		shoppingCar.deleteProduct(tblProductView.getSelectedRow());
		    	}else if(backMoney.isVisible() == true){
		    		cointList.deleteCoint(tblProductView.getSelectedRow());
		    	}
		    	modelProductList.reloadList();
		    	lblDisplay.setText("Produkt wurde entfernt");
		    }
	    }
	     
	    else if (e.getSource() == this.btnTeam){
	    	if(teamPrice){
	    		lblDisplay.setText("Teammodus deaktiviert");
	    	}else{
	    		lblDisplay.setText("Teammodus aktiviert");
	    	}
	    		teamPrice = !teamPrice;
	    }
	     
	    else if (e.getSource() == this.btnSettings){
	        ManageProductPanel manageProductPanel = new ManageProductPanel();
	    }
	}

	public JLabel getLblDisplay() {
		return lblDisplay;
	}

	public TableModel getModelProductList() {
		return modelProductList;
	}

	public JButton getBtnEnter() {
		return btnEnter;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public ShoppingCar getShoppingCart() {
		return shoppingCar;
	}
	
	public MoneyList getCointList() {
		return cointList;
	}
	
	public void reloadList(){
		modelProductList.reloadList();
		tblProductView.repaint();
	}
}