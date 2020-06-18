import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JList;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import procesos.Busqueda;
import procesos.Ordenamientos;
import procesos.Proceso;
import vista.BusquedaBinaria2;

class OrdenTest {

	@Test
	public void ordenHeapSort() throws Exception {
		int resultado = 0;
		ArrayList<Integer> list = Proceso.crearListaRandom(20);
		ArrayList<Integer> tmp = list;
		Collections.sort(list);
		Ordenamientos.heapSort(tmp);
		
		 boolean isEqual = tmp.equals(list);
		 if(isEqual == true) {
			 resultado = 1;
		 }
		 else {
			 resultado = 0;
		 }
		 assertEquals(1, resultado);
	}
	
	@Test
	public void ordenQuickSort() throws Exception{
		int resultado = 0;
		ArrayList<Integer> list = Proceso.crearListaRandom(20);
		ArrayList<Integer> tmp = list;
		Collections.sort(list);
		Ordenamientos.quickSort(tmp, 0, tmp.size()-1);
		
		boolean isEqual = tmp.equals(list);
		 if(isEqual == true) {
			 resultado = 1;
		 }
		 else {
			 resultado = 0;
		 }
		 assertEquals(1, resultado);
	}
	
	@Test
	public void ordenBubbleSort() throws Exception{
		int resultado = 0;
		ArrayList<Integer> list = Proceso.crearListaRandom(20);
		ArrayList<Integer> tmp = list;
		Collections.sort(list);
		Ordenamientos.bubbleSort(list);
		
		boolean isEqual = tmp.equals(list);
		 if(isEqual == true) {
			 resultado = 1;
		 }
		 else {
			 resultado = 0;
		 }
		 assertEquals(1, resultado);
	}
	
	
}
 