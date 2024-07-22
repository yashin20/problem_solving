import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10801 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //index 0 : 점수 총합
    //index 1 ~ 10 : 각 라운드 카드 숫자
    int[] A = new int[11];
    int[] B = new int[11];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= 10; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= 10; i++) {
      B[i] = Integer.parseInt(st.nextToken());
    }
    

    for (int round = 1; round <= 10; round++) {
      if (A[round] > B[round]) {
        A[0] ++;
      } else if (A[round] < B[round]) {
        B[0] ++;
      }
    }

    if (A[0] > B[0]) {
      bw.write("A");
    } else if (A[0] < B[0]) {
      bw.write("B");
    } else {
      bw.write("D");
    }


    bw.flush();
    bw.close();
  }
  
}
