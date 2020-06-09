import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class StressTestCrearArreglo {

	
	public void crearArregloRandom(int tamano) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < tamano;i++) {
			int numero = (int) Math.floor(Math.random()*99+1);
			list.add(numero);
		}
	}
	
	@Test
	public void probandoArreglo() {
		crearArregloRandom(100000);//100.000 datos
		crearArregloRandom(500000);//500.000 datos
		crearArregloRandom(1000000);//1.000.000
		
		
	}

}
