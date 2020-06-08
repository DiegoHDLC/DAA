package procesos;

import java.awt.Label;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JLabel;
import javax.swing.JList;

import vista.QuickSort;
import vista.Princ;


public class Animaciones implements Runnable{
	public static boolean suspender = false;
	public static boolean pausar = false;
	public volatile static List<JLabel> b;
	public static ArrayList<JLabel> a;
	public static ArrayList<Integer> lInt;
	ArrayList<JLabel> tmp;
	static int destino;
	static int posNum;
	static int direccion;
	public static int contadorNumeros;
	
	@Override
	public void run() {
		animacionLevantarNumero(a, tmp, posNum, destino, direccion);
		animacionDeLadoNumero(a, tmp, destino, posNum, direccion-1);
	}
	public List<JLabel>devuelve() {
		return a;
	}
	
	public static void colocarNumeroEnArreglo(int x, int y, int posObjetivo, JLabel numero, ArrayList<JLabel> listTmp) {	
		System.out.println("El estado del hilo al empezar: "+ Thread.currentThread().isInterrupted());
	
		while(!Thread.currentThread().isInterrupted()) {
			if(x<=40*posObjetivo) {
				x++;
				numero.setLocation(x, y);
					if(x==40*posObjetivo) {
						while(y<listTmp.get(1).getY()+20) {
							y++;
							numero.setLocation(x, y);
							if(y == listTmp.get(1).getY()+20) {Thread.currentThread().interrupt();}
							Proceso.dormir(3);
						}
					}
			}
			Proceso.dormir(3);
		}
		System.out.println("El estado del hilo al terminar: "+ Thread.currentThread().isInterrupted());
}
	
	public static void animacionQuickSort(ArrayList<JLabel> a, ArrayList<Integer> listInt, ArrayList<JLabel> tmp) {
		while(!Thread.currentThread().isInterrupted()) {
			for(int i = 0; i<9;i++) {
				animQuickSort(listInt, a, tmp, 0, listInt.size()-1);
			
				QuickSort.imprimirListaNumerica(listInt);
				Proceso.dormir(4000);
			}
		}
	}
	
	public static void animacionHeapSort(ArrayList<JLabel> a, ArrayList<Integer> lisInt, ArrayList<JLabel> tmp) {
		new Thread() {
			public void run() {
				while(!Thread.currentThread().isInterrupted()) {
						for(int i = 0; i<9;i++) {
							animHeap(lisInt,a, tmp);
							QuickSort.imprimirListaNumerica(lisInt);
							Proceso.dormir(4000);
						}
				}
			}
			
		}.start();
		
	}
	public static void animacionIntercambio(ArrayList<JLabel> a, ArrayList<JLabel> tmp, int pos, int destino, int direccion) {
				animacionLevantarNumero(a, tmp, pos, destino, direccion);
				animacionDeLadoNumero(a, tmp, destino, pos, direccion-1);
	}
	public static void animacionBajar(ArrayList<JLabel> a, ArrayList<JLabel> tmp, int pos, int destino, int direccion){
		new Thread() {
			public void run() {
				bajar(a,tmp,pos,destino,direccion);
			}
		}.start();
	}
	
	public static void animacionDeLadoNumero(ArrayList<JLabel> a, ArrayList<JLabel> tmp, int pos, int destino, int direccion) {
		new Thread() {
			public void run() {
				moverDeLadoNumero(a, tmp, pos, destino,direccion,0);
			}
		}.start();
	}
	
	public static ArrayList<JLabel> animacionLevantarNumero(ArrayList<JLabel> a, ArrayList<JLabel> tmp, int pos, int destino, int direccion) {
		new Thread() {
			public void run() {
					levantarNumero(a, tmp, pos,destino,direccion);
			}
		}.start();
		return a;
			
	}
	public static List<JLabel> bajar(ArrayList<JLabel> a, ArrayList<JLabel> tmp, int pos, int destino, int direccion) {
				int x = a.get(pos).getX();
				int y = a.get(pos).getY();
				System.out.println("El estado del hilo al empezar-vvv "+ Thread.currentThread().isInterrupted());
				while(!Thread.currentThread().isInterrupted()) {
					for(int i = 0; i < 20; i++) {
						y++;
						a.get(pos).setLocation(x, y);
						
						
						if(y==tmp.get(1).getY()+20) {
							Thread.currentThread().interrupt();
						}
						Proceso.dormir(3);
					}	
				}
				JLabel tmp2 = a.get(pos);
				a.set(pos, a.get(destino));
				a.set(destino, tmp2);
				System.out.println("El estado del hilo al empezar-vvv "+ Thread.currentThread().isInterrupted());
				QuickSort.imprimirListaNumericaDeLabels(a);
				return a;
				
				
	}
	
	public static void levantarNumero(ArrayList<JLabel> a, ArrayList<JLabel> tmp, int pos, int destino, int direccion) {
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
				Proceso.dormir(3);
			}	
		}
		animacionDeLadoNumero(a, tmp, pos, destino, direccion);
		
		System.out.println("El estado del hilo al empezar-^^^ "+ Thread.currentThread().isInterrupted());
	
}
	
	
	public static void moverDeLadoNumero(ArrayList<JLabel> a, ArrayList<JLabel> tmp, int posNum, int destino, int direccion, int ordBus) {
				
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
							Proceso.dormir(5);
						}
					}else {
						while(x<xTmp) {
							x++;
							a.get(posNum).setLocation(x, y);
							if(x == xTmp) {Thread.currentThread().interrupt();}
							Proceso.dormir(5);
						}
						if(ordBus == 0) {
							animacionBajar(a, tmp, posNum,destino,direccion);
						}
						}
				}
		System.out.println("El estado del hilo al terminar->>> "+ Thread.currentThread().isInterrupted());
		
	}

	
	
	public static void animHeap(ArrayList<Integer> listInt, ArrayList<JLabel> listLabel, ArrayList<JLabel> tmp) {
		int n = listInt.size();
		  
	      // Build max heap
	      for (int i = n / 2 - 1; i >= 0; i--) {
	    	  if(Proceso.verificaOrd(listInt)) {
		        	Princ.txtMensaje.setText("Lista ordenada correctamete");
		        	Proceso.dormir(3000);
		        	Thread.currentThread().interrupt();
		        	break;
	    	  }else {
	    		  animHeapify(listInt, listLabel, tmp, n, i);
	    	  }
	      }
	  
	      // Heap sort
	      for (int i = n - 1; i > 0; i--) {
	    	  if(Proceso.verificaOrd(listInt)) {
		        	Princ.txtMensaje.setText("Lista ordenada correctamete");
		        	Proceso.dormir(3000);
		        	Thread.currentThread().interrupt();
		        	break;
		        }else {
		        	if(Proceso.verificaOrd(listInt)) {
			        	Princ.txtMensaje.setText("Lista ordenada correctamete");
			        	Proceso.dormir(3000);
			        	Thread.currentThread().interrupt();
			        	break;
		        	}else {
			        	System.out.println("Entra al animHeap");
				    	animacionIntercambio(listLabel, tmp, 0, i, 1);
				        int temp = listInt.get(0);
				        listInt.set(0, listInt.get(i));
				        listInt.set(i, temp);
				        Proceso.dormir(3000);
				        // Heapify root element
				        animHeapify(listInt,listLabel,tmp, i, 0);
		        	}
		        }
	      }
	}
	
	public static void animHeapify(ArrayList<Integer> listInt, ArrayList<JLabel> listLabel, ArrayList<JLabel> tmp, int n, int i) {
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
	    	  if(Proceso.verificaOrd(listInt)) {
	    		  Princ.txtMensaje.setText("Lista ordenada correctamete");
		        	Proceso.dormir(2000);
		        	Thread.currentThread().interrupt();
		        	//Thread.currentThread().interrupt();
		        }else {
				    	int n1 = verificaMenor(i, largest);
				    	int n2 = verificaMayor(i, largest);
				    	animacionIntercambio(listLabel, tmp, n1, n2, 1);
				        int swap = listInt.get(i);
				        listInt.set(i, listInt.get(largest));
				        listInt.set(largest, swap);
				        if(Proceso.verificaOrd(listInt)) {
				        	Princ.txtMensaje.setText("Lista ordenada correctamete");
				        	Proceso.dormir(2000);
				        	Thread.currentThread().interrupt();
				        	//Thread.currentThread().interrupt();
				        }
				        else{
				        Proceso.dormir(3000);
				        animHeapify(listInt,listLabel, tmp, n, largest);
				        }
		        }
	      }
	}
	
static int partition(ArrayList<Integer> listInt,ArrayList<JLabel> listLabel, ArrayList<JLabel> listTmp, int low, int high) {
        
        // Select the pivot element
        int pivot = listInt.get(high);
        int i = (low - 1);

        // Put the elements smaller than pivot on the left and 
        // greater than pivot on the right of pivot
        for (int j = low; j < high; j++) {
          if (listInt.get(j) <= pivot) {
            i++;
            int n1 = verificaMenor(i, j);
	    	int n2 = verificaMayor(i, j);
            animacionIntercambio(listLabel, listTmp, n1, n2, 1);
            int temp = listInt.get(i);
            listInt.set(i, listInt.get(j));
            listInt.set(j, temp);
            if(Proceso.verificaOrd(listInt)) {Thread.currentThread().interrupt();}
            Proceso.dormir(3000);
          }
        }
        int n1 = verificaMenor(i, high);
    	int n2 = verificaMayor(i, high);
        animacionIntercambio(listLabel, listTmp, n1, n2, 1);
        int temp = listInt.get(i+1);
        listInt.set(i+1, listInt.get(high));
        listInt.set(high, temp);
        if(Proceso.verificaOrd(listInt)) {Thread.currentThread().interrupt();}
        return (i + 1);
      }

      public static void animQuickSort(ArrayList<Integer> listInt,ArrayList<JLabel> listLabel, ArrayList<JLabel> listTmp, int low, int high) {
        if (low < high) {

          // Select pivot position and put all the elements smaller 
          // than pivot on left and greater than pivot on right
          int pi = partition(listInt,listLabel,listTmp, low, high);
          
          // Sort the elements on the left of pivot
          animQuickSort(listInt,listLabel, listTmp, low, pi - 1);

          // Sort the elements on the right of pivot
          animQuickSort(listInt,listLabel, listTmp, pi + 1, high);
        }
      }
	
      public static int binarySearch(ArrayList<Integer> listInt , ArrayList<JLabel> listLabel, ArrayList<JLabel> listTmp, ArrayList<JLabel> labelX, int x, int low, int high) {
    	  	
    	    if (high >= low) {
    	      int mid = low + (high - low) / 2;
    	     labelX.get(0).setLocation(listTmp.get(mid).getX(), listTmp.get(mid).getY()-30);
    	      // If found at mid, then return it
    	      if (listInt.get(mid) == x) {
    	        return mid;
    	      }
    	      // Search the left half
    	      if (listInt.get(mid) > x) {
    	    	animacionDeLadoNumero(labelX, listTmp, 0, mid, 0);
    	      	Proceso.dormir(2000);
    	        return binarySearch(listInt,listLabel,listTmp, labelX, x, low, mid - 1);
    	      }
    	        else {
    	      // Search the right half
    	        animacionDeLadoNumero(labelX, listTmp, 0, mid, 1);
    	        Proceso.dormir(2000);
    	      return binarySearch(listInt,listLabel,listTmp, labelX, x, mid + 1, high);
    	        }
    	    
    	    }
    	    return -1;
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