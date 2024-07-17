import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11659 {
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    //주어진 숫자 개수 N
    int N = Integer.parseInt(st.nextToken());
    //구해야 하는 횟수 M
    int M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N+1];
    int[] sum = new int[N+1];
    Arrays.fill(sum, 0); //배열 초기화
    
    
    
    //숫자 부여 받기 (N개)
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      sum[i] = arr[i];
    }

    //sum : 1 ~ i 까지 arr 값의 합
    for (int i = 2; i <= N; i++) {
      sum[i] = sum[i-1] + arr[i];
    }


    //구해야 하는 횟수 M
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      int result = sum[end] - sum[start - 1];
      bw.write(result + "\n");
    }

    bw.flush();
    bw.close();
  }
}
