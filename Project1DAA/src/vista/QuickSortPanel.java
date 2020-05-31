package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import procesos.Animaciones;
import procesos.Proceso;
import utils.Boton;
import utils.CajaTexto;
import utils.Label;

public class QuickSortPanel extends JLayeredPane {

	public static int n;
	public static ArrayList<JLabel> listaNumericaUsuario = new ArrayList<JLabel>();
	public static ArrayList<JLabel> numerosArreglo = new ArrayList<JLabel>();
	static ArrayList<JLabel> listaNumericaJLabel = new ArrayList<JLabel>();
	public static ArrayList<Integer> listaNumerica = new ArrayList<Integer>();
	public static ArrayList<JLabel> listTmp = new ArrayList<JLabel>();
	public static CajaTexto txtRuta = new CajaTexto(264, 11, 156, 35);
	static CajaTexto txtNum = new CajaTexto(10, 11, 46, 35);
	public static int contadorNumeros;
	public static int TAMANOARREGLO = 11;
	public static int numeroArchivo = 0;
	public static QuickSortPanel qk = new QuickSortPanel();
	public static ArrayList<JLabel> tmpsArreglo = new ArrayList<JLabel>();
	
	static Boton botonAgregar = new Boton("Agregar",66,17);
	static Boton botonEliminar = new Boton("Eliminar", 165, 17);
	private static final long serialVersionUID = 1L;

	public QuickSortPanel() {
		setBackground(new Color(235,137,4));
		setOpaque(true);
		initComponents();
	}
	public void initComponents() {
		
		/*botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creaNumeros();
			}
		});
		add(botonAgregar);*/
		
		JButton btnAgregarArchivo = new JButton("Agregar desde Archivo");
		btnAgregarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listaNumerica.size()>0) {
					Princ.txtMensaje.setText("Primero elimine todos los números");
				}else {
					//eliminarListaCompleta();
					JFileChooser jf = new JFileChooser();
					jf.showOpenDialog(qk);
					File archivo = jf.getSelectedFile();
					if(archivo != null) {
						txtRuta.setText(archivo.getAbsolutePath());
						Proceso.leerArchivo(archivo.getAbsolutePath());
					}
					iniciarNumeros(1);
					new Thread() {
						public void run() {
							int i=0;
							while(!Thread.currentThread().isInterrupted() && i<11){
							agregarYMover(1,i);
							i++;
							Proceso.dormir(100);
							}
						}
					}.start();	
					txtNum.setEditable(false);
					botonAgregar.setEnabled(false);
				}
				
			}
			
				
			
		});
		btnAgregarArchivo.setBounds(388, 18, 143, 23);
		add(btnAgregarArchivo);
		txtRuta.setBounds(165, 11, 213, 35);
		add(txtRuta);
		
		Boton ordenarQuick = new Boton("Ordenar", 264,18);
		ordenarQuick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Animaciones.animacionQuickSort( listaNumericaJLabel,listaNumerica, listTmp);
				//Ordenamientos.quickSort(listaNumerica, 0, listaNumerica.size()-1);
				Princ.imprimirListaNumerica(listaNumerica);
			}
		});
		add(ordenarQuick,0);
		
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(listaNumericaJLabel.get(contadorNumeros));
				repaint();
				eliminar();
				
			}
		});
		add(botonEliminar,0);
		add(txtNum,0);
		
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
	
	public static void agregarYMover(int lugarLectura, int posNumero) {
		if(lugarLectura == 0) {
			Princ.listaNumericaUsuario.get(Princ.contadorNumeros).setBounds(20, 50, 46, 14);
			qk.add(Princ.listaNumericaUsuario.get(Princ.contadorNumeros),new Integer(1));
			new Thread() {
				public void run() {
					int y1 = Princ.listaNumericaUsuario.get(Princ.contadorNumeros).getLocation().y;
					int x1 = Princ.listaNumericaUsuario.get(Princ.contadorNumeros).getLocation().x;
					int pos = verificarPos();
					colocarNumeroEnArreglo(x1,y1,pos,Princ.listaNumericaUsuario.get(Princ.contadorNumeros),tmpsArreglo);
				}
			}.start();
		}else {
			System.out.println("posicion del arreglo: "+posNumero);
			//imprimirListaNumericaDeLabels(listaNumericaUsuario);
			Princ.listaNumericaUsuario.get(posNumero).setBounds(20, 50, 46, 14);
			qk.add(Princ.listaNumericaUsuario.get(posNumero),new Integer(1));
			new Thread() {
				public void run() {
					while(!Thread.currentThread().isInterrupted()) {
					int y1 = Princ.listaNumericaUsuario.get(posNumero).getLocation().y;
					int x1 = Princ.listaNumericaUsuario.get(posNumero).getLocation().x;
					//int pos = verificarPos();
					colocarNumeroEnArreglo(x1,y1,posNumero+1,Princ.listaNumericaUsuario.get(posNumero),tmpsArreglo);
					}
				}
			}.start();
		}
		
	}
	
	public static int leerNumeroArchivo() {
		int n;
		n = Proceso.lista.get(numeroArchivo);
		numeroArchivo++;
		return n;
		
	}
	
	public static int leerNumeroCajaTexto() {
		int n;
		n = Integer.parseInt(txtNum.getText());
		return n;
	}
	
public static void colocarNumeroEnArreglo(int x, int y, int posObjetivo, JLabel numero, List<JLabel> listTmp) {
		
		System.out.println("El estado del hilo al empezar: "+ Thread.currentThread().isInterrupted());
		System.out.println("tmp coordenada Y: "+ listTmp.get(1).getY());
		while(!Thread.currentThread().isInterrupted()) {
			if(x<=40*posObjetivo) {
				x++;
				numero.setLocation(x, y);
					if(x==40*posObjetivo) {
						while(y<listTmp.get(1).getY()+20) {
							y++;
							numero.setLocation(x, y);
							if(y == listTmp.get(1).getY()+20) {
								Thread.currentThread().interrupt();
							}
							Proceso.dormir(3);
						}
					}
			}
			Proceso.dormir(3);
		}
		System.out.println("El estado del hilo al terminar: "+ Thread.currentThread().isInterrupted());
	}
	
	public static void iniciarNumeros(int lugarLectura) {
		int n;
		
		if(lugarLectura == 0) {
			n = leerNumeroCajaTexto();
			txtNum.setText(null);
			agregarNumero(n);
			
		}else {
				for(int i = 0; i< 11; i++) {
					n = leerNumeroArchivo();
					contadorNumeros++;
					agregarNumero(n);
				}
		}

		System.out.println(""+listaNumerica);
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

