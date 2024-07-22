import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10800 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //공의 개수 : N
    int N = Integer.parseInt(br.readLine());

    //0 ~ N-1 : N 개의 ball 정보
    Ball[] balls = new Ball[N];
 
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int c = Integer.parseInt(st.nextToken()); //color
      int s = Integer.parseInt(st.nextToken()); //size

      Ball ball = new Ball(i, c, s);
      balls[i] = ball;
    }

    //크기에 따라 Ball을 정렬 (오릌차순 정렬)
    Arrays.sort(balls, (ball1, ball2) -> ball1.size - ball2.size);

    int[] result = new int[N]; //balls[index] 가 잡을 수 있는 공의 크기 합
    int[] colors = new int[N + 1]; //색상 별 크기의 합
    int ball_index = 0;
    int sum = 0; //색상 상관없이, 작은 공 크기 합
    for(int i = 0; i < N; i++) {
      Ball currentBall = balls[i];
      while (balls[ball_index].size < currentBall.size) {
        sum += balls[ball_index].size;
        colors[balls[ball_index].color] += balls[ball_index].size;
        ball_index++;
      }

      result[currentBall.index] = sum - colors[currentBall.color];
    }

    for (int i = 0; i < N; i++) {
      bw.write(result[i] + "\n");
    }

    bw.flush();
    bw.close();
  }


  //ball class
  public static class Ball {
    int index, color, size;

    public Ball (int index, int color, int size) {
      this.index = index;
      this.color = color;
      this.size = size;
    }
  }

}
