package flowers;
/* Sample program illustrating input/output methods */
import java.util.*;

class Solution{
   public static void main( String args[] ){
      
// helpers for input/output      

      Scanner in = new Scanner(System.in);
      
      int N, K, sum = 0;
      N = in.nextInt();
      K = in.nextInt();
      
      int[] C = new int[N];
      for(int i = 0; i < N; i++){
         C[i] = in.nextInt();
      }
      
      Arrays.sort(C);
      
      int count = 1;
      for(int i = 0; i < N; i++){
    	  if(i > 0 && i % K == 0) count++;
    	  sum += (count * C[N - i - 1]);
      }
      
      System.out.println( sum );
      
   }
}