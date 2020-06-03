package modelo;

import java.util.ArrayList;

public class Modelo {
	ArrayList<Integer> listaNumerica = new ArrayList<Integer>();
	public Modelo() {
		
	}
	public ArrayList<Integer> getListaNumerica() {
		return listaNumerica;
	}
	public void setListaNumerica(ArrayList<Integer> listaNumerica) {
		this.listaNumerica = listaNumerica;
	}
	
	public void crearLista() {
		for(int i = 0; i< 10; i++) {
			listaNumerica.add(i);
		}
	}
}
