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
import javax.swing.border.Border;

public class Style {

	public static final Font FONT= new Font("Verdana", 0, 16);
	public static final Font FONTBOLD= new Font("Verdana", Font.BOLD, 20);
    public final static Border BORDER = new RoundedBorder(50);
    public final static Color BLUE = new Color(0,102,255);
    public final static Color GREEN = new Color(0,153,0);
    public final static Color RED = new Color(204,0,51);

	private final static JButton createButton(String name){
		JButton button = new JButton(name);
		button.setPreferredSize(new Dimension(150,50));
		button.setBackground(BLUE); 
		button.setBorder(BORDER);
		button.setFont(FONT);
		return button;	
	}
	
	public final static JButton createButton(JPanel addToPanel, Object constraints, ImageIcon image){
		JButton button = createButton(addToPanel, constraints, "");
		button.setIcon(image);
		return button;	
	}
	
	public final static JButton createButton(JPanel addToPanel, ImageIcon image){
		JButton button = createButton(addToPanel, "");
		button.setIcon(image);
		return button;	
	}
	
	public final static JButton createButton(JPanel addToPanel, Object constraints, String text){
		JButton button = createButton(text);
		addToPanel.add(button, constraints);
		return button;	
	}
	
	public final static JButton createButton(JPanel addToPanel, String text){
		JButton button = createButton(text);
		addToPanel.add(button);
		return button;	
	}
	
	public final static JLabel createLabel(int width, int height, String name){
		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(width, height));
		label.setFont(Style.FONTBOLD);
		label.setBackground(BLUE);
		label.setForeground(WHITE);
		label.setOpaque(true); 
		return label;
	}
	
	public final static JLabel createLabel(int width, int height){
		JLabel label = createLabel(width, height, ""); 
		return label;
	}
	
	public final static JPanel createJPanel(BorderLayout layout){
		JPanel panel = createJPanel();
		panel.setLayout(layout);
		return panel;
	}
	
	public final static JPanel createJPanel(GridLayout layout){
		JPanel panel = createJPanel();
		panel.setLayout(layout);
		return panel;
	}
	
	public final static JPanel createJPanel(CardLayout layout){
		JPanel panel = createJPanel();
		panel.setLayout(layout);
		return panel;
	}

	private final static JPanel createJPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(WHITE);
		return panel;
	}
}
