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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.bind.ParseConversionEvent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import procesos.Animaciones;
import procesos.Ordenamientos;
import procesos.Proceso;
import utils.CajaTexto;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
	
public class QuickSort extends JLayeredPane{
	public static utils.Label lblTiempoEjec = new utils.Label("",811, 22, 70, 14);
	public static JLabel lblCrearListaRandom = new JLabel();
	public static JLabel lblArchivo = new JLabel();
	public static JLabel lblEliminar = new JLabel();
	public static JLabel lblAgregar = new JLabel();
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
	public static ArrayList<JLabel> numerosArreglo = new ArrayList<JLabel>();
	public static int n;
	public static int TAMANOARREGLO = 11;
	public static ArrayList<JLabel> tmpsArreglo = new ArrayList<JLabel>();
	public static List<JLabel> listCuadrados;
	private final utils.Label tmpEjec = new utils.Label("Tiempo de Ejecuccion", 586, 22, 109, 14);
	public static CajaTexto txtTamano = new CajaTexto(751, 72, 86, 20);
	public static JPanel panelGrafico = new JPanel();
	public static List<Double> tiempo = new ArrayList<Double>();
	public static List<Integer> tamano = new ArrayList<Integer>();
	public static int punto = 0;
	public static int ejemploFlag = 0;
	
	
	
	 public QuickSort() {
		   setBackground(new Color(235, 137, 4));//color medio naranjo
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
		   txtNum.setBounds(10, 26, 46, 35);
		 	
		   
		   txtNum.setColumns(10);
		   
		   
		   add(txtNum);
		   txtRuta.setBounds(138, 26, 240, 35);
		   add(txtRuta);
		   
		   
		   lblTiempoEjec.setBounds(727, 166, 110, 20);
		   add(lblTiempoEjec);
		   tmpEjec.setHorizontalAlignment(SwingConstants.LEFT);
		   
		   tmpEjec.setText("Tiempo de ejecucci\u00F3n: ");
		   tmpEjec.setBounds(533, 166, 184, 20);
		   add(tmpEjec);
		   
		   
		   txtTamano.setBounds(713, 31, 100, 35);
		   add(txtTamano);
		   txtTamano.setColumns(10);
		   
		   utils.Label CrearListaRandom = new utils.Label("Crear lista random: ",697, 151, 160, 23);
		   CrearListaRandom.setHorizontalAlignment(SwingConstants.LEFT);
		 
		   BotonLabel(lblAgregar, agregarBlanco, agregarVerde, agregarGris, 1);
		   lblAgregar.setIcon(new ImageIcon(QuickSort.class.getResource("/Image/icons8_add_new_30px_4.png")));
		   lblAgregar.setBounds(66, 31, 30, 30);
		   add(lblAgregar);
		   
		   BotonLabel(lblEliminar, eliminarBlanco, eliminarRojo, eliminarGris, 2);
		   lblEliminar.setIcon(new ImageIcon(QuickSort.class.getResource("/Image/icons8_reduce_30px_1.png")));
		   lblEliminar.setBounds(98, 31, 30, 30);
		   lblEliminar.setEnabled(false);
		   
		   add(lblEliminar);
		   
		   BotonLabel(lblArchivo, archivoNaranja, archivoBlanco, archivoGris, 3);
		   lblArchivo.setIcon(new ImageIcon(QuickSort.class.getResource("/Image/icons8_add_file_30px_2.png")));
		   lblArchivo.setBounds(384, 31, 30, 30);
		   
		   add(lblArchivo);
		   
		   
		   CrearListaRandom.setBounds(533, 84, 170, 30);
		   add(CrearListaRandom);
		   
		   BotonLabel(lblCrearListaRandom, crearRandomNaranjo, crearRandomBlanco, crearRandomGris, 5);
		   lblCrearListaRandom.setIcon(new ImageIcon(QuickSort.class.getResource("/Image/icons8_sort_by_creation_date_30px.png")));
		   lblCrearListaRandom.setBounds(742, 84, 30, 30);
		   
		   add(lblCrearListaRandom);
		   
		   utils.Label lblCantidadLista = new utils.Label("Crear lista random: ", 697, 151, 160, 23);
		   lblCantidadLista.setHorizontalAlignment(SwingConstants.LEFT);
		   lblCantidadLista.setText("Tama\u00F1o de la lista: ");
		   lblCantidadLista.setBounds(533, 41, 170, 30);
		   add(lblCantidadLista);
		   
		   utils.Label OrdenarListaRandom = new utils.Label("Crear lista random: ", 697, 151, 160, 23);
		   OrdenarListaRandom.setHorizontalAlignment(SwingConstants.LEFT);
		   OrdenarListaRandom.setText("Ordenar lista random: ");
		   OrdenarListaRandom.setBounds(533, 125, 199, 30);
		   add(OrdenarListaRandom);
		   
		   BotonLabel(lblOrdenarRandom, ordenarRandomNaranja, ordenarRandomBlanco, ordenarRandomGris, 6);
		   lblOrdenarRandom.setIcon(new ImageIcon(QuickSort.class.getResource("/Image/icons8_front_sorting_30px_2.png")));
		   lblOrdenarRandom.setBounds(742, 125, 30, 30);
		   
		   add(lblOrdenarRandom);
		   
		   panelGrafico.setBackground(new Color(208, 121, 3));
		   panelGrafico.setBounds(109, 197, 699, 221);
		   add(panelGrafico);
		   
		   JButton btnEjemplo = new JButton("Ejemplo");
		   btnEjemplo.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		ejemploAction();
		   	}
		   });
		   btnEjemplo.setBounds(10, 197, 89, 23);
		   add(btnEjemplo);
		   
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
	 
	 public void ejemploAction() {
		 int tam = 100;
		 ejemploFlag = 1;
		 tamano.removeAll(tamano);
		 tiempo.removeAll(tiempo);
		 
		 for(int i = 0; i < 30; i++) {
			 ArrayList<Integer> lRan = new ArrayList<Integer>();
			 lRan = Proceso.crearListaRandom(tam);
			 tamano.add(tam);
			 long inicio = System.currentTimeMillis();
		   	 Ordenamientos.quickSort(lRan, 0, lRan.size()-1);
		   	 long fin = System.currentTimeMillis();
		   	 double time = (double) ((fin - inicio)/*/1000*/);
		   	 tiempo.add(time);
		   	 tam = tam + 5000;
		 }
		 crearGrafico();
		 Princ.txtMensaje.setText("Ejemplo de 30 listas ordenadas por heapsort");
	 }
	 
		public static void eliminarNumeros() {
			
			if(listaNumerica.size()==0 || contadorNumeros == -1) {
				lblAgregar.setEnabled(true);
				Princ.txtMensaje.setText("No hay número que eliminar");
				lblEliminar.setEnabled(false);
			}else {
				txtNum.requestFocus();
				Princ.txtMensaje.setText("");
				Princ.qk.remove(listaNumericaUsuario.get(contadorNumeros));
				Princ.qk.repaint();
				listaNumerica.remove(contadorNumeros);
				listaNumericaUsuario.remove(contadorNumeros);
				System.out.println(""+listaNumerica);
				System.out.println("cantidad de numeros:"+listaNumerica.size());
			contadorNumeros--;
			lblAgregar.setEnabled(true);
			txtNum.setEditable(true);
			txtRuta.setText("");
			}
		}
	 
	 public static void eliminarListaCompleta(){
			for(int i = listaNumericaUsuario.size()-1; i >= 0; i--) {
				Princ.qk.remove(listaNumericaUsuario.get(i));
				listaNumerica.remove(i);
				listaNumericaUsuario.remove(i);
				Proceso.lista.remove(i);
			}
			contadorNumeros= -1;
			numeroArchivo = 0;
			System.out.println("cantidad de Numeros del arreglo: "+ numerosArreglo.size());
			System.out.println("contadorNumeros: "+ contadorNumeros);
			txtNum.setEditable(true);
			//btnAgregar.setEnabled(true);
			System.out.println(""+listaNumerica);
			Princ.qk.repaint();
		}
	 
	 public static void agregarYMover(int lugarLectura, int posNumero) {
		 	
			if(lugarLectura == 0) {
				listaNumericaUsuario.get(contadorNumeros).setBounds(0, 80, 46, 14);
				Princ.qk.add(listaNumericaUsuario.get(contadorNumeros),new Integer(3));
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
				listaNumericaUsuario.get(posNumero).setBounds(0, 80, 46, 14);
				Princ.qk.add(listaNumericaUsuario.get(posNumero),new Integer(1));
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
			lblEliminar.setEnabled(false);
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
		lblEliminar.setEnabled(true);
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
	
	public void BotonLabel(JLabel label,Icon Entered, Icon Exited, Icon Pressed, int opc) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setIcon(Entered);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setIcon(Exited);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				label.setIcon(Pressed);
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				label.setIcon(Entered);
				switch(opc) {
				case 1: agregarLabelAction();break;
				case 2: eliminarLabelAction();break;
				case 3: agregarArchivoLabelAction();break;
				case 4: ordenarLabelAction();break;
				case 5: listRandom = crearListaRandomLabelAction();break;
				case 6: ordenarListaRandomLabelAction(listRandom);break;
				}
				
			}
		});
	}
	
	public static void ordenarListaRandomLabelAction(ArrayList<Integer> listRandom) {
		Princ.txtMensaje.setText("");
   		long inicio = System.currentTimeMillis();
   		Ordenamientos.quickSort(listRandom, 0, listRandom.size()-1);
   		long fin = System.currentTimeMillis();
   		double time = (double) ((fin - inicio)/*/1000*/);
   		tiempo.add(time);
   		
   		
   		lblTiempoEjec.setText(""+time+"[ms]");
   		Princ.txtMensaje.setText("Ordenamiento completado");
   		crearGrafico();
	}
	
	public static void ordenarLabelAction() {
		if(listaNumerica.size() == 0) {
			Princ.txtMensaje.setText("Primero agregue numeros a la lista");
		}else {
			if(Proceso.verificaOrd(listaNumerica)) {
				Princ.txtMensaje.setText("Lista ordenada");
			}else {
				Animaciones.animacionHeapSort(listaNumericaUsuario, listaNumerica, tmpsArreglo);
			}
		}
	}
	
	public static void agregarArchivoLabelAction() {
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
				lblEliminar.setEnabled(true);
				txtNum.setEditable(false);
				lblAgregar.setEnabled(false);
			}
		}	
	}
	public static ArrayList<Integer> crearListaRandomLabelAction() {
		int tamanoLista = Integer.parseInt(txtTamano.getText());
		
		ArrayList<Integer> listRandom = new ArrayList<Integer>();
		listRandom = Proceso.crearListaRandom(tamanoLista);
		//imprimirListaNumerica(listRandom);
   		txtTamano.setText("");
   		lblTiempoEjec.setText("");
		return listRandom;
	}
	
	public static void crearGrafico() {
		XYSeries oSeries = new XYSeries("");
	   	
   		for(int i = 0; i < tiempo.size()-1;i++) {
   			oSeries.add(tamano.get(i),tiempo.get(i));
   		}
   	
   		XYSeriesCollection oDataset = new XYSeriesCollection();
   		
   		oDataset.addSeries(oSeries);
   		
   		
   		JFreeChart oChart = ChartFactory.createXYLineChart("HeapSort", "Tamaño del arreglo", "Tiempo[ms]", oDataset, PlotOrientation.VERTICAL, true, false, false);
   		oChart.setBackgroundPaint(new Color(208, 121, 3));
   		ChartPanel oPanel = new ChartPanel(oChart);
   		
   		panelGrafico.setLayout(new java.awt.BorderLayout());
   		panelGrafico.add(oPanel);
   		panelGrafico.validate();
	}
	
	public static void agregarLabelAction() {
		
		if(Integer.parseInt(txtNum.getText()) > 99) {
			Princ.txtMensaje.setText("Porfavor, digite un número entre 0 y 99");
			txtNum.setText("");
		}else {
			
			if(txtNum.getText().isEmpty()) {
				Princ.txtMensaje.setText("Digite un número");
				txtNum.requestFocus();
			}else {
				lblEliminar.setEnabled(true);
				txtNum.requestFocus();
				Princ.txtMensaje.setText("");
				contadorNumeros++;
				iniciarNumeros(0);
				System.out.println("\ncantidad de numeros label"+listaNumericaUsuario.size());
				agregarYMover(0,0);
			}
			if(listaNumerica.size()==11) {
				txtNum.setEditable(false);
				lblAgregar.setEnabled(false);
				Princ.txtMensaje.setText("Lista llena, no puede agregar más números.");	
			}
		}
		
	}
	
	public static void eliminarLabelAction() {
		eliminarNumeros();
	}
	
	public static ArrayList<Integer> listRandom;
	
	ImageIcon ordenarRandomNaranja = new ImageIcon(QuickSort.class.getResource("/Image/icons8_front_sorting_30px.png"));
	ImageIcon ordenarRandomGris = new ImageIcon(QuickSort.class.getResource("/Image/icons8_front_sorting_30px_1.png"));
	ImageIcon ordenarRandomBlanco = new ImageIcon(QuickSort.class.getResource("/Image/icons8_front_sorting_30px_2.png"));
	ImageIcon crearRandomBlanco = new ImageIcon(QuickSort.class.getResource("/Image/icons8_sort_by_creation_date_30px.png"));
	ImageIcon crearRandomNaranjo = new ImageIcon(QuickSort.class.getResource("/Image/icons8_sort_by_creation_date_30px_2.png"));
	ImageIcon crearRandomGris = new ImageIcon(QuickSort.class.getResource("/Image/icons8_sort_by_creation_date_30px_1.png"));
	ImageIcon ordenarGris = new ImageIcon(QuickSort.class.getResource("/Image/icons8_direction_30px_1.png"));
	ImageIcon ordenarBlanco = new ImageIcon(QuickSort.class.getResource("/Image/icons8_direction_30px_3.png"));
	ImageIcon ordenarNaranja = new ImageIcon(QuickSort.class.getResource("/Image/icons8_direction_30px_2.png"));
	ImageIcon archivoNaranja = new ImageIcon(QuickSort.class.getResource("/Image/icons8_add_file_30px_1.png"));
	ImageIcon archivoGris = new ImageIcon(QuickSort.class.getResource("/Image/icons8_add_file_30px_3.png"));
	ImageIcon archivoBlanco = new ImageIcon(QuickSort.class.getResource("/Image/icons8_add_file_30px_2.png"));
	ImageIcon eliminarBlanco = new ImageIcon(QuickSort.class.getResource("/Image/icons8_reduce_30px_3.png"));
	ImageIcon eliminarGris = new ImageIcon(QuickSort.class.getResource("/Image/icons8_reduce_30px.png"));
	ImageIcon eliminarRojo = new ImageIcon(QuickSort.class.getResource("/Image/icons8_reduce_30px_1.png"));
	ImageIcon agregarBlanco = new ImageIcon(QuickSort.class.getResource("/Image/icons8_add_new_30px.png"));
	ImageIcon agregarVerde = new ImageIcon(QuickSort.class.getResource("/Image/icons8_add_new_30px_4.png"));
	ImageIcon agregarGris = new ImageIcon(QuickSort.class.getResource("/Image/icons8_add_new_30px_5.png"));
	private final JLabel lblOrdenarRandom = new JLabel("");
}
