import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_31945 {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //테스트 케이스 개수 : T
    int T = Integer.parseInt(br.readLine());


    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int x = 0, y = 0, z = 0;
      for (int j = 0; j < 4; j++) {
        int point = Integer.parseInt(st.nextToken());
        x += point / 4;
        point = point % 4;
        y += point / 2;
        point = point % 2;
        z += point;
      }

      if ( (x == 0 || y == 0 || z == 0) || (x == 4 || y == 4 || z == 4) ) {
        bw.write("YES" + "\n");
      } else {
        bw.write("NO" + "\n");
      }

    }

    bw.flush();
    bw.close();
  }


}
