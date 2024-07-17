import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_12865 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); //물품의 수 : N
    int K = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게 : K

    int[][] DP = new int[K + 1][N + 1];
    
    //item[0][] : item weight
    //item[1][] : item value
    int[][] item = new int[2][N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      item[0][i] = Integer.parseInt(st.nextToken()); //item weight
      item[1][i] = Integer.parseInt(st.nextToken()); //item value
    }

    for (int k = 1; k <= K; k++) {
      for (int i = 1; i <= N; i++) {
        DP[k][i] = DP[k][i - 1]; //기존 값을 가져오기

        //버틸 수 있는 무게의 아이템인 경우
        if (k >= item[0][i]) {
          DP[k][i] = Math.max(DP[k][i - 1], DP[k - item[0][i]][i - 1] + item[1][i]);
        }
      }
    }

    bw.write(DP[K][N] + "");
    
    bw.flush();
    bw.close();
  }
  
}
