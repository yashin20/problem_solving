import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_25314 {

  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

   int N = Integer.parseInt(br.readLine());

   //long 개수
   int x = N / 4;

   for(int i = 0; i < x; i++) {
    bw.write("long ");
   }
   bw.write("int");
   bw.flush();
   bw.close();
  }
}
