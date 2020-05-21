package vista;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MergeSort extends JPanel{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MergeSort() {
		setBackground(new Color(235,137,4));
	}
	public void paintComponent(Graphics g) {
		 int posicionX = 20;
	     super.paintComponent(g);
	     for(int i=0; i<10; i++) {
	    	 g.setColor(new Color(38,121,255));
	    	 g.drawRect(posicionX, 315, 30, 30);
	    	 posicionX = posicionX + 30;
	     }
	 }
}
