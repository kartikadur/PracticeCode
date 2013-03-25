package pairs;
/**
 * Given N numbers find the count of how many numbers have a difference of K
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


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
	
	public static void main (String args[]){
		int[] vals = readInts();
		// 0 = numbers; 1 = diff Required
		int[] num = new int[vals[0]];
		int count = 0;
		
		num = readInts();
		
		Arrays.sort(num);
		
		for(int i = 0; i < num.length; i++){
			for(int j = i + 1; j < num.length; j--){
				if((num[i]+vals[1]) > num[j]) break;
				if((num[i]+vals[1]) == num[j]) count++;
			}
		}
		
		System.out.println(count);
	}
}
