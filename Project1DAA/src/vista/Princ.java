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
	public static BusquedaBinaria busBin = new BusquedaBinaria();
	public static BusquedaSecuencial busSec = new BusquedaSecuencial();
	public static JFrame ventana = new JFrame();
	
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
		busBin.setBounds(0, 120, 897, 429);
		busSec.setBounds(0, 120, 897, 429);
		heap.setBounds(0, 120, 897, 429);
		bubble.setBounds(0, 120, 897, 429);
		qk.setBounds(0, 120, 897, 429);
		
		heap.setVisible(true);
		heap.setLayout(null);
		ventana.getContentPane().add(heap);
		heap.setVisible(true);
		heap.setLayout(null);
	
		ventana.getContentPane().add(qk);
		qk.setVisible(false);
		qk.setLayout(null);
		
		ventana.getContentPane().add(bubble);
		bubble.setVisible(false);
		bubble.setLayout(null);
		
		ventana.getContentPane().add(busBin);
		busBin.setVisible(false);
		busBin.setLayout(null);
		
		ventana.getContentPane().add(busSec);
		busSec.setVisible(false);
		busSec.setLayout(null);
		
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
		
		//crear pestaña MergeSort
		
		JPanel pestBubble = new JPanel();
		pestBubble.setBounds(226, 33, 103, 32);
		pestBubble.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pestBubble.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(bubble.isVisible()==false) {
					pestBubble.setBackground(new Color(197, 152, 20));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(heap.isVisible() == false && qk.isVisible() == false) {
					pestQuick.setBackground(new Color(232, 182, 23));
					pestHeap.setBackground(new Color(232, 182, 23));
					pestBubble.setBackground(new Color(230, 187, 79));
				}else {
					pestBubble.setBackground(new Color(232, 182, 23));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(heap.isVisible() == true || qk.isVisible() == true) {
					pestHeap.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestQuick.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestBubble.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					pestBubble.setBackground(new Color(230, 187, 79));
					pestQuick.setBackground(new Color(232, 182, 23));
					pestHeap.setBackground(new Color(232, 182, 23));
					bubble.setVisible(true);
					heap.setVisible(false);
					qk.setVisible(false);
					
					System.out.println("el panel bubble es visible? "+bubble.isVisible());
				}
			}
		});
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
		pestQuick.setBounds(113, 33, 103, 32);
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
				if(heap.isVisible() == false && bubble.isVisible() ==  false) {
					pestBubble.setBackground(new Color(232, 182, 23));
					pestHeap.setBackground(new Color(232, 182, 23));
					pestQuick.setBackground(new Color(230, 187, 79));
				}else {
					pestQuick.setBackground(new Color(232, 182, 23));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(heap.isVisible() == true || bubble.isVisible() == true) {
					pestHeap.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestBubble.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestQuick.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					pestQuick.setBackground(new Color(230, 187, 79));
					pestBubble.setBackground(new Color(232, 182, 23));
					pestHeap.setBackground(new Color(232, 182, 23));
					qk.setVisible(true);
					bubble.setVisible(false);
					heap.setVisible(false);
					System.out.println("el panel quick es visible? "+qk.isVisible());
				}
			}
		});
		pestQuick.setBackground(new Color(232, 182, 23));
		PanelControl.add(pestQuick);
		pestQuick.setLayout(null);
		
		JLabel lblQuickSort = new JLabel("QuickSort");
		lblQuickSort.setBounds(0, 0, 103, 32);
		pestQuick.add(lblQuickSort);
		lblQuickSort.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuickSort.setForeground(new Color(33, 44, 61));
		lblQuickSort.setFont(new Font("Sitka Small", Font.BOLD, 15));
		pestHeap.setBounds(0, 33, 103, 32);
		pestHeap.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pestHeap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(heap.isVisible()==false) {
					pestHeap.setBackground(new Color(197, 152, 20));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(qk.isVisible() == false && bubble.isVisible() ==  false) {
					pestBubble.setBackground(new Color(232, 182, 23));
					pestQuick.setBackground(new Color(232, 182, 23));
					pestHeap.setBackground(new Color(230, 187, 79));
				}else {
					pestHeap.setBackground(new Color(232, 182, 23));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(qk.isVisible() == true || bubble.isVisible() == true) {
					pestQuick.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestBubble.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestHeap.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					pestHeap.setBackground(new Color(230, 187, 79));
					pestBubble.setBackground(new Color(232, 182, 23));
					pestQuick.setBackground(new Color(232, 182, 23));
					heap.setVisible(true);
					bubble.setVisible(false);
					qk.setVisible(false);
					System.out.println("el panel heap es visible? "+heap.isVisible());
				}
			}
		});
		pestHeap.setBackground(new Color(230, 187, 79));
		PanelControl.add(pestHeap);
		pestHeap.setLayout(null);
		
		JLabel lblHeap = new JLabel("HeapSort");
		lblHeap.setBounds(0, 0, 103, 32);
		pestHeap.add(lblHeap);
		lblHeap.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeap.setForeground(new Color(33, 44, 61));
		lblHeap.setFont(new Font("Sitka Small", Font.BOLD, 15));
		
		JPanel pestBusBinaria = new JPanel();
		pestBusBinaria.setBounds(339, 33, 160, 32);
		pestBusBinaria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(busBin.isVisible()==false) {
					pestBusBinaria.setBackground(new Color(197, 152, 20));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(qk.isVisible() == false || bubble.isVisible() ==  false || heap.isVisible() == false) {
					pestBubble.setBackground(new Color(232, 182, 23));
					pestQuick.setBackground(new Color(232, 182, 23));
					pestBusBinaria.setBackground(new Color(232, 182, 23));
				}else {
					pestBusBinaria.setBackground(new Color(232, 182, 23));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(qk.isVisible() == true || bubble.isVisible() == true) {
					pestQuick.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestBubble.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestBusBinaria.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					pestBusBinaria.setBackground(new Color(230, 187, 79));
					pestBubble.setBackground(new Color(232, 182, 23));
					pestQuick.setBackground(new Color(232, 182, 23));
					busBin.setVisible(true);
					bubble.setVisible(false);
					qk.setVisible(false);
					System.out.println("el panel busqueda binaria es visible? "+busBin.isVisible());
				}
			}
		});
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
		
		JPanel pestBusSecuencial = new JPanel();
		pestBusSecuencial.setBounds(509, 33, 189, 32);
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
		
		JPanel pestBusRandom = new JPanel();
		pestBusRandom.setBounds(708, 33, 189, 32);
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
				if(boton == 1) {
					ventana.setState(JFrame.ICONIFIED);
				}else {
					System.exit(0);
				}
			}
		});
	}

	
	public static synchronized void suspenderHilo() {
		Animaciones.suspender = true;
	}
	
	public static synchronized void reanudarHilo() {
		Animaciones.suspender = false;
		Thread.currentThread().notify();
	}
	
	static ImageIcon cerrarBlanco = new ImageIcon(Princ.class.getResource("/Image/icons8_close_window_30px_1.png"));
	static ImageIcon cerrarGris = new ImageIcon(Princ.class.getResource("/Image/icons8_close_window_30px_5.png"));
	static ImageIcon cerrarAmarillo = new ImageIcon(Princ.class.getResource("/Image/icons8_close_window_30px_8.png"));
	static ImageIcon minimizarBlanco = new ImageIcon(Princ.class.getResource("/Image/icons8_minimize_window_30px_1.png"));
	static ImageIcon minimizarAmarillo = new ImageIcon(Princ.class.getResource("/Image/icons8_minimize_window_30px_4.png"));
	static ImageIcon minimizarGris = new ImageIcon(Princ.class.getResource("/Image/icons8_minimize_window_30px_5.png"));
	
	static JPanel pestHeap = new JPanel();
}
	