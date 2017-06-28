/**
 * Zeichenet den rand für einen Button.
 * 
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */

package ch.gibm.gfjw.gui;

import java.awt.Color;
import java.awt.Insets;
import javax.swing.border.*;

public class RoundedBorder implements Border {

    private int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public boolean isBorderOpaque() {
        return true;
    }

	@Override
	public Insets getBorderInsets(java.awt.Component c) {
		return new Insets(this.radius/4, this.radius/4, this.radius/4, this.radius/4);
	}


	@Override
	public void paintBorder(java.awt.Component c, java.awt.Graphics g, int x, int y, int width, int height) {
		g.setColor(Color.lightGray);
		g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	}
}
