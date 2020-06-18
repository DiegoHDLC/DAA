package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.Icon;
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
import java.awt.Window;

import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import procesos.Animaciones;
import procesos.Ordenamientos;
import procesos.Proceso;
import utils.Boton;
import utils.CajaTexto;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;


import javax.swing.event.ChangeEvent;

public class Princ{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JPanel pestQuick = new JPanel();
	public static CajaTexto txtMensaje = new CajaTexto(0, 0, 984, 46);
	public static HeapSort heap = new HeapSort();
	public static QuickSort qk = new QuickSort();
	public static BubbleSort bubble = new BubbleSort();
	public static BusquedaBinaria2 busBin = new BusquedaBinaria2();
	public static BusquedaSecuencial busSec = new BusquedaSecuencial();
	public static BusquedaRandom2 busRan = new BusquedaRandom2();
	public static JFrame ventana = new JFrame();
	
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
	public static ArrayList<JLabel> numerosArreglo = new ArrayList<JLabel>();
	public static int n;
	public static int TAMANOARREGLO = 11;
	public static ArrayList<JLabel> tmpsArreglo = new ArrayList<JLabel>();
	public static List<JLabel> listCuadrados;
	public static void main(String[] args) {
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
		//Proceso.crearListaCero();
	}
	public Princ() {
			
	}

	@SuppressWarnings("deprecation")
	public static void initComponents() {
		
		ventana.getContentPane().setLayout(null);
		ventana.setUndecorated(true);
		ventana.setBackground(new Color(235,137,4));
		
		JPanel panel = new JPanel();
		
		panel.setBounds(0, 0, 897, 30);
		panel.setBackground(new Color(208, 121, 3));
		ventana.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCerrar = new JLabel("");
		MouseActionBarra(lblCerrar, cerrarBlanco, cerrarAmarillo ,null, 2);
		lblCerrar.setIcon(new ImageIcon(Princ.class.getResource("/Image/icons8_close_window_30px_8.png")));
		lblCerrar.setBounds(857, 0, 30, 30);
		panel.add(lblCerrar);
		
		JLabel labelMinimizar = new JLabel("");
		MouseActionBarra(labelMinimizar, minimizarBlanco, minimizarAmarillo ,null, 1);
		labelMinimizar.setIcon(new ImageIcon(Princ.class.getResource("/Image/icons8_minimize_window_30px_4.png")));
		labelMinimizar.setBounds(825, 0, 30, 30);
		panel.add(labelMinimizar);
		
		JLabel lblInfo = new JLabel("");
		MouseActionBarra(lblInfo, infoBlanco, infoAmarillo, infoGris, 3);
		lblInfo.setIcon(new ImageIcon(Princ.class.getResource("/Image/icons8_info_30px_2.png")));
		lblInfo.setBounds(10, 0, 30, 30);
		panel.add(lblInfo);
		
		//INICIALIZANDO PANELES
		inicializarPanel(busBin, ventana,0);
		inicializarPanel(busSec, ventana,0);
		inicializarPanel(heap, ventana,1);
		inicializarPanel(bubble, ventana, 0);
		inicializarPanel(qk,ventana,0);
		inicializarPanel(busRan,ventana,0);
		
		JPanel pnlMensajes = new JPanel();
		pnlMensajes.setBounds(0, 68, 897, 53);
		ventana.getContentPane().add(pnlMensajes);
		pnlMensajes.setBackground(new Color(208, 121, 3));
		pnlMensajes.setLayout(null);
		
		
		txtMensaje.setFont(new Font("Calibri", 3, 19));
		txtMensaje.setEditable(false);
		txtMensaje.setBackground(new Color(208, 121, 3));
		txtMensaje.setBounds(0, 0, 897, 53);
		pnlMensajes.add(txtMensaje);
		txtMensaje.setColumns(10);
		
		JPanel PanelControl = new JPanel();
		PanelControl.setBackground(new Color(218, 165, 32));
		PanelControl.setBounds(0, 0, 897, 70);
		ventana.getContentPane().add(PanelControl);
		
		//PESTAÑA BUBBLESORT
		pestBubble.setBounds(226, 33, 103, 32);
		pestBubble.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		MousePestañas(pestBubble, bubble, pestHeap, heap, pestBusBinaria, busBin, pestBusSecuencial, busSec, pestQuick, qk, pestBusRandom, busRan);
		PanelControl.setLayout(null);
		pestBubble.setBackground(new Color(232, 182, 23));
		PanelControl.add(pestBubble);
		pestBubble.setLayout(null);
		
		JLabel lblBubbleSort = new JLabel("BubbleSort");
		lblBubbleSort.setBounds(0, 0, 103, 32);
		pestBubble.add(lblBubbleSort);
		lblBubbleSort.setHorizontalAlignment(SwingConstants.CENTER);
		lblBubbleSort.setForeground(new Color(33, 44, 61));
		lblBubbleSort.setFont(new Font("Sitka Small", Font.BOLD, 15));
		
		
		//PESTAÑA QUICKSORT
		pestQuick.setBounds(113, 33, 103, 32);
		pestQuick.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		MousePestañas(pestQuick, qk, pestHeap, heap, pestBusBinaria, busBin, pestBusSecuencial, busSec, pestBubble, bubble, pestBusRandom, busRan);
		pestQuick.setBackground(new Color(232, 182, 23));
		PanelControl.add(pestQuick);
		pestQuick.setLayout(null);
		
		JLabel lblQuickSort = new JLabel("QuickSort");
		lblQuickSort.setBounds(0, 0, 103, 32);
		pestQuick.add(lblQuickSort);
		lblQuickSort.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuickSort.setForeground(new Color(33, 44, 61));
		lblQuickSort.setFont(new Font("Sitka Small", Font.BOLD, 15));
		
		
		//PESTAÑA HEAPSORT
		pestHeap.setBounds(0, 33, 103, 32);
		pestHeap.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		MousePestañas(pestHeap, heap, pestQuick, qk, pestBusBinaria, busBin, pestBusSecuencial, busSec, pestBubble, bubble, pestBusRandom, busRan);
		pestHeap.setBackground(new Color(230, 187, 79));
		PanelControl.add(pestHeap);
		pestHeap.setLayout(null);
		
		JLabel lblHeap = new JLabel("HeapSort");
		lblHeap.setBounds(0, 0, 103, 32);
		pestHeap.add(lblHeap);
		lblHeap.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeap.setForeground(new Color(33, 44, 61));
		lblHeap.setFont(new Font("Sitka Small", Font.BOLD, 15));
		
		
		//PESTAÑA BUSQUEDA BINARIA
		pestBusBinaria.setBounds(339, 33, 160, 32);
		MousePestañas(pestBusBinaria, busBin, pestHeap, heap, pestQuick, qk, pestBusSecuencial, busSec, pestBubble, bubble, pestBusRandom, busRan);
		pestBusBinaria.setLayout(null);
		pestBusBinaria.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pestBusBinaria.setBackground(new Color(232, 182, 23));
		PanelControl.add(pestBusBinaria);
		
		JLabel lblBusBinaria = new JLabel("B\u00FAsqueda Binaria");
		lblBusBinaria.setBounds(0, 0, 160, 31);
		pestBusBinaria.add(lblBusBinaria);
		lblBusBinaria.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusBinaria.setForeground(new Color(33, 44, 61));
		lblBusBinaria.setFont(new Font("Sitka Small", Font.BOLD, 15));
		
		
		//PESTAÑA BUSQUEDA SECUENCIAL
		pestBusSecuencial.setBounds(509, 33, 189, 32);
		MousePestañas(pestBusSecuencial, busSec, pestHeap, heap, pestBusBinaria, busBin, pestQuick, qk, pestBubble, bubble, pestBusRandom, busRan);
		pestBusSecuencial.setLayout(null);
		pestBusSecuencial.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pestBusSecuencial.setBackground(new Color(232, 182, 23));
		PanelControl.add(pestBusSecuencial);
		
		JLabel lblBusSecuencial = new JLabel("B\u00FAsqueda Secuencial");
		lblBusSecuencial.setBounds(0, 0, 189, 31);
		pestBusSecuencial.add(lblBusSecuencial);
		lblBusSecuencial.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusSecuencial.setForeground(new Color(33, 44, 61));
		lblBusSecuencial.setFont(new Font("Sitka Small", Font.BOLD, 15));
		
		
		//PESTAÑA BUSQUEDA RANDOM
		pestBusRandom.setBounds(708, 33, 189, 32);
		MousePestañas(pestBusRandom, busRan, pestHeap, heap, pestBusBinaria, busBin, pestQuick, qk, pestBubble, bubble, pestBusSecuencial, busSec);
		pestBusRandom.setLayout(null);
		pestBusRandom.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pestBusRandom.setBackground(new Color(232, 182, 23));
		PanelControl.add(pestBusRandom);
		
		JLabel lblBusRandom = new JLabel("B\u00FAsqueda Random");
		lblBusRandom.setBounds(0, 0, 189, 31);
		pestBusRandom.add(lblBusRandom);
		lblBusRandom.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusRandom.setForeground(new Color(33, 44, 61));
		lblBusRandom.setFont(new Font("Sitka Small", Font.BOLD, 15));
		
		ventana.setSize(897, 549);
		ventana.setVisible(true);
		ventana.setLocation(250, 60);
	}
	
	public static void inicializarPanel(JLayeredPane panel, JFrame ventana, int opcion) {
		if(opcion == 1) {
			panel.setVisible(true);
		}else {
			panel.setVisible(false);
		}
		panel.setLayout(null);
		panel.setBounds(0, 120, 897, 429);
		ventana.getContentPane().add(panel);
	}
	
	public static void MouseActionBarra(JLabel label,Icon Entered, Icon Exited, Icon Clicked, int boton) {
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
			public void mouseClicked(MouseEvent e) {
				switch(boton) {
				case 1: ventana.setState(JFrame.ICONIFIED);
				case 2: System.exit(0);
				case 3: Informacion info= new Informacion();
						info.setVisible(true);
				}
				
			}
		});
	}
	
	public static void MousePestañas(JPanel pestPrincipal, JLayeredPane panelPrincipal, JPanel segPestaña, 
			JLayeredPane segPanel, JPanel terPestaña, JLayeredPane terPanel, JPanel cuarPestaña, JLayeredPane cuarPanel,
			JPanel quinPestaña, JLayeredPane quinPanel, JPanel sextPestaña, JLayeredPane sextPanel) {
		pestPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(panelPrincipal.isVisible()==false) {
					pestPrincipal.setBackground(new Color(197, 152, 20));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(segPanel.isVisible() == false && terPanel.isVisible() ==  false && cuarPanel.isVisible() == false
						&& quinPanel.isVisible() == false && sextPanel.isVisible() == false) {
					pestPrincipal.setBackground(new Color(230, 187, 79));
					segPestaña.setBackground(new Color(232, 182, 23));
					terPestaña.setBackground(new Color(232, 182, 23));
					cuarPestaña.setBackground(new Color(232, 182, 23));
					quinPestaña.setBackground(new Color(232, 182, 23));
					sextPestaña.setBackground(new Color(232, 182, 23));
				}else {
					pestPrincipal.setBackground(new Color(232, 182, 23));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(segPanel.isVisible() == true || terPanel.isVisible() == true || cuarPanel.isVisible() == true
						|| quinPanel.isVisible() == true || sextPanel.isVisible() == true) {
					txtMensaje.setText("");
					pestPrincipal.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					pestPrincipal.setBackground(new Color(230, 187, 79));
					setearPanelYPest(segPestaña, segPanel);
					setearPanelYPest(terPestaña, terPanel);
					setearPanelYPest(cuarPestaña, cuarPanel);
					setearPanelYPest(quinPestaña, quinPanel);
					setearPanelYPest(sextPestaña, sextPanel);
					panelPrincipal.setVisible(true);
					System.out.println("el panel"+ panelPrincipal+" es visible? "+panelPrincipal.isVisible());
				
				}
			}
		});
	}
	
	public static void setearPanelYPest(JPanel pest, JLayeredPane panel) {
		pest.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pest.setBackground(new Color(232, 182, 23));
		panel.setVisible(false);
	}
	
	public static synchronized void suspenderHilo() {
		Animaciones.suspender = true;
	}
	
	public static synchronized void reanudarHilo() {
		Animaciones.suspender = false;
		Thread.currentThread().notify();
	}
	
	static ImageIcon infoGris = new ImageIcon(Princ.class.getResource("/Image/icons8_info_30px_3.png"));
	static ImageIcon infoAmarillo = new ImageIcon(Princ.class.getResource("/Image/icons8_info_30px_2.png"));
	static ImageIcon infoBlanco = new ImageIcon(Princ.class.getResource("/Image/icons8_info_30px_1.png"));
	static ImageIcon cerrarBlanco = new ImageIcon(Princ.class.getResource("/Image/icons8_close_window_30px_1.png"));
	static ImageIcon cerrarGris = new ImageIcon(Princ.class.getResource("/Image/icons8_close_window_30px_5.png"));
	static ImageIcon cerrarAmarillo = new ImageIcon(Princ.class.getResource("/Image/icons8_close_window_30px_8.png"));
	static ImageIcon minimizarBlanco = new ImageIcon(Princ.class.getResource("/Image/icons8_minimize_window_30px_1.png"));
	static ImageIcon minimizarAmarillo = new ImageIcon(Princ.class.getResource("/Image/icons8_minimize_window_30px_4.png"));
	static ImageIcon minimizarGris = new ImageIcon(Princ.class.getResource("/Image/icons8_minimize_window_30px_5.png"));
	static JPanel pestBusSecuencial = new JPanel();
	static JPanel pestHeap = new JPanel();
	static JPanel pestBusBinaria = new JPanel();
	static JPanel pestBusRandom = new JPanel();
	static JPanel pestBubble = new JPanel();
}
	