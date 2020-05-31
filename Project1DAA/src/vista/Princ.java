package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import procesos.Animaciones;
import procesos.Ordenamientos;
import procesos.Proceso;
import utils.Boton;
import utils.CajaTexto;

import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Princ {
	/*public static CajaTexto txtNum = new CajaTexto(10, 11, 46, 35);
	//public static CajaTexto txtRuta = new CajaTexto(264, 11, 156, 35);
	public static int numeroArchivo = 0;
	static int contadorCasillas;
	public static ArrayList<JLabel> listaNumericaUsuario = new ArrayList<JLabel>();
	public static ArrayList<Integer> listaNumerica = new ArrayList<Integer>();
	//public static JTextField txtNum = new JTextField();
	volatile static boolean ejecutar = true;
	public static int contadorNumeros = -1;
	
	
	public static JButton btnAgregar = new JButton("Agregar");
	public static JButton btnEliminar = new JButton("Eliminar");
	public static ArrayList<JLabel> numerosArreglo = new ArrayList<JLabel>();
	public static int n;
	public static int TAMANOARREGLO = 11;
	public static ArrayList<JLabel> tmpsArreglo = new ArrayList<JLabel>();
	public static List<JLabel> listCuadrados;*/
	public static CajaTexto txtMensaje = new CajaTexto(0, 0, 984, 46);
	public static HeapSort heap = new HeapSort();
	public static QuickSort qk = new QuickSort();
	public static BubbleSort bubble = new BubbleSort();
	public static JFrame ventana = new JFrame();
	public static void main(String[] args) {
		initComponents();
		//Proceso.crearListaCero();
	}
	
	@SuppressWarnings("deprecation")
	public static void initComponents() {
		
		
		heap.setVisible(true);
		heap.setLayout(null);
		ventana.getContentPane().setLayout(null);
		ventana.setBackground(new Color(235,137,4));
		ventana.getContentPane().add(heap);
		heap.setVisible(true);
		heap.setLayout(null);
		ventana.getContentPane().add(qk);
		qk.setVisible(false);
		qk.setLayout(null);
		ventana.getContentPane().add(bubble);
		bubble.setVisible(false);
		bubble.setLayout(null);
		
		//crear Panel HeapSort
		
		//ventana.getContentPane().add(heap);
		
		/*txtNum.setText("");
		txtNum.setHorizontalAlignment(SwingConstants.CENTER);
		txtNum.setBackground(new Color(208, 121, 3));
		txtNum.setFont(new Font("Calibri", 3, 19));
		txtNum.setBounds(10, 11, 46, 35);
		heap.add(txtNum);
		txtNum.setColumns(10);*/
		
		/*btnAgregar.setBounds(67, 3, 88, 23);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNum.getText().isEmpty()) {
					txtMensaje.setText("Digite un número");
					txtNum.requestFocus();
				}else {
					txtNum.requestFocus();
					txtMensaje.setText("");
					contadorNumeros++;
					if(listaNumerica.size()==10) {
						txtNum.setEditable(false);
						btnAgregar.setEnabled(false);
						txtMensaje.setText("Lista llena, no puede agregar más números.");
							
					}
					iniciarNumeros(0);
					System.out.println("lista label:");
					for(int i = 0; i < Princ.listaNumericaUsuario.size();i++) {
						System.out.print("[ "+Princ.listaNumericaUsuario.get(i).getText()+"], ");
					}
					
					System.out.println("\ncantidad de numeros label"+Princ.listaNumericaUsuario.size());
					agregarYMover(0,0);
				}
			}
		});
		heap.add(btnAgregar);*/
		
		//BOTON ELIMINAR
		/*btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarNumeros();
			}
		});
		btnEliminar.setBounds(66, 37, 89, 23);
		heap.add(btnEliminar);*/
		
		/*JButton btnIntercambio = new JButton("Intercambio");
		btnIntercambio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Animaciones.animacionHeapSort(listaNumericaUsuario, listaNumerica, tmpsArreglo);
			}
		});
		btnIntercambio.setBounds(446, 52, 89, 23);
		heap.add(btnIntercambio);*/
		
		/*JButton btnEliminarTodo = new JButton("Eliminar Todo");
		btnEliminarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jf = new JFileChooser();
				jf.showOpenDialog(ventana);
				File archivo = jf.getSelectedFile();
				if(archivo != null) {
					txtRuta.setText(archivo.getAbsolutePath());
				}
			}
		});
		btnEliminarTodo.setBounds(541, 18, 124, 23);
		heap.add(btnEliminarTodo);*/
		
		/*JButton btnAgregarArchivo = new JButton("Agregar desde Archivo");
		btnAgregarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listaNumerica.size()>0) {
					txtMensaje.setText("Primero elimine todos los números");
				}else {
					//eliminarListaCompleta();
					JFileChooser jf = new JFileChooser();
					jf.showOpenDialog(ventana);
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
					btnAgregar.setEnabled(false);
				}	
			}

			
		});
		btnAgregarArchivo.setBounds(388, 18, 143, 23);
		heap.add(btnAgregarArchivo);
		txtRuta.setBounds(165, 11, 213, 35);
		heap.add(txtRuta);*/
		
		JPanel PanelControl = new JPanel();
		PanelControl.setBackground(new Color(218, 165, 32));
		PanelControl.setBounds(0, 0, 984, 87);
		ventana.getContentPane().add(PanelControl);
		PanelControl.setLayout(null);
		
		//crear pestaña MergeSort
		
		JPanel pestBubble = new JPanel();
		pestBubble.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pestBubble.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(qk.isVisible()==false) {
					pestBubble.setBackground(new Color(197, 152, 20));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(heap.isVisible() == false) {
					pestHeap.setBackground(new Color(232, 182, 23));
					pestBubble.setBackground(new Color(230, 187, 79));
				}else {
					pestBubble.setBackground(new Color(232, 182, 23));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(heap.isVisible() == true) {
					pestHeap.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestBubble.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					pestBubble.setBackground(new Color(230, 187, 79));
					pestHeap.setBackground(new Color(232, 182, 23));
					qk.setVisible(true);
					heap.setVisible(false);
					System.out.println("el panel heap es visible? "+heap.isVisible());
				}
			}
		});
		pestBubble.setBackground(new Color(232, 182, 23));
		pestBubble.setBounds(226, 0, 103, 32);
		PanelControl.add(pestBubble);
		pestBubble.setLayout(null);
		
		JPanel pestQuick = new JPanel();
		pestQuick.setBounds(103, 0, 103, 32);
		pestQuick.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pestQuick.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(qk.isVisible()==false) {
					pestQuick.setBackground(new Color(197, 152, 20));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(heap.isVisible() == false) {
					pestHeap.setBackground(new Color(232, 182, 23));
					pestQuick.setBackground(new Color(230, 187, 79));
				}else {
					pestQuick.setBackground(new Color(232, 182, 23));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(heap.isVisible() == true) {
					pestHeap.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestQuick.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					pestQuick.setBackground(new Color(230, 187, 79));
					pestHeap.setBackground(new Color(232, 182, 23));
					qk.setVisible(true);
					heap.setVisible(false);
					System.out.println("el panel heap es visible? "+heap.isVisible());
				}
			}
		});
		pestQuick.setBackground(new Color(232, 182, 23));
		pestQuick.setBounds(113, 0, 103, 32);
		PanelControl.add(pestQuick);
		pestQuick.setLayout(null);
		
		JLabel lblBubbleSort = new JLabel("BubbleSort");
		lblBubbleSort.setHorizontalAlignment(SwingConstants.CENTER);
		lblBubbleSort.setForeground(new Color(33, 44, 61));
		lblBubbleSort.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblBubbleSort.setBounds(0, 0, 103, 32);
		pestBubble.add(lblBubbleSort);
		
		JLabel lblQuickSort = new JLabel("QuickSort");
		lblQuickSort.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuickSort.setBounds(0, 0, 103, 32);
		lblQuickSort.setForeground(new Color(33, 44, 61));
		lblQuickSort.setFont(new Font("Sitka Small", Font.BOLD, 15));
		pestQuick.add(lblQuickSort);
		
		
		
		//crear Pestaña HeapSort
		pestHeap.setBounds(0, 0, 103, 32);
		pestHeap.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pestHeap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(qk.isVisible() == false) {
					pestHeap.setBackground(new Color(230, 187, 79));
				}else {
					pestHeap.setBackground(new Color(197, 152, 20));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(qk.isVisible() == true) {
					pestHeap.setBackground(new Color(232, 182, 23));
				}else {
					pestHeap.setBackground(new Color(230, 187, 79));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(qk.isVisible() == true) {
					pestQuick.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestHeap.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					pestHeap.setBackground(new Color(230, 187, 79));
					pestQuick.setBackground(new Color(232, 182, 23));
					heap.setVisible(true);
					qk.setVisible(false);
					System.out.println("el panel heap es visible? "+heap.isVisible());
				}
			}
		});
		pestHeap.setBackground(new Color(230, 187, 79));
		PanelControl.add(pestHeap);
		pestHeap.setLayout(null);
		
		JLabel lblHeap = new JLabel("HeapSort");
		lblHeap.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeap.setBounds(0, 0, 103, 32);
		lblHeap.setForeground(new Color(33, 44, 61));
		lblHeap.setFont(new Font("Sitka Small", Font.BOLD, 15));
		pestHeap.add(lblHeap);
		
		/*
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
		*/
		JPanel pnlMensajes = new JPanel();
		pnlMensajes.setBounds(0, 86, 984, 46);
		ventana.getContentPane().add(pnlMensajes);
		pnlMensajes.setBackground(new Color(208, 121, 3));
		pnlMensajes.setLayout(null);
		
		
		txtMensaje.setFont(new Font("Calibri", 3, 19));;
		txtMensaje.setEditable(false);
		txtMensaje.setBackground(new Color(208, 121, 3));
		txtMensaje.setBounds(0, 0, 984, 46);
		pnlMensajes.add(txtMensaje);
		txtMensaje.setColumns(10);
		
		ventana.setSize(1000,600);
		ventana.setVisible(true);
	}
	
	 /*public static void eliminarListaCompleta(){
			for(int i = Princ.listaNumericaUsuario.size()-1; i >= 0; i--) {
				heap.remove(Princ.listaNumericaUsuario.get(i));
				listaNumerica.remove(i);
				Princ.listaNumericaUsuario.remove(i);
				Proceso.lista.remove(i);
			}
			contadorNumeros= -1;
			numeroArchivo = 0;
			System.out.println("cantidad de Numeros del arreglo: "+ numerosArreglo.size());
			System.out.println("contadorNumeros: "+ Princ.contadorNumeros);
			txtNum.setEditable(true);
			btnAgregar.setEnabled(true);
			System.out.println(""+listaNumerica);
			heap.repaint();
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
	
	public static void agregarYMover(int lugarLectura) {
		if(lugarLectura == 0) {
			listaNumericaUsuario.get(contadorNumeros).setBounds(20, 50, 46, 14);
			heap.add(listaNumericaUsuario.get(contadorNumeros),new Integer(1));
			new Thread() {
				public void run() {
					int y1 = listaNumericaUsuario.get(contadorNumeros).getLocation().y;
					int x1 = listaNumericaUsuario.get(contadorNumeros).getLocation().x;
					int pos = verificarPos();
					colocarNumeroEnArreglo(x1,y1,pos,listaNumericaUsuario.get(contadorNumeros),tmpsArreglo);
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
		Princ.listaNumericaUsuario.add(numero);
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
	
	
	public static void eliminarNumeros() {
		txtNum.requestFocus();
		txtMensaje.setText("");
		heap.remove(listaNumericaUsuario.get(contadorNumeros));
		heap.repaint();
		listaNumerica.remove(contadorNumeros);
		listaNumericaUsuario.remove(contadorNumeros);
		System.out.println(""+listaNumerica);
		System.out.println("cantidad de numeros:"+listaNumerica.size());
		contadorNumeros--;
		btnAgregar.setEnabled(true);
		txtNum.setEditable(true);
		if(listaNumerica.size()==0) {
			txtMensaje.setText("No hay número que eliminar");
			btnEliminar.setEnabled(false);
		}	
	}
	*/

	static JPanel pestHeap = new JPanel();
}
	