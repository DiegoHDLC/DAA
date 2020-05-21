package vista;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Princ {
	static ArrayList<Integer> listaNumerica = new ArrayList<Integer>();
	private static JTextField txtNum;

	
	public static void main(String[] args) {
		initComponents();
		
	}
	
	public static void initComponents() {
		unCuadrado dib = new unCuadrado();
		dib.setBounds(0, 0, 984, 561);
		JFrame ventana = new JFrame();
		ventana.getContentPane().setLayout(null);
		ventana.getContentPane().add(dib);
		dib.setLayout(null);
		
		JLabel lblHeap = new JLabel("HeapSort");
		lblHeap.setBounds(10, 70, 46, 14);
		dib.add(lblHeap);
		
		txtNum = new JTextField();
		txtNum.setBounds(10, 107, 86, 20);
		dib.add(txtNum);
		txtNum.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = moverNumero();
				System.out.println(""+listaNumerica);
				System.out.println(""+listaNumerica.size());
				JLabel prueba = new JLabel(""+n);
				prueba.setBounds(30, 130, 46, 14);
				txtNum.setText(null);
				dib.add(prueba);
				agregarNumero(n);
				new Thread() {
					public void run() {
						
						int y = prueba.getLocation().y;
						int x = prueba.getLocation().x;
						while(true) {
							x++;
							if( x == ) {
								x = 0;
							}
							prueba.setLocation(x, y);
							try {
								sleep(10);
							} catch (Exception e2) {
								// TODO: handle exception
							}
							
						}
						
						
					}
				}.start();
			}
		});
		btnNewButton.setBounds(106, 106, 89, 23);
		dib.add(btnNewButton);
		
		
		
		int posX = 40;
		for(int i = 0;i<10;i++) {
			JLabel label = new JLabel("       "+i);
			label.setBounds(posX, 350, 50, 14);
			posX = posX + 50;
			dib.add(label);
		}
		
		ventana.setSize(1000,600);
		ventana.setVisible(true);
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