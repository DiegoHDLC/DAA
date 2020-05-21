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

public class Princ {
	static ArrayList<Integer> listaNumerica = new ArrayList<Integer>();
	private static JTextField txtNum;
	volatile static boolean ejecutar = true;

	
	public static void main(String[] args) {
		initComponents();
		
	}
	
	public static void initComponents() {
		HeapSort heap = new HeapSort();
		heap.setBounds(0, 0, 984, 561);
		JFrame ventana = new JFrame();
		ventana.getContentPane().setLayout(null);
		ventana.getContentPane().add(heap);
		heap.setLayout(null);
		
		JLabel lblHeap = new JLabel("HeapSort");
		lblHeap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
		MergeSort mer = new MergeSort();
		mer.setBounds(0, 0, 984, 561);
		ventana.getContentPane().add(mer);
		mer.setLayout(null);
		
		JLabel lblHeap1 = new JLabel("HeapSort");
		lblHeap1.setBounds(10, 70, 86, 14);
		heap.add(lblHeap1);
		
		txtNum = new JTextField();
		txtNum.setBounds(10, 107, 86, 20);
		heap.add(txtNum);
		txtNum.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(106, 106, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = moverNumero();
				JLabel prueba = new JLabel(""+n);
				prueba.setBounds(10, 130, 46, 14);
				txtNum.setText(null);
				heap.add(prueba);
				agregarNumero(n);
				System.out.println(""+listaNumerica);
				System.out.println(""+listaNumerica.size());
				int pos = listaNumerica.size();
				new Thread() {
					public void run() {
						
						int y = prueba.getLocation().y;
						int x = prueba.getLocation().x;
						while(ejecutar) {
							if(x<=30*pos) {
							x++;
							prueba.setLocation(x, y);
								if(x==30*pos) {
									while(y<320) {
										y++;
										prueba.setLocation(x, y);
										try {
											sleep(5);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								}
							}
							
							try {
								sleep(5);
							} catch (Exception e2) {
								// TODO: handle exception
							}					
						}			
					}
				}.start();
			}
		});
		heap.add(btnNewButton);
		
		int posX = 30;
		for(int i = 0;i<10;i++) {
			JLabel label = new JLabel(""+i);
			label.setBounds(posX, 350, 50, 14);
			posX = posX + 30;
			heap.add(label);
		}
		
		ventana.setSize(1000,600);
		ventana.setVisible(true);
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
}