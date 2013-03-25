package billboards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static String readLine() {
        try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }
	
	public static int[] readInts(){
		String[] s = readLine().trim().split("\\s+");
		int[] vals = new int[s.length];
		for(int i = 0; i< s.length; i++){
			vals[i] = Integer.parseInt(s[i]);
		}
		return vals;
	}
	
	public static int readInt(){
		String[] s = readLine().trim().split("\\s+");
		return Integer.parseInt(s[0]);
	}
	
	public static void main (String args[]){
		int[] bb, vals = new int[2], temp;
		// 0 => Number of billboards, 1 => Max number of boards that can be together
		int max = Integer.MIN_VALUE, sum;//, skip = 0
		
		vals = readInts();
		bb = new int[vals[0]];
		temp = new int[vals[1] + 1];
		for(int i = 0; i < vals[0]; i++) {
			bb[i] = readInt();
		}
		
//		create an array with sums of every (k+1)th 
//		then add all arrays except one. and find max
//		i -> 0 to K + 1
//			sum_i <- 0
//			j -> 0 to N - 1 in steps of k + 1
//				sum_i <- sum_i + num_j
//		
//		add partial sums to find max
		
//		6/4 = { 1, _, _, _, _, 10 }
//		6/4 = { _, 2, _, _, _, _ }
//		6/4 = { _, _, 3, _, _, _ }
//		6/4 = { _, _, _, 1, _, _ }
//		6/4 = { _, _, _, _, 6, _ }
		
		for(int i = 0; i <= vals[1]; i++) {
			temp[i] = 0;
			for(int j = i; j < vals[0]; j = j + vals[1] + 1 ) {
//				temp[i] += bb[j];
				System.out.print((i+1) + ": " + (j+1) + ", ");
			}
			System.out.println();
		}
		
//		for(int i = 0; i < vals[1] + 1; i++){
//			temp[i] = 0;
//			for(int j = i; j < vals[0]; j = j + vals[1] + 1) {
//				temp[i] += bb[j];
//				System.out.print(bb[j] + " ");
//			}
//			System.out.println();
//		}
		
//		6 = { 1, 2, 3, 1, 6, 10 }
//		1 => { _, 2, _, 1, _, 10 } = 13
//		2 => { _, 2, 3, _, 6, 10 } = 21
//		3 => { 1, 2, _, 1, 6, 10 } = 20
//		4 => { 1, _, 3, 1, 6, 10 } = 21
//		5 => { _, 2, 3, 1, 6, 10 } = 22
//		6 => { 1, 2, 3, 1, 6, 10 } = 23
		
//		for(int i = 0; i < vals[1] + 1; i++) {
//			sum = 0;
//			for(int j = 0; j < vals[1] + 1; j++) {
//				if(i == j){continue;}
//				sum += temp[j];
//			}
//			if(max < sum){ max = sum; }
//		}
		System.out.println(max);
	}
}
