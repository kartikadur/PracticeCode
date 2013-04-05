package quadrantQueries;

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
		int vals = Integer.parseInt(s[0]);
		return vals;
	}
	
	public static String[] read () {
		String[] s = readLine().trim().split("\\s+");
		return s;
	}
	
	public static void main (String[] args) {
		
		int N, Q;
		int[] points;
		String[] qry = new String[3];
		
		
		N = readInt();
		points = new int[N];
		for (int i = 0; i < N; i++) {
			int[] point = readInts();
			points[i] = point[0] > 0 ?  point[1] > 0 ? 0 : 3 : point[1] > 0 ? 1 : 2;
		}
		
		Q = readInt();
		for(int i = 0; i < Q; i++) {
			qry = read(); int j;
			int start = Integer.parseInt(qry[1]); 
			int end = Integer.parseInt(qry[2]);
			switch(qry[0]) {
				case "C": 
					int[] quad = {0, 0, 0, 0};
					for(j = start - 1; j < end; j++)
						quad[points[j]]++;
					System.out.println(quad[0] + " " + quad[1] + " " + quad[2] + " " + quad[3]);
					break;
				case "X": 
					for(j = start - 1; j < end; j++)				
						points[j] ^= 3;
					break;
				case "Y": 
					for(j = start - 1; j < end; j++)
						points[j] ^= 1;
					break;
			}
		}
	}
}