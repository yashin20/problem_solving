import java.util.*;

class PM_72413 {

  static int[][] prices;

  public int solution(int n, int s, int a, int b, int[][] fares) {

    prices = new int[n+1][n+1];
    for (int[] arr : prices) {
      Arrays.fill(arr, Integer.MAX_VALUE);
    }
    for (int[] f : fares) {
      int dot1 = f[0];
      int dot2 = f[1];
      int price = f[2];

      prices[dot1][dot2] = price;
      prices[dot2][dot1] = price;
    }

    int[] fromS = dijkstra(n, s);
    int[] fromA = dijkstra(n, a);
    int[] fromB = dijkstra(n, b);
    
    int min_price = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      if (fromS[i] != Integer.MAX_VALUE && 
          fromA[i] != Integer.MAX_VALUE && 
          fromB[i] != Integer.MAX_VALUE ) {
        
            min_price = Math.min(min_price, fromS[i] + fromA[i] + fromB[i]);
      }
    }

    return min_price;
  }



  //다익스트라 알고리즘
  private int[] dijkstra (int n, int start) {
    int[] result = new int[n+1];
    boolean[] visited = new boolean[n+1];

    Arrays.fill(result, Integer.MAX_VALUE);
    result[start] = 0;
    visited[start] = true;

    for(int i = 1; i <= n; i++) {
      if (!visited[i] && prices[start][i] != Integer.MAX_VALUE) {
        result[i] = prices[start][i];
      }
    }

    //최소 거리 노드 찾기
    for (int i = 1; i < n; i++) {

      int min = Integer.MAX_VALUE;
      int min_index = -1;

      // 탐색 안한 노드 중에 현재 최소 거리 노드 => 앞으로 탐색할 노드
      for (int j = 1; j <= n; j++) {
        if (!visited[j]) {
          if (result[j] < min) {
            min = result[j];
            min_index = j;
          }
        }
      }

      if (min_index == -1) {
        break;
    }

      // 거쳐가는것과 비교해 최솟값 갱신
      visited[min_index] = true;
      for (int j = 1; j <= n; j++) {
        if (!visited[j] && prices[min_index][j] != Integer.MAX_VALUE) {
          if (result[min_index] + prices[min_index][j] < result[j]) {
            result[j] = result[min_index] + prices[min_index][j];
          }
        }
      }

    }

    return result;
  }
}
