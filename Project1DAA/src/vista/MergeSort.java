package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import procesos.Animaciones;
import utils.Boton;
import utils.CajaTexto;
import utils.Label;

public class MergeSort extends JLayeredPane{ 
	/**
	 * 
	 */
	public static int n;
	public static ArrayList<JLabel> numerosArreglo = new ArrayList<JLabel>();
	static ArrayList<JLabel> listaNumericaJLabel = new ArrayList<JLabel>();
	public static ArrayList<Integer> listaNumerica = new ArrayList<Integer>();
	public static ArrayList<JLabel> listTmp = new ArrayList<JLabel>();
	static CajaTexto txtNum = new CajaTexto();
	public static int contadorNumeros;
	public static int TAMANOARREGLO = 11;
	
	static Boton botonAgregar = new Boton("Agregar",66,17);
	static Boton botonEliminar = new Boton("Eliminar", 165, 17);
	private static final long serialVersionUID = 1L;

	public MergeSort() {
		setBackground(new Color(235,137,4));
		setOpaque(true);
		initComponents();
	}
	public void initComponents() {
		
		botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creaNumeros();
			}
		});
		add(botonAgregar);
		
		Boton ordenarMerge = new Boton("Ordenar", 264,18);
		ordenarMerge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		add(ordenarMerge);
		
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(listaNumericaJLabel.get(contadorNumeros));
				repaint();
				eliminar();
				
			}
		});
		add(botonEliminar);
		add(txtNum);
		
		int posX = 20;
		for(int i=0;i< 11;i++) {
			JLabel cuadrado = new JLabel();
			cuadrado.setIcon(new ImageIcon(Princ.class.getResource("/Image/cuadrado.png")));
			cuadrado.setBounds(40*i+ posX, 130, 50, 50);
			add(cuadrado);
		}
		
		for(int i = 0;i < TAMANOARREGLO; i++){
			Label lblTmp = new Label("", i,130);
			listTmp.add(lblTmp);
			add(listTmp.get(i));
		}
		
		for(int i = 0;i < TAMANOARREGLO; i++){
			Label label = new Label(""+i,i,175);
			numerosArreglo.add(label);
			add(numerosArreglo.get(i));
		}
		contadorNumeros = -1;
	 }
	
	public void creaNumeros() {
		if(txtNum.getText().isEmpty()) {
			txtNumVacio();
		}else {
			txtNum.requestFocus();
			Princ.txtMensaje.setText("");
			contadorNumeros++;
			verSiEstallena();
			n = iniciarNumeros();
			//POSICION DONDE EMPIEZAN TODOS LOS NUMEROS CREADOS
			listaNumericaJLabel.get(contadorNumeros).setBounds(20, 50, 46, 14);
			add(listaNumericaJLabel.get(contadorNumeros),new Integer(1));
			
			new Thread() {
				public void run() {
					int y1 = listaNumericaJLabel.get(contadorNumeros).getLocation().y;
					int x1 = listaNumericaJLabel.get(contadorNumeros).getLocation().x;
					int pos = verificarPos();
					Animaciones.colocarNumeroEnArreglo(x1,y1,pos,listaNumericaJLabel.get(contadorNumeros),listTmp);
				}
			}.start();
		}
	}
	
	public static void eliminar() {
		txtNum.requestFocus();
		Princ.txtMensaje.setText("");
		
		listaNumerica.remove(contadorNumeros);
		listaNumericaJLabel.remove(contadorNumeros);
		System.out.println(""+listaNumerica);
		System.out.println("cantidad de numeros:"+listaNumerica.size());
		contadorNumeros--;
		botonAgregar.setEnabled(true);
		txtNum.setEditable(true);
		if(listaNumerica.size()==0) {
			Princ.txtMensaje.setText("No hay número que eliminar");
			botonEliminar.setEnabled(false);
		}	
	}
	
	public static void txtNumVacio() {
		Princ.txtMensaje.setText("Digite un número");
		txtNum.requestFocus();
	}
	
	public static void verSiEstallena() {
		if(listaNumerica.size()==numerosArreglo.size()-1) {
			txtNum.setEditable(false);
			botonAgregar.setEnabled(false);
			Princ.txtMensaje.setText("Lista llena, no puede agregar más números.");
		}
	}
	
	public static int iniciarNumeros() {
		int n = moverNumero();
		txtNum.setText(null);
		agregarNumero(n);
		System.out.println(""+listaNumerica);
		return n;
	}
	
	public static int verificarPos() {
		int posicion = 0;
		for(int i = 0;i < listaNumerica.size();i++) {
			if(listaNumerica.get(i)==null);
				posicion = i;
		}
		return posicion+1;
	}
	
	public static void agregarNumero(int n) {
		listaNumerica.add(n);
		JLabel numero = new JLabel();
		numero.setText(""+n);
		numero.setFont(new Font("Calibri", 3, 19));
		listaNumericaJLabel.add(numero);
		botonEliminar.setEnabled(true);
	}
	
	public static int moverNumero() {
		int n;
		n = Integer.parseInt(txtNum.getText());
    	return n;
	}
}
