import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import procesos.Ordenamientos;

class StressTestOrdenar {

	
	public List<Integer> crearArreglo() {
		int tamano = 100000000; //100.000.000
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < tamano;i++) {
				int numero = (int) Math.floor(Math.random()*99+1);
				list.add(numero);
			}
			return list;
	}
	
	@Test
	public void HeapSort() {
		List<Integer> list = new ArrayList<Integer>();
		list = crearArreglo();
		Ordenamientos.heapSort(list);
	}
}


