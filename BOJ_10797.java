import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10797 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int date = Integer.parseInt(br.readLine());

    int count = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 5; i++) {
      int n = Integer.parseInt(st.nextToken());
      if (date == n) {
        count += 1;
      }
    }

    bw.write(count + "");

    bw.flush();
    bw.close();
  }
}
