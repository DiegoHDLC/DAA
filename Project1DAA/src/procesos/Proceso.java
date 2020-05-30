package procesos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vista.Princ;

public class Proceso {
	public static ArrayList<Integer> lista = new ArrayList<Integer>();
	
	public Proceso() {
		// TODO Auto-generated constructor stub
	}
	
	public static void crearListaCero() {
		for(int i = 0; i < 11; i++) {
			lista.add(0);
		}
		Princ.imprimirListaNumerica(lista);
	}
	
	
	public static void dormir(int tiempoDormir) {
		try {
			Thread.sleep(tiempoDormir);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	 public BufferedReader getBuffered(String link){

		    FileReader lector  = null;
		    BufferedReader br = null;
		    try {
		         File Arch=new File(link);
		        if(!Arch.exists()){
		           System.out.println("No existe el archivo");
		        }else{
		           lector = new FileReader(link);
		           br = new BufferedReader(lector);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return br;
	}
	
	
	/* public void readTxt(){
		 String ruta = "C:\\Users\\usuario\\Desktop\\archivo1.txt";
		    File f = new File(ruta);
		    FileWriter fw = new FileWriter(f);
		    BufferedWriter escritura = new BufferedWriter(fw);
		    for(int i=0;i<lista.size();i++){
		    	 escritura.write(Integer.toString(lista.get(i)));
		        escritura.newLine();

		    }
		    escritura.close();
		}
	 */
	 

}
