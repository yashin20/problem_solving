import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10804 {

  public static int[] arr;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //1~20 : 배열 선언 및 초기화
    arr = new int[21];
    for (int i = 1; i <= 20; i++) {
      arr[i] = i;
    }

    for (int i = 0; i < 10; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()); //구간 시작
      int b = Integer.parseInt(st.nextToken()); //구간 끝

      reverse(a, b);
    }



    for (int i = 1; i <= 20; i++) {
      bw.write(arr[i] + " ");
    }

    bw.flush();
    bw.close();
  }

  //[a, b] 구간을 역순 배열
  public static void reverse(int a, int b) { 
    while (a < b) {
      int temp = arr[a];
      arr[a] = arr[b];
      arr[b] = temp;
      a++;
      b--;
    }
  }
}
