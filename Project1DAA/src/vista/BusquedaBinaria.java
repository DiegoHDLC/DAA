package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.bind.ParseConversionEvent;

import procesos.Animaciones;
import procesos.Ordenamientos;
import procesos.Proceso;
import utils.CajaTexto;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BusquedaBinaria extends JLayeredPane{
	private static CajaTexto txtRuta = new CajaTexto(165, 11, 156, 35);
	static JLayeredPane panel = new JLayeredPane();
	public static CajaTexto txtNum = new CajaTexto(10, 11, 46, 35);
	//public static CajaTexto txtRuta = new CajaTexto(264, 11, 156, 35);
	public static int numeroArchivo = 0;
	static int contadorCasillas;
	public static ArrayList<JLabel> listaNumericaUsuario = new ArrayList<JLabel>();
	public static ArrayList<Integer> listaNumerica = new ArrayList<Integer>();
	//public static JTextField txtNum = new JTextField();
	volatile static boolean ejecutar = true;
	public static int contadorNumeros = -1;
	public static CajaTexto txtMensaje = new CajaTexto(0, 0, 984, 46);
	public static JButton btnAgregar = new JButton("Agregar");
	public static JButton btnEliminar = new JButton("Eliminar");
	public static ArrayList<JLabel> numerosArreglo = new ArrayList<JLabel>();
	public static int n;
	public static int TAMANOARREGLO = 11;
	public static ArrayList<JLabel> tmpsArreglo = new ArrayList<JLabel>();
	public static List<JLabel> listCuadrados;
	private final utils.Label tmpEjec = new utils.Label("Tiempo de Ejecuccion", 586, 22, 109, 14);
	private JTextField txtTamano;
	private final JButton btnCrearListRandom = new JButton("Crear lista random");
	
	
	
	 public BusquedaBinaria() {
		   setBackground(new Color(235,137,4));//color medio naranjo
		   setBounds(0, 132, 984, 429);
		   setLayout(null);
		   setOpaque(true);
		   initComponents();
		   try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	 }
	 
	 public void initComponents() {
		 JLayeredPane panel = new JLayeredPane();
		 	
		   
		   txtNum.setColumns(10);
		   btnEliminar.setEnabled(false);
		   btnEliminar.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		eliminarNumeros();
		   	}
		   });
		   btnEliminar.setBounds(66, 37, 89, 23);
		   add(btnEliminar);
		   
		   btnAgregar.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		if(txtNum.getText().isEmpty()) {
					Princ.txtMensaje.setText("Digite un número");
					txtNum.requestFocus();
				}else {
					btnEliminar.setEnabled(true);
					txtNum.requestFocus();
					Princ.txtMensaje.setText("");
					contadorNumeros++;
					if(listaNumerica.size()==10) {
						txtNum.setEditable(false);
						btnAgregar.setEnabled(false);
						Princ.txtMensaje.setText("Lista llena, no puede agregar más números.");
							
					}
					iniciarNumeros(0);
					System.out.println("lista label:");
					for(int i = 0; i < listaNumericaUsuario.size();i++) {
						System.out.print("[ "+listaNumericaUsuario.get(i).getText()+"], ");
					}
					
					System.out.println("\ncantidad de numeros label"+listaNumericaUsuario.size());
					agregarYMover(0,0);
				}
			
		   	}
		   });
		   btnAgregar.setBounds(67, 3, 88, 23);
		   add(btnAgregar);
		   
		   
		   add(txtNum);
		   add(txtRuta);
		   
		   JButton btnAgregarArchivo = new JButton("Agregar Archivo");
		   btnAgregarArchivo.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		if(listaNumerica.size()>0) {
					Princ.txtMensaje.setText("Primero elimine todos los números");
				}else {
					Princ.txtMensaje.setText("");
					eliminarListaCompleta();
					JFileChooser jf = new JFileChooser();
					jf.showOpenDialog(panel);
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
					btnEliminar.setEnabled(true);
					txtNum.setEditable(false);
					btnAgregar.setEnabled(false);
				}	
			}

		   	
		   });
		   
		   
		   btnAgregarArchivo.setBounds(388, 18, 143, 23);
		   add(btnAgregarArchivo);
		   
		   utils.Label lblTiempoEjec = new utils.Label("",811, 22, 70, 14);
		   lblTiempoEjec.setBounds(780, 22, 156, 14);
		   add(lblTiempoEjec);
		   JButton btnOrdenar = new JButton("Ordenar");
		   btnOrdenar.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		Animaciones.animacionHeapSort(listaNumericaUsuario, listaNumerica, tmpsArreglo);
		   	}
		   });
		   btnOrdenar.setBounds(446, 52, 89, 23);
		   add(btnOrdenar);
		   tmpEjec.setText("Tiempo de ejecucci\u00F3n: ");
		   tmpEjec.setBounds(586, 22, 184, 20);
		   
		   

		   
		   add(tmpEjec);
		   
		 
		   
		   JButton btnTiempo = new JButton("Calcular tiempo");
		   btnTiempo.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		long inicio = System.currentTimeMillis();
		   		Ordenamientos.heapSort(listaNumerica, listaNumericaUsuario, tmpsArreglo);
		   		long fin = System.currentTimeMillis();
		   		double tiempo = (double) ((fin - inicio)/*/1000*/);
		   		lblTiempoEjec.setText(""+tiempo+"[milisegundos]");
		   		imprimirListaNumerica(listaNumerica);
		   		
		   	}
		   });
		   btnTiempo.setBounds(446, 86, 143, 23);
		   add(btnTiempo);
		   
		   txtTamano = new JTextField();
		   txtTamano.setBounds(486, 136, 86, 20);
		   add(txtTamano);
		   txtTamano.setColumns(10);
		   
		   JButton btnOrdenarRandom = new JButton("OrdenarRandom");
		   btnOrdenarRandom.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		Princ.txtMensaje.setText("");
		   		long inicio = System.currentTimeMillis();
		   		Ordenamientos.heapSort(Proceso.lista, listaNumericaUsuario,tmpsArreglo);
		   		long fin = System.currentTimeMillis();
		   		double tiempo = (double) ((fin - inicio)/*/1000*/);
		   		lblTiempoEjec.setText(""+tiempo+"[milisegundos]");
		   		Princ.txtMensaje.setText("Ordenamiento completado");
		   	}
		   });
		   btnOrdenarRandom.setBounds(603, 135, 156, 23);
		   add(btnOrdenarRandom);
		   btnCrearListRandom.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		int tamanoLista = Integer.parseInt(txtTamano.getText());
		   		Proceso.crearListaRandom(tamanoLista);
		   	}
		   });
		   btnCrearListRandom.setBounds(599, 101, 160, 23);
		   
		   add(btnCrearListRandom);
		   
		   for(int i = 0;i < TAMANOARREGLO; i++){
				JLabel label = new JLabel();
				label.setText(""+i);
				label.setFont(new Font("Calibri", 3, 19));
				numerosArreglo.add(label);
				numerosArreglo.get(i).setBounds(39+(40*i), 175, 30, 14);
				add(numerosArreglo.get(i));
			}
		   
		   for(int i = 0;i < TAMANOARREGLO; i++){
				JLabel lblTmp = new JLabel();
				lblTmp.setText("");
				tmpsArreglo.add(lblTmp);
				tmpsArreglo.get(i).setFont(new Font("Calibri", 3, 19));
				tmpsArreglo.get(i).setBounds(39+(40*i), 130, 30, 14);
				add(tmpsArreglo.get(i));
			}
		   
		   int posX = 20;
			for(int i=0;i< 11;i++) {
				JLabel cuadrado = new JLabel();
				cuadrado.setIcon(new ImageIcon(Princ.class.getResource("/Image/cuadrado.png")));
				cuadrado.setBounds(40*i+ posX, 130, 50, 50);
				add(cuadrado);
			}
			
			setVisible(true);
		   
	 }
	 
		public static void eliminarNumeros() {
			txtNum.requestFocus();
			Princ.txtMensaje.setText("");
			Princ.heap.remove(listaNumericaUsuario.get(contadorNumeros));
			Princ.heap.repaint();
			listaNumerica.remove(contadorNumeros);
			listaNumericaUsuario.remove(contadorNumeros);
			System.out.println(""+listaNumerica);
			System.out.println("cantidad de numeros:"+listaNumerica.size());
			contadorNumeros--;
			btnAgregar.setEnabled(true);
			txtNum.setEditable(true);
			txtRuta.setText("");
			if(listaNumerica.size()==0) {
				btnAgregar.setEnabled(true);
				Princ.txtMensaje.setText("No hay número que eliminar");
				btnEliminar.setEnabled(false);
			}
		}
	 
	 public static void eliminarListaCompleta(){
			for(int i = listaNumericaUsuario.size()-1; i >= 0; i--) {
				Princ.heap.remove(listaNumericaUsuario.get(i));
				listaNumerica.remove(i);
				listaNumericaUsuario.remove(i);
				Proceso.lista.remove(i);
			}
			contadorNumeros= -1;
			numeroArchivo = 0;
			System.out.println("cantidad de Numeros del arreglo: "+ numerosArreglo.size());
			System.out.println("contadorNumeros: "+ contadorNumeros);
			txtNum.setEditable(true);
			btnAgregar.setEnabled(true);
			System.out.println(""+listaNumerica);
			Princ.heap.repaint();
		}
	 
	 public static void agregarYMover(int lugarLectura, int posNumero) {
		 	
			if(lugarLectura == 0) {
				listaNumericaUsuario.get(contadorNumeros).setBounds(20, 70, 46, 14);
				Princ.heap.add(listaNumericaUsuario.get(contadorNumeros),new Integer(3));
				new Thread() {
					public void run() {
						int y1 = listaNumericaUsuario.get(contadorNumeros).getLocation().y;
						int x1 = listaNumericaUsuario.get(contadorNumeros).getLocation().x;
						int pos = verificarPos();
						colocarNumeroEnArreglo(x1,y1,pos,listaNumericaUsuario.get(contadorNumeros),tmpsArreglo);
					}
				}.start();
			}else {
				
				System.out.println("posicion del arreglo: "+posNumero);
				//imprimirListaNumericaDeLabels(listaNumericaUsuario);
				listaNumericaUsuario.get(posNumero).setBounds(20, 50, 46, 14);
				Princ.heap.add(listaNumericaUsuario.get(posNumero),new Integer(1));
				new Thread() {
					public void run() {
						while(!Thread.currentThread().isInterrupted()) {
						int y1 = listaNumericaUsuario.get(posNumero).getLocation().y;
						int x1 = listaNumericaUsuario.get(posNumero).getLocation().x;
						//int pos = verificarPos();
						colocarNumeroEnArreglo(x1,y1,posNumero+1,listaNumericaUsuario.get(posNumero),tmpsArreglo);
						}
					}
				}.start();
			}
			
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
	
	public static synchronized void suspenderHilo() {
		Animaciones.suspender = true;
	}
	
	public static synchronized void reanudarHilo() {
		Animaciones.suspender = false;
		Thread.currentThread().notify();
	}
	
	public static void tiempoEjecucion() {
		
	}
	
	
	public static int leerNumeroArchivo() {
		int n;
		n = Proceso.lista.get(numeroArchivo);
		numeroArchivo++;
		return n;
		
	}
	public static Boolean verificarContenidoArreglo() {
		if(listaNumerica.size()>0) {
			return true;
		}else {
			btnEliminar.setEnabled(false);
			return false;
		}
	}
	
	public static int verificarPos() {
		int posicion = 0;
		for(int i = 0;i < listaNumerica.size();i++) {
			if(listaNumerica.get(i)==null);
				posicion = i;
		}
		return posicion+1;
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
							dormir(3);
						}
					}
			}
			dormir(3);
		}
		System.out.println("El estado del hilo al terminar: "+ Thread.currentThread().isInterrupted());
	}
	
	public static void dormir(int tiempoDormir) {
		try {
			Thread.sleep(tiempoDormir);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	public static void imprimirListaNumericaDeLabels(List<JLabel> a) {
		for(int i = 0; i < a.size(); i++) {
			System.out.print("["+a.get(i).getText()+"] ");
		}
		System.out.print("\n");
	}
	
	public static void agregarNumero(int n) {
		listaNumerica.add(n);
		JLabel numero = new JLabel();
		numero.setText(""+n);
		numero.setFont(new Font("Calibri", 3, 19));
		listaNumericaUsuario.add(numero);
		btnEliminar.setEnabled(true);
	}
	
	public static void imprimirListaNumerica(List<Integer> lista) {
		for(int i = 0; i < lista.size();i++) {
			System.out.print("["+lista.get(i)+"] ");
		}
		System.out.print("\n");
	}
	
	public static int leerNumeroCajaTexto() {
		int n;
		n = Integer.parseInt(txtNum.getText());
		return n;
	}
}
