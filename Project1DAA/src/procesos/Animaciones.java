package procesos;

import java.util.List;
import java.util.ListIterator;

import javax.swing.JLabel;

import vista.Princ;


public class Animaciones implements Runnable{
	public volatile static List<JLabel> b;
	public static List<JLabel> a;
	public static List<Integer> lInt;
	List<JLabel> tmp;
	static int destino;
	static int posNum;
	static int direccion;
	
	@Override
	public void run() {
		animacionLevantarNumero(a, tmp, posNum, destino, direccion);
		animacionDeLadoNumero(a, tmp, destino, posNum, direccion-1);
	}
	public List<JLabel>devuelve() {
		return a;
	}
	
	public static void variosIntercambios(List<JLabel> a, List<Integer> lisInt, List<JLabel> tmp) {
		new Thread() {
			public void run() {
				while(!Thread.currentThread().isInterrupted()) {
						for(int i = 0; i<9;i++) {
							
							animHeap(lisInt,a, tmp);
							
							Princ.imprimirListaNumerica(lisInt);
						
							try {
								Thread.sleep(4000);
							} catch (Exception e) {
								Thread.currentThread().interrupt();
							}
							
						}
						
					
				}
			}
			
		}.start();
		
	}
	public static void animacionIntercambio(List<JLabel> a, List<JLabel> tmp, int pos, int destino, int direccion) {
		
				animacionLevantarNumero(a, tmp, pos, destino, direccion);
				animacionDeLadoNumero(a, tmp, destino, pos, direccion-1);
			
		
	}
	public static void animacionBajar(List<JLabel> a, List<JLabel> tmp, int pos, int destino, int direccion){
		new Thread() {
			public void run() {
				bajar(a,tmp,pos,destino,direccion);
			}
		}.start();
	}
	
	public static void animacionDeLadoNumero(List<JLabel> a, List<JLabel> tmp, int pos, int destino, int direccion) {
		new Thread() {
			public void run() {
				moverDeLadoNumero(a, tmp, pos, destino,direccion);
			}
		}.start();
	}
	
	public static List<JLabel> animacionLevantarNumero(List<JLabel> a, List<JLabel> tmp, int pos, int destino, int direccion) {
		new Thread() {
			public void run() {
					levantarNumero(a, tmp, pos,destino,direccion);
			}
		}.start();
		return a;
			
	}
	public static List<JLabel> bajar(List<JLabel> a, List<JLabel> tmp, int pos, int destino, int direccion) {
				int x = a.get(pos).getX();
				int y = a.get(pos).getY();
				System.out.println("El estado del hilo al empezar-vvv "+ Thread.currentThread().isInterrupted());
				while(!Thread.currentThread().isInterrupted()) {
					//System.out.println("posicion0:"+a.get(0).getText());
					//System.out.println("posicion que entra: "+pos);
					for(int i = 0; i < 20; i++) {
						y++;
						a.get(pos).setLocation(x, y);
						if(y==tmp.get(1).getY()+20) {
							Thread.currentThread().interrupt();
						}
						Princ.dormir(3);
					}	
				}
				JLabel tmp2 = a.get(pos);
				a.set(pos, a.get(destino));
				a.set(destino, tmp2);
				System.out.println("El estado del hilo al empezar-vvv "+ Thread.currentThread().isInterrupted());
				Princ.imprimirListaNumericaDeLabels(a);
				return a;
				
				
	}
	
	public static void levantarNumero(List<JLabel> a, List<JLabel> tmp, int pos, int destino, int direccion) {
		int x = a.get(pos).getX();
		int y = a.get(pos).getY();
		int yTmp = tmp.get(pos).getY();
		System.out.println("El estado del hilo al empezar-^^^ "+ Thread.currentThread().isInterrupted());
		while(!Thread.currentThread().isInterrupted()) {
			for(int i = 0; i < 20; i++) {
				y--;
				a.get(pos).setLocation(x, y);
				if(y==yTmp) {
					Thread.currentThread().interrupt();
				}
				Princ.dormir(3);
			}	
		}
		animacionDeLadoNumero(a, tmp, pos, destino, direccion);
		
		System.out.println("El estado del hilo al empezar-^^^ "+ Thread.currentThread().isInterrupted());
	
}
	
	
	public static void moverDeLadoNumero(List<JLabel> a, List<JLabel> tmp, int posNum, int destino, int direccion) {
				
				int xTmp = tmp.get(destino).getX();
				int x = a.get(posNum).getX();
				int y = a.get(posNum).getY();
				System.out.println("El estado del hilo al empezar->>> "+ Thread.currentThread().isInterrupted());
				while(!Thread.currentThread().isInterrupted()) {
					if(direccion == 0) {
						while(x>xTmp) {
							x--;
							a.get(posNum).setLocation(x, y);
							if(x == xTmp) {
								Thread.currentThread().interrupt();
							}
							Princ.dormir(5);
						}
					}else {
						while(x<xTmp) {
							x++;
							a.get(posNum).setLocation(x, y);
							if(x == xTmp) {Thread.currentThread().interrupt();}
							Princ.dormir(5);
						}
						animacionBajar(a, tmp, posNum,destino,direccion);
					}
				}
		
		System.out.println("El estado del hilo al terminar->>> "+ Thread.currentThread().isInterrupted());
	}
	public static Boolean verificaOrd(List<Integer> a) {
		boolean ordenado = true;
		int n1;
		int n2;
		for (int i = 0; i < a.size(); i++) {
			n1 = a.get(i);
			n2 = a.get(i+1);
			if (i +1  <= a.size()) {
	            if (n1 > n2) {
	                ordenado = false;
	                break;
	            }
	        }
			 
	    }
		return ordenado;
	}
	
	
	public static void animHeap(List<Integer> listInt, List<JLabel> listLabel, List<JLabel> tmp) {
		int n = listInt.size();
		  
	      // Build max heap
	      for (int i = n / 2 - 1; i >= 0; i--) {
	        animHeapify(listInt, listLabel, tmp, n, i);
	      }
	  
	      // Heap sort
	      for (int i = n - 1; i > 0; i--) {
	    	
	    	animacionIntercambio(listLabel, tmp, 0, i, 1);
	        int temp = listInt.get(0);
	        listInt.set(0, listInt.get(i));
	        listInt.set(i, temp);
	        if(verificaOrd(listInt)) {
	        	Thread.currentThread().interrupt();
	        	break;
	        }
	        Princ.dormir(2000);
	  
	        // Heapify root element
	        animHeapify(listInt,listLabel,tmp, i, 0);
	      }
	}
	
	public static void animHeapify(List<Integer> listInt, List<JLabel> listLabel, List<JLabel> tmp, int n, int i) {
		 // Find largest among root, left child and right child
	      int largest = i;
	      int l = 2 * i + 1;
	      int r = 2 * i + 2;
	      
	      if (l < n && (listInt.get(l) > listInt.get(largest)))
	        largest = l;
	  
	      if (r < n && (listInt.get(r) > listInt.get(largest)))
	        largest = r;
	  
	      // Swap and continue heapifying if root is not largest
	      if(largest != i) {
	    	int n1 = verificaMenor(i, largest);
	    	int n2 = verificaMayor(i, largest);
	    	animacionIntercambio(listLabel, tmp, n1, n2, 1);
	        int swap = listInt.get(i);
	        listInt.set(i, listInt.get(largest));
	        listInt.set(largest, swap);
	        if(verificaOrd(listInt)) {
	        	Thread.currentThread().interrupt();
	        }
	        Princ.dormir(2000);
	        animHeapify(listInt,listLabel, tmp, n, largest);
	      }
	}
	
	public static int verificaMayor(int n1, int n2) {
		if(n1 > n2) {
			return n1;
		}else {
			return n2;
		}
	}
	public static int verificaMenor(int n1, int n2) {
		if(n1 < n2) {
			return n1;
		}else {
			return n2;
		}
	}
	
	public static void detener() {
	    ejecutar = false;
	}
	
	
	volatile static boolean ejecutar = true;
}
