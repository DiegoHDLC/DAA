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

import vista.QuickSort;
import vista.Princ;

public class Proceso {
	public static ArrayList<Integer> lista = new ArrayList<Integer>();
	
	public Proceso() {
		// TODO Auto-generated constructor stub
	}
	
	public static void crearListaCero() {
		for(int i = 0; i < 11; i++) {
			lista.add(i);
		}
		QuickSort.imprimirListaNumerica(lista);
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