package vista;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import procesos.Animaciones;
import procesos.Busqueda;
import procesos.Ordenamientos;
import procesos.Proceso;
import utils.CajaTexto;

import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.lang.reflect.Array;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
	
public class BusquedaBinaria2 extends JLayeredPane{
	public static JLabel lblBuscar = new JLabel();
		public static List<Double> tiempo = new ArrayList<Double>();
		public static List<Integer> tamano = new ArrayList<Integer>();
		public static int punto = 0;
		public static int ejemploFlag = 0;
		public static JPanel panelGrafico = new JPanel();
		public static CajaTexto txtBuscar = new CajaTexto(444, 34, 46, 20);
		public static CajaTexto txtBuscarRandom = new CajaTexto(444, 34, 46, 20);
	 public BusquedaBinaria2() {
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
		   lblAgregar.setIcon(new ImageIcon(HeapSort.class.getResource("/Image/icons8_add_new_30px_4.png")));
		   lblAgregar.setBounds(66, 31, 30, 30);
		   add(lblAgregar);
		   
		   BotonLabel(lblEliminar, eliminarBlanco, eliminarRojo, eliminarGris, 2);
		   lblEliminar.setIcon(new ImageIcon(HeapSort.class.getResource("/Image/icons8_reduce_30px_1.png")));
		   lblEliminar.setBounds(98, 31, 30, 30);
		   lblEliminar.setEnabled(false);
		   
		   add(lblEliminar);
		   
		   BotonLabel(lblArchivo, archivoNaranja, archivoBlanco, archivoGris, 3);
		   lblArchivo.setIcon(new ImageIcon(HeapSort.class.getResource("/Image/icons8_add_file_30px_2.png")));
		   lblArchivo.setBounds(384, 31, 30, 30);
		   
		   add(lblArchivo);
		   
		   utils.Label buscar = new utils.Label("Buscar", 463, 11, 78, 14);
			 
		   buscar.setSize(78, 20);
		   buscar.setLocation(452, 0);
		   add(buscar);
		   
		   
		   BotonLabel(lblBuscar, buscarNaranja, buscarBlanco, buscarGris, 4);
		   lblBuscar.setIcon(new ImageIcon(BusquedaBinaria.class.getResource("/Image/icons8_search_30px.png")));
		   lblBuscar.setBounds(500, 31, 30, 30);
		   add(lblBuscar);
		   /*
		   BotonLabel(lblOrdenar, ordenarNaranja, ordenarBlanco, ordenarGris, 4);
		   lblOrdenar.setIcon(new ImageIcon(HeapSort.class.getResource("/Image/icons8_direction_30px_3.png")));
		   lblOrdenar.setBounds(452, 31, 30, 30);
		   add(lblOrdenar);
		   */
		   
		   CrearListaRandom.setBounds(533, 84, 170, 30);
		   add(CrearListaRandom);
		   
		   BotonLabel(lblCrearListaRandom, crearRandomNaranjo, crearRandomBlanco, crearRandomGris, 5);
		   lblCrearListaRandom.setIcon(new ImageIcon(HeapSort.class.getResource("/Image/icons8_sort_by_creation_date_30px.png")));
		   lblCrearListaRandom.setBounds(742, 84, 30, 30);
		   
		   add(lblCrearListaRandom);
		   
		   utils.Label lblCantidadLista = new utils.Label("Crear lista random: ", 697, 151, 160, 23);
		   lblCantidadLista.setHorizontalAlignment(SwingConstants.LEFT);
		   lblCantidadLista.setText("Tama\u00F1o de la lista: ");
		   lblCantidadLista.setBounds(533, 41, 170, 30);
		   add(lblCantidadLista);
		   
		   utils.Label BuscarListaRandom = new utils.Label("Crear lista random: ", 697, 151, 160, 23);
		   BuscarListaRandom.setHorizontalAlignment(SwingConstants.LEFT);
		   BuscarListaRandom.setText("Buscar en lista random: ");
		   BuscarListaRandom.setBounds(533, 125, 199, 30);
		   add(BuscarListaRandom);
		   
		   BotonLabel(lblBuscarRandom, buscarNaranja, buscarBlanco, buscarGris, 6);
		   lblBuscarRandom.setIcon(new ImageIcon(BusquedaBinaria.class.getResource("/Image/icons8_search_30px.png")));
		   lblBuscarRandom.setBounds(783, 120, 30, 35);
		   
		   add(lblBuscarRandom);
		   
		   
		   panelGrafico.setBackground(new Color(208, 121, 3));
		   panelGrafico.setBounds(109, 197, 699, 221);
		   add(panelGrafico);
		   
		   txtBuscar.setBounds(444, 26, 46, 35);
		   add(txtBuscar);
		   txtBuscar.setColumns(10);
		   
		   txtBuscarRandom.setColumns(10);
		   txtBuscarRandom.setBounds(727, 120, 46, 35);
		   add(txtBuscarRandom);
		   
		 
		   JButton btnEjemplo = new JButton("Mejor caso");
		   btnEjemplo.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		ejemploMejorCasoAction();
		   	}
		   });
		   btnEjemplo.setBounds(10, 197, 89, 23);
		   add(btnEjemplo);
		   
		   JButton btnEjemplo_1 = new JButton("Encontrado");
		   btnEjemplo_1.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		ejemploEncontrado();
		   	}
		   });
		   btnEjemplo_1.setBounds(10, 255, 89, 23);
		   add(btnEjemplo_1);
		   btnEjemplo_1_1.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		ejemploNoEncontrado();
		   	}
		   });
		   btnEjemplo_1_1.setBounds(10, 307, 89, 23);
		   
		   add(btnEjemplo_1_1);
		   
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
	 
	 public void ejemploMejorCasoAction() {
		 int tam = 100;
		 ejemploFlag = 1;
		 double time;
		 long fin;
		 tamano.removeAll(tamano);
		 tiempo.removeAll(tiempo);
		 
		 for(int i = 0; i < 30; i++) {
			 ArrayList<Integer> lRan = new ArrayList<Integer>();
			 lRan = Proceso.crearListaMejorCasoBusquedaBinaria(tam);
			 tamano.add(tam);
			 long inicio = System.currentTimeMillis();
		   	 Busqueda.binarySearch(lRan, 5, 0, lRan.size()-1);
		   	 fin = System.currentTimeMillis();
		   	 time = (double) ((fin - inicio)/*/1000*/);
		   	 System.out.println(""+time);
		   	 tiempo.add(time);
		   	 tam = tam + 100000;
		 }
		 crearGrafico();
		 Princ.txtMensaje.setText("Ejemplo mejor caso busqueda binaria en 30 listas distintas");
	 }
	 
	 public void ejemploEncontrado() {
		 int tam = 100;
		 ejemploFlag = 1;
		 tamano.removeAll(tamano);
		 tiempo.removeAll(tiempo);
		 
		 for(int i = 0; i < 500; i++) {
			 ArrayList<Integer> lRan = new ArrayList<Integer>();
			 lRan = Proceso.crearListaEncontradoBusquedaBinaria(tam);
			 tamano.add(tam);
			 long inicio = System.currentTimeMillis();
		   	 Busqueda.binarySearch(lRan, i, 0, lRan.size()-1);
		   	 long fin = System.currentTimeMillis();
		   	 double time = (double) ((fin - inicio)/*/1000*/);
		   	 tiempo.add(time);
		   	 tam = tam + 5000;
		 }
		 crearGrafico();
		 Princ.txtMensaje.setText("Ejemplo numero encontrado busqueda binaria en 500 listas distintas");
	 }
	 
	 public void ejemploNoEncontrado() {
		 int tam = 100;
		 ejemploFlag = 1;
		 tamano.removeAll(tamano);
		 tiempo.removeAll(tiempo);
		 
		 for(int i = 0; i < 500; i++) {
			 ArrayList<Integer> lRan = new ArrayList<Integer>();
			 lRan = Proceso.crearListaNoEncontradoBusquedaBinaria(tam);
			 tamano.add(tam);
			 long inicio = System.currentTimeMillis();
		   	 Busqueda.binarySearch(lRan, 5, 0, lRan.size()-1);
		   	 long fin = System.currentTimeMillis();
		   	 double time = (double) ((fin - inicio)/*/1000*/);
		   	 tiempo.add(time);
		   	 tam = tam + 5000;
		 }
		 crearGrafico();
		 Princ.txtMensaje.setText("Ejemplo numero no encontrado busqueda binaria en 500 listas distintas");
	 }
	 
		public static void eliminarNumeros() {
			
			if(listaNumerica.size()==0 || contadorNumeros == -1) {
				lblAgregar.setEnabled(true);
				Princ.txtMensaje.setText("No hay número que eliminar");
				lblEliminar.setEnabled(false);
			}else {
				txtNum.requestFocus();
				Princ.txtMensaje.setText("");
				Princ.busBin.remove(listaNumericaUsuario.get(contadorNumeros));
				Princ.busBin.repaint();
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
				Princ.busBin.remove(listaNumericaUsuario.get(i));
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
			Princ.busBin.repaint();
		}
	 
	 public static void agregarYMover(int lugarLectura, int posNumero) {
		 	
			if(lugarLectura == 0) {
				listaNumericaUsuario.get(contadorNumeros).setBounds(0, 80, 46, 14);
				Princ.busBin.add(listaNumericaUsuario.get(contadorNumeros),new Integer(3));
				new Thread() {
					public void run() {
						int y1 = listaNumericaUsuario.get(contadorNumeros).getLocation().y;
						int x1 = listaNumericaUsuario.get(contadorNumeros).getLocation().x;
						int pos = Proceso.verificarPos(listaNumerica);
						colocarNumeroEnArreglo(x1,y1,pos,listaNumericaUsuario.get(contadorNumeros),tmpsArreglo);
					}
				}.start();
			}else {
				
				System.out.println("posicion del arreglo: "+posNumero);
				listaNumericaUsuario.get(posNumero).setBounds(0, 80, 46, 14);
				Princ.busBin.add(listaNumericaUsuario.get(posNumero),new Integer(1));
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
				case 4: buscarLabelAction();break;
				case 5: listRandom = crearListaRandomLabelAction();break;
				case 6: buscarListaRandomLabelAction(listRandom);break;
				}
				
			}
		});
	}
	
	public static void buscarListaRandomLabelAction(ArrayList<Integer> listRandom) {
		Princ.txtMensaje.setText("");
   		
   		long inicio = System.currentTimeMillis();
   		int numero = Integer.parseInt(txtBuscarRandom.getText());
   		int resultado = Busqueda.binarySearch(listRandom, numero, 0, listRandom.size()-1);
   		//Ordenamientos.heapSort(listaNumerica, listaNumericaUsuario,tmpsArreglo);
   		long fin = System.currentTimeMillis();
   		double time = (double) ((fin - inicio)/*/1000*/);
   		tiempo.add(time);
   		if(resultado == -1) {
			Princ.txtMensaje.setText("Numero "+numero+" no encontrado");
		}else {
			Princ.txtMensaje.setText("Numero "+numero+" encontrado");
		}
   		lblTiempoEjec.setText(""+time+"[ms]");
   		crearGrafico();
	}
	
	public static void buscarLabelAction() {
		if(listaNumerica.size() == 0) {
			Princ.txtMensaje.setText("Primero agregue numeros a la lista");
		}else {
			if(Proceso.verificaOrd(listaNumerica)) {
				//txtBuscar.setText("");
				int numero = Integer.parseInt(txtBuscar.getText());
				int resultado = Busqueda.binarySearch(listaNumerica, numero, 0, listaNumerica.size()-1);
				if(resultado == -1) {
					Princ.txtMensaje.setText("Numero "+numero+" no encontrado");
				}else {
					Princ.txtMensaje.setText("Numero "+numero+" encontrado");
				}
			}else {
				Princ.txtMensaje.setText("La lista debe estar ordenada para usar este metodo de búsqueda");
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
				
			}
			lblEliminar.setEnabled(true);
			txtNum.setEditable(false);
			lblAgregar.setEnabled(false);
		}	
	}
	public static ArrayList<Integer> crearListaRandomLabelAction() {
		if(ejemploFlag == 1) {
			tamano.removeAll(tamano);
			tiempo.removeAll(tiempo);
			ejemploFlag = 0;
		}
			int tamanoLista = Integer.parseInt(txtTamano.getText());
			tamano.add(tamanoLista);
			ArrayList<Integer> listRandom = new ArrayList<Integer>();
			listRandom = Proceso.crearListaRandom(tamanoLista);
			Collections.sort(listRandom);
			//imprimirListaNumerica(listRandom);
	   		txtTamano.setText("");
	   		lblTiempoEjec.setText("");
			return listRandom;
	}
	
	public static void crearGrafico() {
		XYSeries oSeries = new XYSeries("");
	   	
   		for(int i = 0; i < tamano.size()-1;i++) {
   			oSeries.add(tamano.get(i),tiempo.get(i));
   		}
   	
   		XYSeriesCollection oDataset = new XYSeriesCollection();
   		
   		oDataset.addSeries(oSeries);
   		
   		
   		JFreeChart oChart = ChartFactory.createXYLineChart("Busqueda Binaria", "Tamaño del arreglo", "Tiempo[ms]", oDataset, PlotOrientation.VERTICAL, true, false, false);
   		oChart.setBackgroundPaint(new Color(208, 121, 3));
   		ChartPanel oPanel = new ChartPanel(oChart);
   		
   		panelGrafico.setLayout(new java.awt.BorderLayout());
   		panelGrafico.add(oPanel);
   		panelGrafico.validate();
	}
	
	public static void agregarLabelAction() {
		
			if(txtNum.getText().isEmpty()) {
				Princ.txtMensaje.setText("Digite un número");
				txtNum.requestFocus();
			}else {
				if(Integer.parseInt(txtNum.getText()) > 99) {
					Princ.txtMensaje.setText("Porfavor, digite un número entre 0 y 99");
					txtRuta.setText("");
				}else {
					lblEliminar.setEnabled(true);
					txtNum.requestFocus();
					Princ.txtMensaje.setText("");
					contadorNumeros++;
					iniciarNumeros(0);
					System.out.println("\ncantidad de numeros label"+listaNumericaUsuario.size());
					agregarYMover(0,0);
				}
			}
			if(listaNumerica.size()==11) {
				txtNum.setEditable(false);
				lblAgregar.setEnabled(false);
				Princ.txtMensaje.setText("Lista llena, no puede agregar más números.");	
			}
		
		
	}
	
	
	
	public static void eliminarLabelAction() {
		eliminarNumeros();
	}
	
	public static JLabel lblCrearListaRandom = new JLabel();
	public static JLabel lblOrdenar = new JLabel();
	public static JLabel lblArchivo = new JLabel();
	public static JLabel lblEliminar = new JLabel();
	public static JLabel lblAgregar = new JLabel();
	
	public static ArrayList<JLabel> listaNumericaUsuario = new ArrayList<JLabel>();
	public static ArrayList<Integer> listaNumerica = new ArrayList<Integer>();
	public static ArrayList<JLabel> tmpsArreglo = new ArrayList<JLabel>();
	public static ArrayList<JLabel> numerosArreglo = new ArrayList<JLabel>();
	public static List<JLabel> listCuadrados;
	public static ArrayList<Integer> listRandom;
	
	public static CajaTexto txtRuta = new CajaTexto(165, 11, 156, 35);
	public static CajaTexto txtNum = new CajaTexto(10, 11, 46, 35);
	public static CajaTexto txtMensaje = new CajaTexto(0, 0, 984, 46);
	public static CajaTexto txtTamano = new CajaTexto(751, 72, 86, 20);
	
	public static utils.Label lblTiempoEjec = new utils.Label("",811, 22, 70, 14);
	
	
	static JLayeredPane panel = new JLayeredPane();
	
	public static int numeroArchivo = 0;
	static int contadorCasillas;
	public static int contadorNumeros = -1;
	public static int TAMANOARREGLO = 11;
	public static int n;
	
	private final utils.Label tmpEjec = new utils.Label("Tiempo de Ejecuccion", 586, 22, 109, 14);
	
	ImageIcon buscarGris = new ImageIcon(Princ.class.getResource("/Image/icons8_search_30px_2.png"));
	ImageIcon buscarBlanco = new ImageIcon(Princ.class.getResource("/Image/icons8_search_30px.png"));
	ImageIcon buscarNaranja = new ImageIcon(Princ.class.getResource("/Image/icons8_search_30px_1.png"));
	ImageIcon ordenarRandomNaranja = new ImageIcon(Princ.class.getResource("/Image/icons8_front_sorting_30px.png"));
	ImageIcon ordenarRandomGris = new ImageIcon(Princ.class.getResource("/Image/icons8_front_sorting_30px_1.png"));
	ImageIcon ordenarRandomBlanco = new ImageIcon(Princ.class.getResource("/Image/icons8_front_sorting_30px_2.png"));
	ImageIcon crearRandomBlanco = new ImageIcon(Princ.class.getResource("/Image/icons8_sort_by_creation_date_30px.png"));
	ImageIcon crearRandomNaranjo = new ImageIcon(Princ.class.getResource("/Image/icons8_sort_by_creation_date_30px_2.png"));
	ImageIcon crearRandomGris = new ImageIcon(Princ.class.getResource("/Image/icons8_sort_by_creation_date_30px_1.png"));
	ImageIcon ordenarGris = new ImageIcon(Princ.class.getResource("/Image/icons8_direction_30px_1.png"));
	ImageIcon ordenarBlanco = new ImageIcon(Princ.class.getResource("/Image/icons8_direction_30px_3.png"));
	ImageIcon ordenarNaranja = new ImageIcon(Princ.class.getResource("/Image/icons8_direction_30px_2.png"));
	ImageIcon archivoNaranja = new ImageIcon(Princ.class.getResource("/Image/icons8_add_file_30px_1.png"));
	ImageIcon archivoGris = new ImageIcon(Princ.class.getResource("/Image/icons8_add_file_30px_3.png"));
	ImageIcon archivoBlanco = new ImageIcon(Princ.class.getResource("/Image/icons8_add_file_30px_2.png"));
	ImageIcon eliminarBlanco = new ImageIcon(Princ.class.getResource("/Image/icons8_reduce_30px_3.png"));
	ImageIcon eliminarGris = new ImageIcon(Princ.class.getResource("/Image/icons8_reduce_30px.png"));
	ImageIcon eliminarRojo = new ImageIcon(Princ.class.getResource("/Image/icons8_reduce_30px_1.png"));
	ImageIcon agregarBlanco = new ImageIcon(Princ.class.getResource("/Image/icons8_add_new_30px.png"));
	ImageIcon agregarVerde = new ImageIcon(Princ.class.getResource("/Image/icons8_add_new_30px_4.png"));
	ImageIcon agregarGris = new ImageIcon(Princ.class.getResource("/Image/icons8_add_new_30px_5.png"));
	private final JLabel lblOrdenarRandom = new JLabel("");
	private final JLabel lblBuscarRandom = new JLabel("");
	private static ArrayList<Integer> listRan;
	private final JButton btnEjemplo_1_1 = new JButton("No encontrado");
}
