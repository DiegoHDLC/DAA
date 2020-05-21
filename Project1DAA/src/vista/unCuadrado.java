package vista;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class unCuadrado extends JPanel{
	 public unCuadrado() {
		   setBackground(new Color(235,137,4));//color medio naranjo
	   }
		public void paintComponent(Graphics g) {
			int posicionX = 40;
	        super.paintComponent(g);
	        for(int i=0; i<10; i++) {
	        	g.setColor(new Color(38,121,255));
	        	g.drawRect(posicionX, 300, 50, 50);
	        	posicionX = posicionX + 50;
	        	
	        }
	    }
}

