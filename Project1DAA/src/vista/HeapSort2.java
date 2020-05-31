/*package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import procesos.Animaciones;
import procesos.Proceso;
import utils.CajaTexto;

@SuppressWarnings("serial")
public class HeapSort2 extends JLayeredPane{
	public static CajaTexto txtNum = new CajaTexto(10, 11, 46, 35);
	public static CajaTexto txtRuta = new CajaTexto(264, 11, 156, 35);
	public static HeapSort2 venHeapSort = new HeapSort2();
	public static int numeroArchivo = 0;
	static int contadorCasillas;
	
	public static ArrayList<Integer> listaNumerica = new ArrayList<Integer>();
	//public static JTextField txtNum = new JTextField();
	volatile static boolean ejecutar = true;
	
	public static HeapSort2 heap = new HeapSort2();
	
	public static JButton btnAgregar = new JButton("Agregar");
	public static JButton btnEliminar = new JButton("Eliminar");
	public static ArrayList<JLabel> numerosArreglo = new ArrayList<JLabel>();
	public static int n;
	public static int TAMANOARREGLO = 11;
	public static ArrayList<JLabel> tmpsArreglo = new ArrayList<JLabel>();
	public static List<JLabel> listCuadrados;
	
	 public HeapSort2() {
		   setBackground(new Color(235,137,4));//color medio naranjo
		   setOpaque(true);
		   initComponents();
	 }
	 
	 public void initComponents() {
		 add(txtNum);
		 add(txtRuta);
		 
		 btnAgregar.setBounds(66, 17, 89, 23);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(HeapSort2.txtNum.getText().isEmpty()) {
						Princ.txtMensaje.setText("Digite un número");
						HeapSort2.txtNum.requestFocus();
					}else {
						HeapSort2.txtNum.requestFocus();
						Princ.txtMensaje.setText("");
						Princ.contadorNumeros++;
						if(listaNumerica.size()==10) {
							HeapSort2.txtNum.setEditable(false);
							btnAgregar.setEnabled(false);
							Princ.txtMensaje.setText("Lista llena, no puede agregar más números.");
								
						}
						iniciarNumeros(0);
						System.out.println("lista label:");
						for(int i = 0; i < Princ.listaNumericaUsuario.size();i++) {
							System.out.print("[ "+Princ.listaNumericaUsuario.get(i).getText()+"], ");
						}
						
						System.out.println("\ncantidad de numeros label"+Princ.listaNumericaUsuario.size());
						//System.out.println("numero final:"+listaNumericaUsuario.get(contadorNumeros).getText());
						//System.out.println("posicion:"+contadorNumeros);
						agregarYMover(0,0);
					}
				}
			});
			add(btnAgregar);
			
		//BOTON ELIMINAR
			btnEliminar.setEnabled(false);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Proceso.eliminarNumeros();
				}
			});
			btnEliminar.setBounds(165, 18, 89, 23);
			add(btnEliminar);
			
		 JButton btnIntercambio = new JButton("Intercambio");
			btnIntercambio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Animaciones.animacionHeapSort(Princ.listaNumericaUsuario, listaNumerica, tmpsArreglo);
				}
			});
			btnIntercambio.setBounds(735, 52, 89, 23);
			heap.add(btnIntercambio);
		 
		 JButton btnPausar = new JButton("Pausar");
			btnPausar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Princ.pausarHilo();
				}
			});
			btnPausar.setBounds(636, 84, 89, 23);
			add(btnPausar);
			
		 JButton btnReanudar = new JButton("Reanudar");
			btnReanudar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Princ.pausarHilo();
				}
			});
			btnReanudar.setBounds(636, 52, 89, 23);
			add(btnReanudar);
			
		 JButton btnEliminarTodo = new JButton("Eliminar Todo");
			btnEliminarTodo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser jf = new JFileChooser();
					jf.showOpenDialog(venHeapSort);
					File archivo = jf.getSelectedFile();
					if(archivo != null) {
						txtRuta.setText(archivo.getAbsolutePath());
					}
				}
			});
			btnEliminarTodo.setBounds(636, 18, 124, 23);
			HeapSort2.venHeapSort.add(btnEliminarTodo);
		 
		 for(int i = 0;i < TAMANOARREGLO; i++){
				JLabel label = new JLabel();
				label.setText(""+i);
				label.setFont(new Font("Calibri", 3, 19));
				numerosArreglo.add(label);
				numerosArreglo.get(i).setBounds(39+(40*i), 175, 30, 14);
				heap.add(numerosArreglo.get(i));
			}
			
			for(int i = 0;i < TAMANOARREGLO; i++){
				JLabel lblTmp = new JLabel();
				lblTmp.setText("");
				tmpsArreglo.add(lblTmp);
				tmpsArreglo.get(i).setFont(new Font("Calibri", 3, 19));
				tmpsArreglo.get(i).setBounds(39+(40*i), 130, 30, 14);
				heap.add(tmpsArreglo.get(i));
			}
			
		 int posX = 20;
			for(int i=0;i< 11;i++) {
				JLabel cuadrado = new JLabel();
				cuadrado.setIcon(new ImageIcon(Princ.class.getResource("/Image/cuadrado.png")));
				cuadrado.setBounds(40*i+ posX, 130, 50, 50);
				heap.add(cuadrado);
			}
		 
		 JButton btnAgregarArchivo = new JButton("Agregar desde Archivo");
			btnAgregarArchivo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					eliminarListaCompleta();
					JFileChooser jf = new JFileChooser();
					jf.showOpenDialog(venHeapSort);
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
					
				}
			});
			btnAgregarArchivo.setBounds(430, 18, 143, 23);
			add(btnAgregarArchivo);
			
			
	 }
	 
	 public static void eliminarListaCompleta(){
			for(int i = Princ.listaNumericaUsuario.size()-1; i >= 0; i--) {
				heap.remove(Princ.listaNumericaUsuario.get(i));
				listaNumerica.remove(i);
				Princ.listaNumericaUsuario.remove(i);
				Proceso.lista.remove(i);
				//contadorNumeros--;
			}
			Princ.contadorNumeros= -1;
			numeroArchivo = 0;
			System.out.println("cantidad de Numeros del arreglo: "+ numerosArreglo.size());
			System.out.println("contadorNumeros: "+ Princ.contadorNumeros);
			HeapSort2.txtNum.setEditable(true);
			btnAgregar.setEnabled(true);
			System.out.println(""+listaNumerica);
			venHeapSort.repaint();
		}
	 
	 public static void iniciarNumeros(int lugarLectura) {
			int n;
			
			if(lugarLectura == 0) {
				n = leerNumeroCajaTexto();
				HeapSort2.txtNum.setText(null);
				agregarNumero(n);
				
			}else {
				
				
					for(int i = 0; i< 11; i++) {
						n = leerNumeroArchivo();
						agregarNumero(n);
					}
				
			}
		
				
			System.out.println(""+listaNumerica);
		}
	 
	 public static void agregarNumero(int n) {
			listaNumerica.add(n);
			JLabel numero = new JLabel();
			numero.setText(""+n);
			numero.setFont(new Font("Calibri", 3, 19));
			Princ.listaNumericaUsuario.add(numero);
			btnEliminar.setEnabled(true);
		}
	 
	 public static int leerNumeroCajaTexto() {
			int n;
			n = Integer.parseInt(HeapSort2.txtNum.getText());
			return n;
		}
	 
	 public static void colocarNumeroEnArreglo(int x, int y, int posObjetivo, JLabel numero, List<JLabel> listTmp) {
			
			System.out.println("El estado del hilo al empezar: "+ Thread.currentThread().isInterrupted());
			System.out.println("tmp coordenada Y: "+ listTmp.get(1).getY());
			Proceso.imprimirListaNumericaDeLabels(Princ.listaNumericaUsuario);
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
	 
	 public static int verificarPos() {
			int posicion = 0;
			for(int i = 0;i < listaNumerica.size();i++) {
				if(listaNumerica.get(i)==null);
					posicion = i;
			}
			return posicion+1;
		}
	 
	 public static Boolean verificarContenidoArreglo() {
			if(listaNumerica.size()>0) {
				return true;
			}else {
				btnEliminar.setEnabled(false);
				return false;
			}
		}
	 
	 public static int leerNumeroArchivo() {
			int n;
			
			n = Proceso.lista.get(numeroArchivo);
			numeroArchivo++;
			System.out.println("numeroArchivo:"+numeroArchivo);
			return n;
			
		}
	 
	 public static void agregarYMover(int lugarLectura, int posNumero) {
			if(lugarLectura == 0) {
				Princ.listaNumericaUsuario.get(Princ.contadorNumeros).setBounds(20, 50, 46, 14);
				heap.add(Princ.listaNumericaUsuario.get(Princ.contadorNumeros),new Integer(1));
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
				heap.add(Princ.listaNumericaUsuario.get(posNumero),new Integer(1));
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
	 
}

*/
