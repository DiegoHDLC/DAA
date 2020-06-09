package procesos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JLabel;
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
	
	public static ArrayList<Integer> crearLista(int tamano) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < tamano;i++) {
			int numero = i;
			list.add(numero);
		}
		return (ArrayList<Integer>) list;
	}
	
	public static void crearListaCero() {
		for(int i = 0; i < 11; i++) {
			lista.add(i);
		}
		QuickSort.imprimirListaNumerica(lista);
	}
	
	public static ArrayList<Integer> crearListaRandom(int tamanoLista) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < tamanoLista;i++) {
			int numero = (int) Math.floor(Math.random()*99+1);
			list.add(numero);
		}
		Princ.txtMensaje.setText("Lista de tamaño "+"["+tamanoLista+"]"+" creada con éxito");
		return (ArrayList<Integer>) list;
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
	
	public static void imprimirListaNumericaDeLabels(List<JLabel> a) {
		for(int i = 0; i < a.size(); i++) {
			System.out.print("["+a.get(i).getText()+"] ");
		}
		System.out.print("\n");
	}
	
	public static int verificarPos(List<Integer> listaNumerica) {
		int posicion = 0;
		for(int i = 0;i < listaNumerica.size();i++) {
			if(listaNumerica.get(i)==null);
				posicion = i;
		}
		return posicion+1;
	}
	
	public static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }
	
	public static Boolean verificaOrd(ArrayList<Integer> a) {
		List<Integer> tmp = new ArrayList<Integer>(a);
		Collections.sort(tmp);
		boolean sorted = tmp.equals(a);
		
		return sorted;
		
	}

	
	
}