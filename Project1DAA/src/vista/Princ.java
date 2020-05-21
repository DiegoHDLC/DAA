package vista;

import java.util.ArrayList;

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
import javax.swing.SwingConstants;

public class Princ {
	
	public static void main(String[] args) {
		initComponents();
	}
	
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
		txtNum.setHorizontalAlignment(SwingConstants.CENTER);
		txtNum.setBackground(new Color(208, 121, 3));
		txtNum.setBounds(10, 11, 46, 35);
		heap.add(txtNum);
		txtNum.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(66, 17, 89, 23);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listaNumerica.size()==9) {
					txtNum.setEditable(false);
					btnAgregar.setEnabled(false);
							txtMensaje.setText("Lista llena, no puede agregar m�s n�meros.");
						
				}
				int n = iniciarNumeros();
				JLabel prueba = new JLabel(""+n);
				prueba.setBounds(20, 50, 46, 14);
				heap.add(prueba);
				int pos = listaNumerica.size();
				new Thread() {
					public void run() {
						
						int y = prueba.getLocation().y;
						int x = prueba.getLocation().x;
						animacion(x,y,pos,prueba);
						
					}
				}.start();
			}
		});
		heap.add(btnAgregar);
		JLabel numerosArr[] = new JLabel[10];
		for(int i = 0;i < 10; i++){
			numerosArr[i]= new JLabel("" +(i));
			numerosArr[i].setBounds(30+(30*i), 345, 30, 14);
			heap.add(numerosArr[i]);
		}	
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//prueba(0)
			}
		});
		btnEliminar.setBounds(165, 17, 89, 23);
		heap.add(btnEliminar);
		
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
	
	public static void crearNumerosCasilla(){
		
	}
	
	public static int iniciarNumeros() {
		int n = moverNumero();
		
		txtNum.setText(null);
		
		agregarNumero(n);
		System.out.println(""+listaNumerica);
		System.out.println(""+listaNumerica.size());
		return n;
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
	
	public static void agregarNumero(int n) {
		listaNumerica.add(n);
	}
	
	public static int moverNumero() {
		int n;
		n = Integer.parseInt(txtNum.getText());
    	return n;
	}
	static ArrayList<Integer> listaNumerica = new ArrayList<Integer>();
	private static JTextField txtNum;
	volatile static boolean ejecutar = true;
	static JPanel pestHeap = new JPanel();
	static HeapSort heap = new HeapSort();
	private static JTextField txtMensaje;
}
