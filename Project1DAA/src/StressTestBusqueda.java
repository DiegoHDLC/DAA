import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import procesos.Busqueda;
import procesos.Proceso;

class StressTestBusqueda {
	
	public ArrayList<Integer> crearArreglo() {
		int tamano =  (int) Math.pow(2,20); //100.000.000
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < tamano;i++) {
				int numero = i;
				list.add(numero);
			}
			return list;
	}
	
	@Test
	public void BusquedaBinaria() {
		Busqueda.numComparaciones = 0;
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista = crearArreglo();
		Busqueda.binarySearch(lista, 50, 0, lista.size()-1);
		System.out.println("comparaciones: "+Busqueda.numComparaciones);
	}
	
	@Test
	public void BusquedaSecuencial() {
		Busqueda.numComparaciones = 0;
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista = crearArreglo();
		Busqueda.busquedaSecuencial(lista, 50);
		System.out.println("comparaciones: "+Busqueda.numComparaciones);
		
	}

}
