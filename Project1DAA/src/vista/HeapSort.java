package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class HeapSort extends JLayeredPane{
	private JTextField txtNum;
	private JTextField txtRuta;
	 public HeapSort() {
		   setBackground(new Color(235,137,4));//color medio naranjo
		   setBounds(0, 132, 984, 429);
		   setLayout(null);
		   setOpaque(true);
		   initComponents();
		   
	 }
	 
	 public void initComponents() {
		 txtNum = new JTextField();
		   txtNum.setBounds(10, 11, 86, 20);
		   add(txtNum);
		   txtNum.setColumns(10);
		   
		   JButton btnAgregar = new JButton("Agregar");
		   btnAgregar.setBounds(106, 10, 89, 23);
		   add(btnAgregar);
		   
		   JButton btnEliminar = new JButton("Eliminar");
		   btnEliminar.setBounds(106, 45, 89, 23);
		   add(btnEliminar);
		   
		   txtRuta = new JTextField();
		   txtRuta.setBounds(227, 11, 166, 20);
		   add(txtRuta);
		   txtRuta.setColumns(10);
		   
		   JButton btnAgregarArchivo = new JButton("Agregar Archivo");
		   btnAgregarArchivo.setBounds(403, 10, 89, 23);
		   add(btnAgregarArchivo);
		   
		   JButton btnOrdenar = new JButton("Ordenar");
		   btnOrdenar.setBounds(502, 10, 89, 23);
		   add(btnOrdenar);
		   
	 }
	 
}
