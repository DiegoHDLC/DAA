package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.MergeSort;
import vista.Princ;

public class Boton extends JButton{
	/**
	 * 
	 */
	public static int contadorNumeros = -1;
	private static final long serialVersionUID = 1L;
	
	public Boton(String texto, int x, int y) {
		setText(texto);
		setBounds(x, y, 89, 23);
	}
	
	
	/*public void botonAgregar() {
		
		addActionListener(new ActionListener() {
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
					System.out.println("lista label:");
					for(int i = 0; i < listaNumericaUsuario.size();i++) {
						System.out.print("[ "+listaNumericaUsuario.get(i).getText()+"], ");
					}
					
					System.out.println("\ncantidad de numeros label"+listaNumericaUsuario.size());
					System.out.println("numero final:"+listaNumericaUsuario.get(contadorNumeros).getText());
					System.out.println("posicion:"+contadorNumeros);
					Princ.listaNumericaUsuario.get(contadorNumeros).setBounds(20, 50, 46, 14);
					MergeSort.add(Princ.listaNumericaUsuario.get(contadorNumeros),new Integer(1));
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
	}*/
	
	public void AgregarNumeros() {
		
	}
}
