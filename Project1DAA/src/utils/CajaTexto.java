package utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CajaTexto extends JTextField {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CajaTexto(int x, int y, int largo, int ancho) {
		setText("");
		setHorizontalAlignment(SwingConstants.CENTER);
		setBackground(new Color(208, 121, 3));
		setFont(new Font("Calibri", 3, 19));
		setBounds(x, y, largo, ancho);
		setColumns(10);
	}
}
