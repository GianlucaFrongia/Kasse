/**
 * enthäölt methoden zum erstellen der einenlen Componenten.
 * 
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */
package ch.gibm.gfjw.gui;

import static java.awt.Color.WHITE;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class Style {
	
	public static final Font FONT= new Font("Verdana", 0, 16);
	public static final Font FONTBOLD= new Font("Verdana", Font.BOLD, 20);
    public final static Border BORDER = new RoundedBorder(15);
    public final static Color BLUE = new Color(92,172,238);
    public final static Color GREEN = new Color(0,153,0);
    public final static Color RED = new Color(204,0,51);
    
    /**
     * Generiert einen Button.
     * @param name Anzeigetext des Buttons
     * @return default Button
     */
	public final static JButton createButton(String name){
		JButton button = new JButton(name);
		button.setPreferredSize(new Dimension(150,50));
		button.setBackground(null); 
		button.setBorder(BORDER);
		button.setFont(FONT);
		return button;	
	}
	
	/**
	 * Generiert einen Button mit einem Bild.
	 * @param addToPanel Panel in welchem der Button hinzugefügt werden soll.
	 * @param constraints Die Konditionen für das Panel.
	 * @param image Bild für den Button
	 * @return Einen Button mit Bild.
	 */
	public final static JButton createButton(JPanel addToPanel, Object constraints, ImageIcon image){
		JButton button = createButton(addToPanel, constraints, "");
		button.setIcon(image);
		return button;	
	}
	
	
	/**
	 * Generiert einen Button mit einem Bild.
	 * @param addToPanel Panel in welchem der Button hinzugefügt werden soll.
	 * @param image Bild für den Button
	 * @return Einen Button mit Bild.
	 */
	public final static JButton createButton(JPanel addToPanel, ImageIcon image){
		JButton button = createButton(addToPanel, "");
		button.setIcon(image);
		return button;	
	}
	/**
	 * Generiert einen Button mit text Bild.
	 * @param addToPanel Panel in welchem der Button hinzugefügt werden soll.
	 * @param constraints Die Konditionen für das Panel.
	 * @param String text
	 * @return Einen Button.
	 */
	public final static JButton createButton(JPanel addToPanel, Object constraints, String text){
		JButton button = createButton(text);
		addToPanel.add(button, constraints);
		return button;	
	}
	
	/**
	 * Generiert einen Button mit text Bild.
	 * @param addToPanel Panel in welchem der Button hinzugefügt werden soll.
	 * @param String Text
	 * @return Einen Button.
	 */
	public final static JButton createButton(JPanel addToPanel, String text){
		JButton button = createButton(text);
		addToPanel.add(button);
		return button;	
	}
	
	/**
	 * Generiert ein Standartlabel.
	 * @param width breite des Labels
	 * @param height Höhe des Labels
	 * @param name Text im Label
	 * @return Standartlabel
	 */
	public final static JLabel createLabel(int width, int height, String name){
		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(width, height));
		label.setFont(Style.FONTBOLD);
		label.setBackground(BLUE);
		label.setForeground(WHITE);
		label.setOpaque(true); 
		label.setBorder(new EmptyBorder(0, 10, 0, 0));
		return label;
	}
	
	/**
	 * Generiert einen Label ohne text.
	 * @param int widht.
	 * @param int height
	 * @return Einen label.
	 */
	public final static JLabel createLabel(int width, int height){
		JLabel label = createLabel(width, height, ""); 
		return label;
	}
	
	/**
	 * Generiert einen Panel im BorderLayout.
	 * @param BorderLayout layout.
	 * @return Einen panel.
	 */
	public final static JPanel createJPanel(BorderLayout layout){
		JPanel panel = createJPanel();
		panel.setLayout(layout);
		return panel;
	}
	
	/**
	 * Generiert einen Panel im GridLayout.
	 * @param Gridlayout.
	 * @return Einen panel.
	 */
	public final static JPanel createJPanel(GridLayout layout){
		JPanel panel = createJPanel();
		panel.setLayout(layout);
		return panel;
	}
	
	/**
	 * Generiert einen Panel im CardLayout.
	 * @param CartdLayout layout.
	 * @return Einen panel.
	 */
	public final static JPanel createJPanel(CardLayout layout){
		JPanel panel = createJPanel();
		panel.setLayout(layout);
		return panel;
	}

	/**
	 * Generiert einen Panel.
	 * @return Einen panel.
	 */
	private final static JPanel createJPanel() {
		JPanel panel = new JPanel();	
		panel.setBackground(WHITE);
		return panel;
	}
	/**
	 * Generiert einen SchrollPanel im BorderLayout.
	 * @param Component component.
	 * @return Einen scroll.
	 */
	public final static JScrollPane createScrollPane(Component component){
		JScrollPane scroll = new JScrollPane(component);
		scroll.getViewport().setBackground(WHITE);
		scroll.setBorder(null);
		return scroll;
	}
	
	/**
	 * Generiert einen table.
	 * @param TableModel model.
	 * @return Einen table.
	 */
	public final static JTable createTable(TableModel model){
		JTable table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		table.setFont(FONT);
		table.setBackground(WHITE);
		table.setRowHeight(30);
		table.setBorder(null);
		header.setBackground(BLUE);
		header.setForeground(WHITE);
		header.setFont(FONT);
		return table;
	}
	
	/**
	 * Double to CHF .
	 * @param Double value.
	 * @return Franken.
	 */
	public final static String DoubletoCHF(Double value){
		return String.format("%.2f", value) + " CHF";
	}
}
