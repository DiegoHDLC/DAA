package procesos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JLayeredPane;

import vista.QuickSort;
import vista.HeapSort;
import vista.Princ;

public class Proceso {
	public static ArrayList<Integer> lista = new ArrayList<Integer>();
	static Princ principal = new Princ();
	
	public Proceso() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static void crearListaCero() {
		for(int i = 0; i < 11; i++) {
			lista.add(i);
		}
		QuickSort.imprimirListaNumerica(lista);
	}
	
	public static void crearListaRandom(int tamanoLista) {
		
		for(int i = 0; i < tamanoLista;i++) {
			int numero = (int) Math.floor(Math.random()*9+1);
			lista.add(numero);
		}
		Princ.txtMensaje.setText("Lista de tama�o "+"["+tamanoLista+"]"+" creada con �xito");
		HeapSort.imprimirListaNumerica(lista);
	}
	
	
	public static void dormir(int tiempoDormir) {
		try {
			Thread.sleep(tiempoDormir);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public static void leerArchivo(String direccion) {
		File ruta = new File(direccion);
		try {
			FileReader fi = new FileReader(ruta);
			BufferedReader bu = new BufferedReader(fi);
			
			String linea = null;
			while((linea = bu.readLine()) !=null) {
				StringTokenizer st = new StringTokenizer(linea,",");
				lista.add(Integer.parseInt(st.nextToken()));
			}
			bu.close();
		}catch (Exception ex) {
			
		}
		QuickSort.imprimirListaNumerica(lista);
	}
	
	
		
	

}