import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_1904 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //지원이가 만들 수 있는 길이 : N
    int N = Integer.parseInt(br.readLine());
    
    int[] DP = new int[N+3];
    Arrays.fill(DP, 0); //배열 초기화
    DP[1] = 1;
    DP[2] = 2;
    
    
    for (int i = 3; i <= N; i++) {
      DP[i] = (DP[i-1] + DP[i-2]) % 15746;
    }
    


    bw.write(DP[N] + " ");
  
    bw.flush();
    bw.close();
  }
}