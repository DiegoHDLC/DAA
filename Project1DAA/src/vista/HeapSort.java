package vista;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HeapSort extends JPanel{
	 public HeapSort() {
		   setBackground(new Color(235,137,4));//color medio naranjo
	 }
	 public void paintComponent(Graphics g) {
		 int posicionX = 20;
	     super.paintComponent(g);
	     for(int i=0; i<Princ.TAMANOARREGLO; i++) {
	    	 g.setColor(new Color(38,121,255));
	    	 g.drawRect(posicionX, 315, 30, 30);
	    	 posicionX = posicionX + 30;
	     }
	 }
}


