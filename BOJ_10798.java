import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10798 {

  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String result = "";

    // 다섯개의 단어
    String[] arr = new String[5];
    for (int i = 0; i < 5; i++) {
      arr[i] = br.readLine();
    }

    // 최대 길이 15 글자 수
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 5; j++) {
        
        if (arr[j].length() > i) {
          result += arr[j].charAt(i);
        }

      }
    }
  
    bw.write(result);


    bw.flush();
    bw.close();
  }
}