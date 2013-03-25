package arithmaticProgression;
/* Sample program illustrating input/output methods */
//Needs a faster method, try arithmetic progression differences equation

import java.util.Scanner;

class Solution{
	
	private static int modVal = 1000003;
	
   public static void main( String args[] ) {
      
// helpers for input/output      

      Scanner in = new Scanner(System.in);
      
//      boolean stable;
      int numOfItems = 5, numsChkd;
      int N, Q, count, cmd, start, end, powerUp;
      N = in.nextInt();
      long[][] AP = new long[N][3];
      int[] partSum = new int[numOfItems];
      
      for (int i = 0; i < N; i++) {
    	  in.nextLong();
    	  AP[i][0] = in.nextLong() % modVal;
    	  AP[i][1] = in.nextLong();
    	  AP[i][2] = (long) (Math.pow(AP[i][0], AP[i][1]) % modVal);
      }
      
      Q = in.nextInt();
      	
	  for (int k = 0; k < Q; k++) {
		  cmd = in.nextInt();
		  if (cmd == 0) {
			  start = in.nextInt();
			  end = in.nextInt();
			  for (int j = 0; j < numOfItems; j++) partSum[j] = 1;
			  count = 0;
			  for (int i = (start - 1); i < end; i++) {
		    	  for (int j = 0; j < numOfItems; j++) {
		    		  partSum[j] *= (int) Math.pow(AP[i][0] + j*AP[i][1], AP[i][2]) % 1000003;
		    	  }
		      }
		      
			  while (true) {
				  count++; numsChkd = 0;
				  for (int i = 0; i < numOfItems - 1; i++) {
					  partSum[i] = partSum[i + 1] - partSum[i];
				  }
				  for (int i = 0; i < numOfItems - 1; i++) {
					  if (partSum[i] == partSum[i + 1]) {
						  numsChkd++;
					  }
				  }
				  if(numsChkd >= (numOfItems - 4)) break;
			  }
		      System.out.println(count + " " + partSum[0]);
		  } else if (cmd == 1) {
			  start = in.nextInt();
			  end = in.nextInt();
			  powerUp = in.nextInt();
			  for (int i = (start - 1); i < end; i++) {
				  AP[i][2] += powerUp;
			  }
		  }
      }      
   }
}