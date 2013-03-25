package insertion;

import java.util.Scanner;

public class Solution {
	private static int count = 0;
	
	public static void insertionSort(int[] a){
		
		for(int i=0;i<a.length;i++){
			for(int j = i; j > 0; j--) {
				if(a[j] < a[j-1])
					exch(a, j, j-1);
			}
		}
	}
	
	public static void exch(int[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		printArr(a);
//		count++;
	}
	public static void printArr(int[] a){
		for(int k=0;k<a.length;k++){
			System.out.print(a[k] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
           ar[i]=in.nextInt(); 
        }
        insertionSort(ar);
//        System.out.println(count);
    }    
}
