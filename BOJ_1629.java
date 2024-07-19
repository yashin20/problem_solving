import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1629 {

  public static long C;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    C = Long.parseLong(st.nextToken());

    long result = pow(A, B);
    

    bw.write(result + "");

    bw.flush();
    bw.close();
  }

  public static long pow(long a, long b) {
    // 지수 = 1
    if (b == 1) {
      return a % C;
    }

    // 지수의 절반에 해당하는 a^(b / 2)을 구한다.
    long temp = pow(a, b / 2);

    // 지수가 홀수인 경우
    if (b % 2 == 1) {
      return (temp * temp % C) * a % C;
    }
    return temp * temp % C;
  }

}
