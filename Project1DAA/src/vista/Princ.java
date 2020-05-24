package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
	public static int n;
	public static int contadorNumeros;
	public static int TAMANOARREGLO = 11;
	public static ArrayList<JLabel> tmpsArreglo = new ArrayList<JLabel>();
	public static void main(String[] args) {
		initComponents();
	}
	
	@SuppressWarnings("deprecation")
	public static void initComponents() {
		JFrame ventana = new JFrame();
		ventana.getContentPane().setLayout(null);
		//crear panel de control
		;
		JPanel PanelControl = new JPanel();
		PanelControl.setBackground(new Color(218, 165, 32));
		PanelControl.setBounds(0, 0, 984, 87);
		ventana.getContentPane().add(PanelControl);
		PanelControl.setLayout(null);
		
		//crear Panel HeapSort
		
		heap.setBounds(0, 132, 984, 429);
		ventana.getContentPane().add(heap);
		heap.setLayout(null);
				
		//crear Panel MergeSort
		MergeSort mer = new MergeSort();
		mer.setBounds(0, 132, 984, 429);
		ventana.getContentPane().add(mer);
		mer.setLayout(null);
		
		//crear pestaña MergeSort
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
		
		
		
		//crear Pestaña HeapSort
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
		
		txtNum = new JTextField();
		txtNum.setText("");
		txtNum.setHorizontalAlignment(SwingConstants.CENTER);
		txtNum.setBackground(new Color(208, 121, 3));
		txtNum.setBounds(10, 11, 46, 35);
		heap.add(txtNum);
		txtNum.setColumns(10);
		ArrayList<JLabel> numerosArreglo = new ArrayList<JLabel>();
		
		for(int i = 0;i < TAMANOARREGLO; i++){
			JLabel label = new JLabel();
			label.setText(""+i);
			numerosArreglo.add(label);
			numerosArreglo.get(i).setBounds(30+(30*i), 345, 30, 14);
			heap.add(numerosArreglo.get(i));
		}
		
		for(int i = 0;i < TAMANOARREGLO; i++){
			JLabel lblTmp = new JLabel();
			lblTmp.setText("t"+i);
			tmpsArreglo.add(lblTmp);
			tmpsArreglo.get(i).setBounds(30+(30*i), 300, 30, 14);
			heap.add(tmpsArreglo.get(i));
		}
		
		
		contadorNumeros = -1;
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(66, 17, 89, 23);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNum.getText().isEmpty()) {
					txtMensaje.setText("Digite un número");
					txtNum.requestFocus();
				}else {
					txtNum.requestFocus();
					txtMensaje.setText("");
					contadorNumeros++;
					if(listaNumerica.size()==numerosArreglo.size()-1) {
						txtNum.setEditable(false);
						btnAgregar.setEnabled(false);
								txtMensaje.setText("Lista llena, no puede agregar más números.");
							
					}
					n = iniciarNumeros();
					//JLabel numeros = new JLabel(""+n);
					//listaNumericaUsuario.add(numeros);
					System.out.println("lista label:");
					for(int i = 0; i < listaNumericaUsuario.size();i++) {
						System.out.print("[ "+listaNumericaUsuario.get(i).getText()+"], ");
					}
					
					System.out.println("\ncantidad de numeros label"+listaNumericaUsuario.size());
					System.out.println("numero final:"+listaNumericaUsuario.get(contadorNumeros).getText());
					System.out.println("posicion:"+contadorNumeros);
					listaNumericaUsuario.get(contadorNumeros).setBounds(20, 50, 46, 14);
					heap.add(listaNumericaUsuario.get(contadorNumeros));
					new Thread() {
						public void run() {
							int y1 = listaNumericaUsuario.get(contadorNumeros).getLocation().y;
							int x1 = listaNumericaUsuario.get(contadorNumeros).getLocation().x;
							int pos = verificarPos();
							animacion(x1,y1,pos,listaNumericaUsuario.get(contadorNumeros));
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
		});
		btnEliminar.setBounds(165, 17, 89, 23);
		heap.add(btnEliminar);
		
		JButton btnOrdenarHeap = new JButton("Ordenar");
		btnOrdenarHeap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//imprimirListaNumericaUsuario(listaNumericaUsuario);
				Ordenamientos.HeapSort(listaNumerica,listaNumericaUsuario,tmpsArreglo);
				//imprimirListaNumerica(listaNumerica);
				//imprimirListaNumericaUsuario(listaNumericaUsuario);
			}
		});
		btnOrdenarHeap.setBounds(264, 17, 89, 23);
		heap.add(btnOrdenarHeap);
		
		JButton btnAnimacionHeap = new JButton("OrdAnimacion");
		btnAnimacionHeap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Animaciones.moverPrueba(listaNumericaUsuario, 0, 2);
			}
		});
		btnAnimacionHeap.setBounds(363, 17, 89, 23);
		heap.add(btnAnimacionHeap);
		
		JButton btnLevantar = new JButton("Levantar");
		btnLevantar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Animaciones.levantarNumero(listaNumericaUsuario, tmpsArreglo, 5);
				imprimirListaNumericaUsuario(listaNumericaUsuario);
			}
		});
		btnLevantar.setBounds(264, 70, 89, 23);
		heap.add(btnLevantar);
		
		JButton btnIzquierda = new JButton("Izquierda");
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Animaciones.moverDireccion(listaNumericaUsuario, tmpsArreglo, 0, 5, 0);
			}
		});
		btnIzquierda.setBounds(264, 104, 89, 23);
		heap.add(btnIzquierda);
		
		JButton btnDerecha = new JButton("Derecha");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Animaciones.moverDireccion(listaNumericaUsuario, tmpsArreglo, 9, 5,1);
			}
		});
		btnDerecha.setBounds(363, 104, 89, 23);
		heap.add(btnDerecha);
		
		JPanel pnlMensajes = new JPanel();
		pnlMensajes.setBounds(0, 86, 984, 46);
		ventana.getContentPane().add(pnlMensajes);
		pnlMensajes.setBackground(new Color(208, 121, 3));
		pnlMensajes.setLayout(null);
		
		txtMensaje = new JTextField();
		txtMensaje.setFont(new Font("Sitka Small", Font.BOLD, 15));
		txtMensaje.setEditable(false);
		txtMensaje.setBackground(new Color(208, 121, 3));
		txtMensaje.setBounds(0, 0, 984, 46);
		pnlMensajes.add(txtMensaje);
		txtMensaje.setColumns(10);
		
		
		ventana.setSize(1000,600);
		ventana.setVisible(true);
	}
		
	public static int iniciarNumeros() {
		int n = moverNumero();
		
		txtNum.setText(null);
		
		agregarNumero(n);
		System.out.println(""+listaNumerica);
		System.out.println("cantidad de numeros:"+listaNumerica.size());
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
	
	public static void animacion(int x, int y, int pos, JLabel prueba1) {
		while(ejecutar) {
			if(x<=30*pos) {
				x++;
				prueba1.setLocation(x, y);
					if(x==30*pos) {
						while(y<320) {
							y++;
							prueba1.setLocation(x, y);
							try {
								Thread.sleep(5);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
			}
			
			try {
				Thread.sleep(5);
			} catch (Exception e2) {
				// TODO: handle exception
			}			
		}
		
	}
	
	public void detener() {
	    ejecutar = false;
	}
	
	public static void imprimirListaNumericaUsuario(List<JLabel> a) {
		for(int i = 0; i < a.size(); i++) {
			
			System.out.print("["+a.get(i).getText()+"] ");
		}
		System.out.print("\n");
	}
	
	public static void agregarNumero(int n) {
		listaNumerica.add(n);
		JLabel numero = new JLabel();
		numero.setText(""+n);
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
	static ArrayList<JLabel> listaNumericaUsuario = new ArrayList<JLabel>();
	static ArrayList<Integer> listaNumerica = new ArrayList<Integer>();
	private static JTextField txtNum;
	volatile static boolean ejecutar = true;
	static JPanel pestHeap = new JPanel();
	public static HeapSort heap = new HeapSort();
	private static JTextField txtMensaje;
	static JButton btnEliminar = new JButton("Eliminar");
}
