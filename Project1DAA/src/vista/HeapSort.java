package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HeapSort extends JPanel{
	 public HeapSort() {
		   setBackground(new Color(235,137,4));//color medio naranjo
	 }
	 
	 public void agregarCuadrados() {
		 List<JLabel> listCuadrados;
		 JLabel cuadrado = new JLabel();
		 //cuadrado.setIcon(icon);
		 for(int i = 0; i< 10; i++) {
			 
			 
		 }
	 }
	 public void paintComponent(Graphics2D g) {
		 //Stroke oldStroke = g.getStroke();
		// g.setStroke(new BasicStroke(100));
		 
		 int posicionX = 20;
	     super.paintComponent(g);
	     for(int i=0; i<Princ.TAMANOARREGLO; i++) {
	    	 g.setColor(new Color(38,121,255));
	    	 g.drawRect(posicionX, 215, 30, 30);
	    	 posicionX = posicionX + 30;
	    	 
	    	 
	    	 
	     }
	 }
}


