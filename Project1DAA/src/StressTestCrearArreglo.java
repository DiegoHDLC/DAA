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
		//crearArregloRandom(100000);//100.000 datos
		//crearArregloRandom(500000);//500.000 datos
		//crearArregloRandom(1000000);//1.000.000 datos
		//crearArregloRandom(10000000);//10.000.000 datos
		//crearArregloRandom(25000000);//25.000.000
		//crearArregloRandom(30000000);//30.000.000
		//crearArregloRandom(50000000);//50.000.000 datos
		crearArregloRandom(100000000);//100.000.000 datos 35,957 segundos
		
		//Java heap space
		//crearArregloRandom(110000000);//110.000.000 datos
		//crearArregloRandom(125000000);//125.000.000 datos
		//crearArregloRandom(150000000);//150.000.000 datos
		//crearArregloRandom(250000000);//250.000.000 datos
		//crearArregloRandom(500000000);//500.000.000 datos
		//crearArregloRandom(1000000000);//1.000.000.000 datos
	}

}
