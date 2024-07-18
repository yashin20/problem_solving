import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2903 {

  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    // result = (1 + 2**N) ** 2
    int result = (int) Math.pow(1 + (int) Math.pow(2, N), 2);

    bw.write(result + "");

    bw.flush();
    bw.close();
  }
  
}
