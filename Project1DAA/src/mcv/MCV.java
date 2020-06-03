package mcv;

import modelo.Modelo;
import procesos.Control;
import vista.BusquedaBinaria;
import vista.HeapSort;
import vista.Principal;

public class MCV {
	
	public static void main(String args[]) {
		Principal p1 = new Principal();
        Modelo modelo  = new Modelo();
        HeapSort heap = new HeapSort();
        Control c = new Control(p1, modelo, heap);
        c.iniciar();
    }
}
