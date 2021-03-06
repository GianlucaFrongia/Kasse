/**
 * Main Fenster das beim Starten aufgerufen wird.
 * 
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */

package ch.gibm.gfjw.gui;
import static java.awt.Color.WHITE;
import static ch.gibm.gfjw.gui.Style.createButton;
import static ch.gibm.gfjw.gui.Style.createJPanel;
import static ch.gibm.gfjw.gui.Style.createLabel;
import static ch.gibm.gfjw.gui.Style.createTable;
import static ch.gibm.gfjw.gui.Style.createScrollPane;
import static ch.gibm.gfjw.gui.Style.DoubletoCHF;

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
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import ch.gibm.gfjw.business.MoneyList;
import ch.gibm.gfjw.business.ProductLogic;
import ch.gibm.gfjw.business.ShoppingCar;
import ch.gibm.gfjw.dto.Product;
import ch.gibm.gfjw.gui.tableModel.impl.BackMoneyTableModel;
import ch.gibm.gfjw.gui.tableModel.impl.ShoppingCarTableModel;
import ch.gibm.gfjw.gui.TableModel;

public class View extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel lblDisplay;
	private JTable tblProductView;
	private TableModel modelProductList;
	private JButton btnEnter, btnDelete, btnTeam, btnSettings;
    private JPanel mainView, productButtonView , manageProductView, showProductView, menuBarView, switchViewRight, switchViewLeft;
    private JPanel backMoney = new BackMoney(this);
    private ShoppingCar shoppingCar;
    private MoneyList cointList;
    private Boolean teamPrice = false;
    
	public View() {
		this.shoppingCar = new ShoppingCar();
		this.modelProductList = new ShoppingCarTableModel(shoppingCar);
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("Images/mylogo.png"));
		
		this.setTitle("Gewoelbekeller Kasse");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(0, 0);
		this.setSize(1070, 1000);
		this.getRootPane().setBorder(new EmptyBorder(15, 10, 10, 10));
		this.getRootPane().setBackground(WHITE);
		this.getContentPane().setBackground(WHITE);
		this.setLayout(new BorderLayout(30,30));
		
		mainView = createJPanel(new BorderLayout(10, 10));
		productButtonView = createJPanel(new GridLayout(6,4,20,20));
		showProductView = createJPanel(new BorderLayout(50, 50));
		manageProductView = createJPanel(new GridLayout(6, 1, 10, 50));
		menuBarView = createJPanel(new GridLayout(1, 20, 20, 20));
		switchViewRight = createJPanel(new CardLayout(10, 10));
		switchViewLeft = createJPanel(new CardLayout(10, 10));
		
		lblDisplay = createLabel(400, 50);
		
		tblProductView = createTable(modelProductList);
		tblProductView.setSize(400, 700);

		btnEnter = createButton(manageProductView, new ImageIcon("images/Buttons/checkmark.png"));
		btnDelete = createButton(manageProductView, new ImageIcon("images/Buttons/Trash.png"));
		btnTeam = createButton(manageProductView, new ImageIcon("images/Buttons/Team.png"));
		btnSettings = createButton(menuBarView, new ImageIcon("images/Buttons/settings.png"));
		
	    
		this.add(mainView, BorderLayout.CENTER);
		this.add(showProductView, BorderLayout.EAST);
		this.add(menuBarView, BorderLayout.NORTH);
		mainView.add(switchViewRight, BorderLayout.CENTER);
		mainView.add(switchViewLeft, BorderLayout.EAST);
		switchViewLeft.add(manageProductView);
		switchViewRight.add(productButtonView, BorderLayout.CENTER);
		switchViewRight.add(backMoney, BorderLayout.CENTER);
		
		showProductView.add(lblDisplay, BorderLayout.NORTH);
		showProductView.add(createScrollPane(tblProductView), BorderLayout.CENTER);

		loadProductbuttons();
		
		btnDelete.addActionListener(this);
		btnEnter.addActionListener(this);
		btnSettings.addActionListener(this);
		btnTeam.addActionListener(this);
		
		this.setVisible(true);
		backMoney.setVisible(false);
	}
	
	/**
	 * verwaltet die aktionen der Buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == this.btnEnter){
			if (modelProductList.getRowCount() > 2){
				if(productButtonView.isVisible() == true){
					shoppingCar.writeShoppingCar();
		    		productButtonView.setVisible(false);
		    		backMoney.setVisible(true);
		    		lblDisplay.setText(DoubletoCHF(shoppingCar.getTotal()));
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
				btnTeam.setEnabled(!btnTeam.isEnabled());
				tblProductView.setModel(modelProductList);
			} else {
				lblDisplay.setText("Keine Listeneinträge");
			}
	    }
	    
	    else if (e.getSource() == this.btnDelete){
	    	if (tblProductView.getSelectedRow() >= 0 && tblProductView.getSelectedRow() < tblProductView.getRowCount() - 2){
		    	if(productButtonView.isVisible() == true){
		    		shoppingCar.deleteProduct(tblProductView.getSelectedRow());
		    	}else if(backMoney.isVisible() == true){
		    		cointList.deleteCoint(tblProductView.getSelectedRow());
		    	}
		    modelProductList.reloadList();
		    lblDisplay.setText("Produkt wurde entfernt");
		    } else {
		    	lblDisplay.setText("Kein Produkt gewält");
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
	        ManageProductPanel manageProductPanel = new ManageProductPanel(this);
	    }
	}
	
	public Boolean isTeamPrice() {
		return teamPrice;
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
	
	public void loadProductbuttons(){
		ProductLogic logic = new ProductLogic();
		productButtonView.removeAll();
		
		for (Product product : logic.getList()) {
			if(logic.getList().size() > 24){
				productButtonView.setLayout(new GridLayout((logic.getList().size() / 3), 4, 20, 20));
			}
			productButtonView.add(new ProductButton(product, this));
		}
		this.revalidate();
		this.repaint();
	}
}