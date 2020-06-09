import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import procesos.Busqueda;
import procesos.Proceso;

class BusquedaTest {

	@Test
	public void busquedaBinaria() {
		ArrayList<Integer> list = Proceso.crearLista(20);
		int numeroABuscar = 30;
		int resultado = Busqueda.binarySearch(list, numeroABuscar, 0, list.size()-1);
		int esperado = -1; //no encontrado
		assertEquals(esperado, resultado);
		
		numeroABuscar = 15;
		int noEsperado = -1;
		resultado = Busqueda.binarySearch(list, numeroABuscar, 0, list.size()-1);
		assertNotEquals(noEsperado, resultado);
		
	}
}
