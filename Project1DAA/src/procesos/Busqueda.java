package procesos;

import java.util.ArrayList;

public class Busqueda {
	
	public static int numComparaciones = 0;
	public Busqueda() {
		// TODO Auto-generated constructor stub
	}
	
	 public static int binarySearch(ArrayList<Integer> listInt, int x, int low, int high) {
		 
 	    if (high >= low) {
 	    	//System.out.println("comparaciones: "+numComparaciones);
 	
 	      int mid = low + (high - low) / 2;
 	      
 	      // If found at mid, then return it
 	      if (listInt.get(mid) == x) {
 	    	 
 	    	 numComparaciones++;
 	    	//System.out.println("comparaciones: "+numComparaciones);
 	    	 return mid;
 	      }
 	      // Search the left half
 	      if (listInt.get(mid) > x) {
 	    	 numComparaciones++;
 	    	 //System.out.println("comparaciones: "+numComparaciones);
 	        return binarySearch(listInt, x, low, mid - 1);
 	      }
 	     
 	      	numComparaciones++;
 	      	//System.out.println("comparaciones: "+numComparaciones);
 	      // Search the right half
 	      return binarySearch(listInt, x, mid + 1, high);
 	    }
 	   
 	   
 	    return -1;
   }
	 
	 public static int busquedaSecuencial(ArrayList<Integer> listInt, int x) {
		  int n = listInt.size();

		  // Going through array sequencially
		  for (int i = 0; i < n; i++) {
		    if (listInt.get(i) == x) {
		    	numComparaciones++;
		    	return i;
		    }
		    numComparaciones++;
		  }
		  return -1;
		  }

}
