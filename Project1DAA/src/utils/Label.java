package utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;;

public class Label extends JLabel{
	public Label(String texto, int pos, int y) {
		setText(texto);
		setFont(new Font("Calibri", 3, 19));
		setBounds(39+(40*pos), y, 30, 14);
	}
	public Label(String texto, int x, int y, int largo,int ancho) {
		setText(texto);
		setHorizontalAlignment(SwingConstants.CENTER);
		setBounds(x,y,largo,ancho);
		setForeground(new Color(33, 44, 61));
		setFont(new Font("Sitka Small", Font.BOLD, 15));
	}
}
