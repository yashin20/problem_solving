import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_24416 {

  public static int fibCount;
  public static int DPCount;

  public static int[] dp;


  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    dp = new int[n + 1];

    fibCount = 0;
    DPCount = 0;

    fib(n);
    fibonacci(n);

    bw.write(fibCount + " " + DPCount + "");
    
    bw.flush();
    bw.close();
  }

  public static int fib(int n) {
    if (n == 1 || n == 2) {
      fibCount += 1;
      return 1;
    } else {
       return (fib(n-1) + fib(n-2));
    }
  }

  public static int fibonacci(int n) {
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 3; i <= n; i++) {
      DPCount += 1;
      dp[i] = dp[i-1] + dp[i-2];
    }

    return dp[n];
  }



  

}
