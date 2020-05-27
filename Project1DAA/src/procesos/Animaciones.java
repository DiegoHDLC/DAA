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
						for(int i = 0; i<10;i++) {
							animHeap(lisInt,a, tmp);
							Princ.imprimirListaNumerica(lisInt);
							
							//animacionHeapSort(Princ.listaNumerica, a, tmp);
							try {
								Thread.sleep(2000);
							} catch (Exception e) {
								Thread.currentThread().interrupt();
							}
							;
						}
						if(verificaOrd(lisInt)) {
							Thread.currentThread().interrupt();
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
						if(y==320) {
							Thread.currentThread().interrupt();
						}
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt();
						}
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
			//System.out.println("posicion0:"+a.get(0).getText());
			//System.out.println("posicion que entra: "+pos);
			for(int i = 0; i < 20; i++) {
				y--;
				a.get(pos).setLocation(x, y);
				if(y==yTmp) {
					Thread.currentThread().interrupt();
				}
				try{
					Thread.sleep(5);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
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
							try {
								Thread.sleep(7);
							} catch (InterruptedException e) {
								Thread.currentThread().interrupt();
							}
						}
					}else {
						while(x<xTmp) {
							x++;
							a.get(posNum).setLocation(x, y);
							if(x == xTmp) {Thread.currentThread().interrupt();}
							try {
								Thread.sleep(7);
							} catch (InterruptedException e) {
								Thread.currentThread().interrupt();
							}
						}
						animacionBajar(a, tmp, posNum,destino,direccion);
					}
				}
		
		System.out.println("El estado del hilo al terminar->>> "+ Thread.currentThread().isInterrupted());
	}
	public static Boolean verificaOrd(List<Integer> a) {
		boolean ordenado = true;
	
		for (int i = 0; i < a.size(); i++) {
			int n1 = a.get(i);
			int n2 = a.get(i+1);
	        if (i + 1 < a.size()) {
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
	        
	        try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
	  
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
	        try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
	        animHeapify(listInt,listLabel, tmp, n, largest);
	      }
	}
	
	public static void animacionHeapSort(List<Integer> a, List<JLabel> b, List<JLabel> tmpList){
    	System.out.println("entra al heapsort");
		int contador = b.size();
		System.out.println("tamaño del arreglo "+b.size());
    	animacionHeapify(a,b,tmpList,contador);
    	int fin = contador -1;

    	while(!Thread.currentThread().isInterrupted()) {
    		System.out.println("entra al primer while");
	    	while(fin > 0) {
	    		//entra al heap sort
				animacionIntercambio(b, tmpList, 0, fin, 1);
	    		int tmp = a.get(fin);
	    		//JLabel tmp2 = b.get(fin);
	    		//b.set(fin, b.get(0));
	    		a.set(fin, a.get(0));
	    		//b.set(0, tmp2);
	    		a.set(0, tmp);
	    		
	    		//coloca el heap de vuelta en el orden de max-heap 
	    		animacionSiftDown(a, b,tmpList, 0, fin - 1);
	    		//decrementa el tamaño del heap entonces que el valor maximo
	    		//anterior estará en el el lugar apropiado
	    		fin--;
	 
	    	}
	    	try {
				Thread.sleep(10);
			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
    	}
    }
	
	public static void animacionHeapify(List<Integer> a,List<JLabel> b ,List<JLabel> tmpList, int contador) {
    	//el comienzo es asignado por el indice por el ultimo nodo padre
		System.out.println("entra al heapify");
    	int comienzo = (contador - 2)/2; //binary heap
    	System.out.println("comienzo: "+comienzo);
    	while(comienzo >= 0) {
    		System.out.println("entra al while comienzo");
    		//filtrar hacia abajo el nodo en el inicio del índice al lugar adecuado
    		//de modo que todos los nodos debajo del índice de inicio estén en el montón
    		//order
    		animacionSiftDown(a, b,tmpList,comienzo, contador -1);
    		comienzo--;
    	}
    	//después de filtrar la raíz, todos los nodos / elementos están en orden de almacenamiento dinámico
    }
	
	public static void animacionSiftDown(List<Integer> a,List<JLabel> b,List<JLabel> tmpList, int comienzo, int fin) {
    	//fin representa el límite de qué tan lejos del montón se debe tamizar
		System.out.println("entra al siftDown");
    	int raiz = comienzo;
    	System.out.println("raiz: " +raiz);
    	int menor;
    	int mayor;
    		while(!Thread.currentThread().isInterrupted()) {
    			System.out.println("entra al primer while del siftdown");
    			System.out.println("fin: "+fin);
		    	while((raiz * 2 + 1) <= fin) { 
		    		//Mientras que la raíz tiene al menos un hijo
		    		System.out.println("entra al segundo while del siftdown");
		    		int hijo = raiz * 2 + 1;		//raiz*2+1 Señala al hijo izquierdo
		    		//si el hijo tiene un hermano y el valor del hijo es menor que el de su hermano ...
		    		System.out.println("hijo: "+a.get(hijo));
		    		System.out.println("hijo+1: "+a.get(hijo +1));
		    		if(hijo + 1 <= fin && (a.get(hijo) < a.get(hijo + 1))) {
		    			hijo++;
		    			System.out.println("entra al primer if del siftdown");
		    			System.out.println("posicion del hijo:"+hijo);
		   
		    		}
		    		System.out.println("raiz: "+a.get(raiz));
		    		System.out.println("hijo: "+a.get(hijo));
		    		if(a.get(raiz) < a.get(hijo)) {
		    			
		    			menor = verificaMenor(raiz, hijo);
		    			mayor = verificaMayor(raiz, hijo);
		    			animacionIntercambio(b, tmpList, menor, mayor, 1);
		    			int tmp = a.get(raiz);
		    			//JLabel tmp2 = b.get(raiz);
		    			a.set(raiz, a.get(hijo));
		    			//b.set(raiz, b.get(hijo));
		    			a.set(hijo, tmp);
		    			//b.set(hijo, tmp2);
		    			//Princ.imprimirListaNumericaUsuario(b);
		    			Princ.imprimirListaNumerica(a);
		    			raiz = hijo;
		    			System.out.println("raiz :"+raiz);
		    			Thread.currentThread().interrupt();
		    		}else {
		    			Thread.currentThread().interrupt();
		    		}
		    	}
		    	try {
					Thread.sleep(100);
				} catch (Exception e) {
					// TODO: handle exception
					Thread.currentThread().interrupt();
				}
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
	public static void heapify(List<JLabel> a, int contador) {
		int comienzo = (contador - 2)/2;
		while(comienzo >=0) {
			siftDown(a, comienzo, contador -1);
			comienzo--;
		}
	}
	
	public static void siftDown(List<JLabel> a, int comienzo, int fin) {
		int raiz = comienzo;
		
		while((raiz * 2 +1) <= fin) {
			int hijo = raiz * 2 + 1;
			int agetHijo = Integer.parseInt(a.get(hijo).getText());
			int agetHijoSiguiente = Integer.parseInt(a.get(hijo+1).getText());
			if(hijo + 1 <= fin &&  agetHijo < agetHijoSiguiente) {
			hijo++;
			}
			int agetRaiz = Integer.parseInt(a.get(raiz).getText());
			if(agetRaiz < agetHijo){
				JLabel tmp = a.get(hijo);
				a.set(raiz, a.get(hijo));
				a.set(hijo, tmp);
			}else {
				return;
			}
		}
	}
	
	public static void detener() {
	    ejecutar = false;
	}
	
	
	volatile static boolean ejecutar = true;
	private static JLabel aux;
	private static JLabel aux1;
	private static JLabel aux3;
	private static JLabel aux2;
}
