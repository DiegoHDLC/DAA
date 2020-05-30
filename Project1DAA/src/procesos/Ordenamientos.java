/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.util.List;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import vista.Princ;

/**
 *
 * @author di_eg
 */
public class Ordenamientos {
    
    private static int age;
	private static Scanner myObj;
    
    public static void heapSort(List<Integer> listInt, List<JLabel> listLabel, List<JLabel> tmp) {
		int n = listInt.size();
		  
	      // Build max heap
	      for (int i = n / 2 - 1; i >= 0; i--) {
	        heapify(listInt, listLabel, tmp, n, i);
	      }
	  
	      // Heap sort
	      for (int i = n - 1; i > 0; i--) {
	        int temp = listInt.get(0);
	        listInt.set(0, listInt.get(i));
	        listInt.set(i, temp);
	  
	        // Heapify root element
	        heapify(listInt,listLabel,tmp, i, 0);
	      }
	}
    
    public static void heapify(List<Integer> listInt, List<JLabel> listLabel, List<JLabel> tmp, int n, int i) {
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

	        int swap = listInt.get(i);
	        listInt.set(i, listInt.get(largest));
	        listInt.set(largest, swap);
	        heapify(listInt,listLabel, tmp, n, largest);
	      }
	}
    
    void merge(int arr[], int p, int q, int r) {

        // Create L <- A[p..q] and M <- A[q+1..r]
        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
          L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
          M[j] = arr[q + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        while (i < n1 && j < n2) {
          if (L[i] <= M[j]) {
            arr[k] = L[i];
            i++;
          } else {
            arr[k] = M[j];
            j++;
          }
          k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
          arr[k] = L[i];
          i++;
          k++;
        }

        while (j < n2) {
          arr[k] = M[j];
          j++;
          k++;
        }
      }
    
    //Divide the array into two subarrays, sort them and merge them
    void mergeSort(int arr[], int l, int r) {
      if (l < r) {

        // m is the point where the array is divided into two subarrays
        int m = (l + r) / 2;

        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        // Merge the sorted subarrays
        merge(arr, l, m, r);
      }
    }
    
    static int partition(List<Integer> listInt, int low, int high) {
        
        // Select the pivot element
        int pivot = listInt.get(high);
        int i = (low - 1);

        // Put the elements smaller than pivot on the left and 
        // greater than pivot on the right of pivot
        for (int j = low; j < high; j++) {
          if (listInt.get(j) <= pivot) {
            i++;
            int temp = listInt.get(i);
            listInt.set(i, listInt.get(j));
            listInt.set(j, temp);
          }
        }
        int temp = listInt.get(i+1);
        listInt.set(i+1, listInt.get(high));
        listInt.set(high, temp);
        return (i + 1);
      }

      public static void quickSort(List<Integer> listInt, int low, int high) {
        if (low < high) {

          // Select pivot position and put all the elements smaller 
          // than pivot on left and greater than pivot on right
          int pi = partition(listInt, low, high);
          
          // Sort the elements on the left of pivot
          quickSort(listInt, low, pi - 1);

          // Sort the elements on the right of pivot
          quickSort(listInt, pi + 1, high);
        }
      }

    
}
