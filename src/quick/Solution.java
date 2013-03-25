package quick;

/* Head ends here */
import java.util.*;

public class Solution {
       
       static void partition(int[] ar) {
            int lo = 0, i = lo + 1, j = ar.length - 1;
            while(true) {
            	while(ar[i] < ar[lo]) i++;
            	while(ar[lo] < ar[j]) j--;
            	if(i >= j) break;
            	exch(ar, i, j);
            }
            exch(ar, lo, j);
       }   
       
       public static void exch(int[] a, int i, int j) {
    	   int temp1 = a[i], temp2;
    	   a[i] = a[j];
    	   for (int k = i + 1; k < j; k++) {
//    		   if (a[k] > temp1) {
    			   temp2 = a[k];
    			   a[k] = temp1;
    			   temp1 = temp2;
//    		   }
    	   }
    	   a[j] = temp1;
	   	}
       
       public static void printArr(int[] a){
	   		for(int k=0;k<a.length;k++){
	   			System.out.print(a[k] + " ");
	   		}
	   		System.out.println();
	   	}

/* Tail starts here */
 
 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           partition(ar);
           printArr(ar);
       }    
   }