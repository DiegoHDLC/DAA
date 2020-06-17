package procesos;

import java.util.ArrayList;

public class Busqueda {
	public Busqueda() {
		// TODO Auto-generated constructor stub
	}
	
	 public static int binarySearch(ArrayList<Integer> listInt, int x, int low, int high) {

 	    if (high >= low) {
 	      int mid = low + (high - low) / 2;

 	      // If found at mid, then return it
 	      if (listInt.get(mid) == x)
 	        return mid;

 	      // Search the left half
 	      if (listInt.get(mid) > x)
 	        return binarySearch(listInt, x, low, mid - 1);

 	      // Search the right half
 	      return binarySearch(listInt, x, mid + 1, high);
 	    }
 	    return -1;
   }
	 
	 public static int busquedaSecuencial(ArrayList<Integer> listInt, int x) {
		  int n = listInt.size();

		  // Going through array sequencially
		  for (int i = 0; i < n; i++) {
		    if (listInt.get(i) == x)
		    return i;
		  }
		  return -1;
		  }

}
