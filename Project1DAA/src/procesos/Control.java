package procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelo.Modelo;
import vista.BusquedaBinaria;
import vista.HeapSort;
import vista.Princ;
import vista.Principal;

public class Control implements ActionListener{
	
	private Principal prueba;
	private Modelo modelo;
	private HeapSort heap;
	
	public Control(Principal prueba, Modelo modelo, HeapSort heap) {
		this.heap = heap;
		this.prueba = prueba;
		this.modelo = modelo;
		
		HeapSort.btnAgregar.addActionListener( (ActionListener) this);
		HeapSort.btnEliminar.addActionListener(this);
	}
	
	public void iniciar() {
		prueba.getContentPane().add(heap);
		prueba.setSize(897, 549);
		prueba.setLocationRelativeTo(null);
		prueba.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent eve) {
		
	}
	
	
}
