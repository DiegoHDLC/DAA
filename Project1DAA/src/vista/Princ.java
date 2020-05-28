package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import procesos.Animaciones;
import procesos.Ordenamientos;

import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Princ {
	public static ArrayList<JLabel> numerosArreglo = new ArrayList<JLabel>();
	public static int n;
	public static int contadorNumeros;
	public static int TAMANOARREGLO = 11;
	public static ArrayList<JLabel> tmpsArreglo = new ArrayList<JLabel>();
	public static List<JLabel> listCuadrados;
	public static void main(String[] args) {
		initComponents();
	}
	
	@SuppressWarnings("deprecation")
	public static void initComponents() {
		JFrame ventana = new JFrame();
		ventana.getContentPane().setLayout(null);
		ventana.setBackground(new Color(235,137,4));
		//crear panel de control
		
		JPanel PanelControl = new JPanel();
		PanelControl.setBackground(new Color(218, 165, 32));
		PanelControl.setBounds(0, 0, 984, 87);
		ventana.getContentPane().add(PanelControl);
		PanelControl.setLayout(null);
		
		//crear Panel MergeSort
		MergeSort mer = new MergeSort();
		mer.setBounds(0, 132, 984, 429);
		ventana.getContentPane().add(mer);
		mer.setLayout(null);
		
		//crear Panel HeapSort
		
		heap.setBounds(0, 132, 984, 429);
		ventana.getContentPane().add(heap);
		heap.setBackground(new Color(235,137,4));
		ventana.getContentPane().add(heap);
		heap.setLayout(null);
		
		txtNum = new JTextField();
		txtNum.setText("");
		txtNum.setHorizontalAlignment(SwingConstants.CENTER);
		txtNum.setBackground(new Color(208, 121, 3));
		txtNum.setFont(new Font("Calibri", 3, 19));
		txtNum.setBounds(10, 11, 46, 35);
		heap.add(txtNum);
		txtNum.setColumns(10);
		
		btnAgregar.setBounds(66, 17, 89, 23);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNum.getText().isEmpty()) {
					txtMensaje.setText("Digite un n�mero");
					txtNum.requestFocus();
				}else {
					txtNum.requestFocus();
					txtMensaje.setText("");
					contadorNumeros++;
					if(listaNumerica.size()==numerosArreglo.size()-1) {
						txtNum.setEditable(false);
						btnAgregar.setEnabled(false);
						txtMensaje.setText("Lista llena, no puede agregar m�s n�meros.");
							
					}
					n = iniciarNumeros();
					System.out.println("lista label:");
					for(int i = 0; i < listaNumericaUsuario.size();i++) {
						System.out.print("[ "+listaNumericaUsuario.get(i).getText()+"], ");
					}
					
					System.out.println("\ncantidad de numeros label"+listaNumericaUsuario.size());
					System.out.println("numero final:"+listaNumericaUsuario.get(contadorNumeros).getText());
					System.out.println("posicion:"+contadorNumeros);
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
		});
		heap.add(btnAgregar);
		
		//BOTON ELIMINAR
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarNumeros();
			}
		});
		btnEliminar.setBounds(165, 17, 89, 23);
		heap.add(btnEliminar);
		
		JButton btnIntercambio = new JButton("Intercambio");
		btnIntercambio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Animaciones.animacionHeapSort(listaNumericaUsuario, listaNumerica, tmpsArreglo);
			}
		});
		btnIntercambio.setBounds(485, 104, 89, 23);
		heap.add(btnIntercambio);
		
		JButton btnPausar = new JButton("Pausar");
		btnPausar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pausarHilo();
			}
		});
		btnPausar.setBounds(264, 18, 89, 23);
		heap.add(btnPausar);
		
		JButton btnReanudar = new JButton("Reanudar");
		btnReanudar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pausarHilo();
			}
		});
		btnReanudar.setBounds(363, 18, 89, 23);
		heap.add(btnReanudar);
		
		//crear pesta�a MergeSort
		JPanel pestMerge = new JPanel();
		pestMerge.setBounds(103, 0, 103, 32);
		pestMerge.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pestMerge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(mer.isVisible()==false) {
					pestMerge.setBackground(new Color(197, 152, 20));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(heap.isVisible() == false) {
					pestHeap.setBackground(new Color(232, 182, 23));
					pestMerge.setBackground(new Color(230, 187, 79));
				}else {
					pestMerge.setBackground(new Color(232, 182, 23));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(heap.isVisible() == true) {
					pestHeap.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestMerge.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					pestMerge.setBackground(new Color(230, 187, 79));
					pestHeap.setBackground(new Color(232, 182, 23));
					mer.setVisible(true);
					heap.setVisible(false);
					System.out.println("el panel heap es visible? "+heap.isVisible());
				}
			}
		});
		pestMerge.setBackground(new Color(232, 182, 23));
		pestMerge.setBounds(113, 0, 103, 32);
		PanelControl.add(pestMerge);
		pestMerge.setLayout(null);
		
		JLabel lblMergeSort = new JLabel("MergeSort");
		lblMergeSort.setHorizontalAlignment(SwingConstants.CENTER);
		lblMergeSort.setBounds(0, 0, 103, 32);
		lblMergeSort.setForeground(new Color(33, 44, 61));
		lblMergeSort.setFont(new Font("Sitka Small", Font.BOLD, 15));
		pestMerge.add(lblMergeSort);
		
		
		
		//crear Pesta�a HeapSort
		pestHeap.setBounds(0, 0, 103, 32);
		pestHeap.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pestHeap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(mer.isVisible() == false) {
					pestHeap.setBackground(new Color(230, 187, 79));
				}else {
					pestHeap.setBackground(new Color(197, 152, 20));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(mer.isVisible() == true) {
					pestHeap.setBackground(new Color(232, 182, 23));
				}else {
					pestHeap.setBackground(new Color(230, 187, 79));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(mer.isVisible() == true) {
					pestMerge.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestHeap.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					pestHeap.setBackground(new Color(230, 187, 79));
					pestMerge.setBackground(new Color(232, 182, 23));
					heap.setVisible(true);
					mer.setVisible(false);
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
		
		contadorNumeros = -1;
		int posX = 20;
		for(int i=0;i< 11;i++) {
			JLabel cuadrado = new JLabel();
			cuadrado.setIcon(new ImageIcon(Princ.class.getResource("/Image/cuadrado.png")));
			cuadrado.setBounds(40*i+ posX, 130, 50, 50);
			heap.add(cuadrado);
		}
		
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
	
	public static synchronized void pausarHilo() {
		Animaciones.pausar = true;
		 //lo siguiente garantiza que un hilo suspendido puede detenerse.
		Animaciones.suspender = false;
		Thread.currentThread().notify();
	}
	
	public static synchronized void suspenderHilo() {
		Animaciones.suspender = true;
	}
	
	public static synchronized void reanudarHilo() {
		Animaciones.suspender = false;
		Thread.currentThread().notify();
	}
	public static int iniciarNumeros() {
		int n = moverNumero();
		txtNum.setText(null);
		agregarNumero(n);
		System.out.println(""+listaNumerica);
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
	
	public static int moverNumero() {
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
			txtMensaje.setText("No hay n�mero que eliminar");
			btnEliminar.setEnabled(false);
		}	
	}
	
	static int contadorCasillas;
	static ArrayList<JLabel> listaNumericaUsuario = new ArrayList<JLabel>();
	public static ArrayList<Integer> listaNumerica = new ArrayList<Integer>();
	private static JTextField txtNum;
	volatile static boolean ejecutar = true;
	static JPanel pestHeap = new JPanel();
	public static HeapSort heap = new HeapSort();
	public static JTextField txtMensaje = new JTextField();
	static JButton btnAgregar = new JButton("Agregar");
	static JButton btnEliminar = new JButton("Eliminar");
}
