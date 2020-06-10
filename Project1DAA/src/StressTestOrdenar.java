import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import procesos.Ordenamientos;

class StressTestOrdenar {

	
	public List<Integer> crearArreglo() {
		int tamano = 100000; //100.000.000
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < tamano;i++) {
				int numero = (int) Math.floor(Math.random()*99+1);
				list.add(numero);
			}
			return list;
	}
	
	//@Test
	public void HeapSort() { //66,828 segundos con 100.000.000 de datos
		List<Integer> list = new ArrayList<Integer>();
		list = crearArreglo();
		Ordenamientos.heapSort(list);
	}
	
	//@Test
	public void QuickSort() { //42,897 segundos con 1.000.000 de datos
		List<Integer> list = new ArrayList<Integer>();
		list = crearArreglo();
		Ordenamientos.quickSort(list, 0, list.size()-1);
	}
	
	@Test
	public void BubbleSort() {//48,149 segundos con 100.000 datos
		List<Integer> list = new ArrayList<Integer>();
		list = crearArreglo();
		Ordenamientos.bubbleSort(list);
	}
	
	
}


