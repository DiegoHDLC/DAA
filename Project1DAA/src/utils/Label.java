package utils;

import java.awt.Font;

import javax.swing.JLabel;;

public class Label extends JLabel{
	public Label(String texto, int pos, int y) {
		setText(texto);
		setFont(new Font("Calibri", 3, 19));
		setBounds(39+(40*pos), y, 30, 14);
	}
}
