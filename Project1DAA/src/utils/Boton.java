package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.HeapSort;
import vista.Princ;

public class Boton extends JButton{
	/**
	 * 
	 */
	public static int contadorNumeros = -1;
	private static final long serialVersionUID = 1L;
	
	public Boton(String texto, int x, int y) {
		setText(texto);
		setBounds(x, y, 89, 23);
	}
	

	public void AgregarNumeros() {
		
	}
}
