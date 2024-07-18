import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2720 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 테스트 케이스 개수 : T
     int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      //거스름돈 : C
      int C = Integer.parseInt(br.readLine());

      int quarter = C / 25;
      C = C % 25;
      int dime = C / 10;
      C = C % 10;
      int nickel = C / 5;
      C = C % 5;
      int penny = C;
      bw.write(quarter + " " + dime + " " + nickel + " " + penny + "\n");
    }

    bw.flush();
    bw.close();
  }
  
}
