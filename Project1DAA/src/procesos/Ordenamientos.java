/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import vista.Princ;

/**
 *
 * @author di_eg
 */
public class Ordenamientos {
    
    /**
     *
     */
    public static void ordBurbuja(){
        //creacion del arreglo
        //Scanner entrada = new Scanner(System.in);
        int arreglo[], nElementos = 0, aux;
        
        
        
        
        
        
        //metodo burbuja
        /*for(int i = 0;i <(nElementos-1);i++){
            for(int j=0;j<(nElementos-1);j++){
                if(arreglo[j] > arreglo[j+1]){//si numeroActual > numeroSiguiente
                    aux = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = aux;
                }
            }
        }
            System.out.println("Arrreglo ondenado en forma creciente");
           //mostrando el arreglo ordenado en forma creciente
           for(int i = 0; i < nElementos; i++){
               System.out.println(arreglo[i]+" - ");
           }*/
    }
    
    public static void HeapSort(List<Integer> a, List<JLabel> b, List<JLabel> tmpList){
    	int contador = b.size();
    	
    	heapify(a,b,contador);
    	int fin = contador -1;
    	while(fin > 0) {
    		//intercambia la raiz(maximo valor) de el heap con el
    		//ultimo elemento del heap
    		//Animaciones.moverPrueba(b, 0, fin);
    		Animaciones.levantarNumero(b, tmpList, fin);
    		int tmp = a.get(fin);
    		
    		//Animaciones.moverNumero(b, tmpList, fin);
    		//System.out.println("entra al heapsort-----------\n");
    		JLabel tmp2 = b.get(fin);
    		//Animaciones.moverNumeroRecto(b, tmpList, 0, fin);
    		
    		b.set(fin, b.get(0));
    		//Animaciones.moverNumeroRecto(b, tmpList, 0, fin);
    		a.set(fin, a.get(0));
    		b.set(0, tmp2);
    		a.set(0, tmp);
    		Princ.imprimirListaNumericaUsuario(b);
    		/*try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		*/
    		//coloca el heap de vuelta en el orden de max-heap 
    		siftDown(a, b, 0, fin - 1);
    		//decrementa el tamaño del heap entonces que el valor maximo
    		//anterior estará en el el lugar apropiado
    		fin--;
    	}
    }
    
    public static void heapify(List<Integer> a,List<JLabel> b ,int contador) {
    	//el comienzo es asignado por el indice por el ultimo nodo padre
    	int comienzo = (contador - 2)/2; //binary heap
    	while(comienzo >= 0) {
    		//filtrar hacia abajo el nodo en el inicio del índice al lugar adecuado
    		//de modo que todos los nodos debajo del índice de inicio estén en el montón
    		//order
    		siftDown(a, b, comienzo, contador -1);
    		comienzo--;
    	}
    	//después de filtrar la raíz, todos los nodos / elementos están en orden de almacenamiento dinámico
    }
    
    public static void siftDown(List<Integer> a,List<JLabel> b, int comienzo, int fin) {
    	//fin representa el límite de qué tan lejos del montón se debe tamizar
    	int raiz = comienzo;
    	while((raiz * 2 + 1) <= fin) {       //Mientras que la raíz tiene al menos un hijo
    		int hijo = raiz * 2 + 1;		//raiz*2+1 Señala al hijo izquierdo
    		//si el hijo tiene un hermano y el valor del hijo es menor que el de su hermano ...
    		if(hijo + 1 <= fin && a.get(hijo) < a.get(hijo + 1)) {
    			hijo++;
    		}
    		if(a.get(raiz) < a.get(hijo)) {
    			//Animaciones.moverPrueba(b, hijo, raiz);
    			int tmp = a.get(raiz);
    			
    			JLabel tmp2 = b.get(raiz);
    			a.set(raiz, a.get(hijo));
    			b.set(raiz, b.get(hijo));
    			a.set(hijo, tmp);
    			b.set(hijo, tmp2);
    			Princ.imprimirListaNumericaUsuario(b);
    			raiz = hijo;
    			
    		}else {
    			return;
    		}
    	}
    }
    
    
}
