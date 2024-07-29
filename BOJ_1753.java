import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



class Node implements Comparable<Node> {
  int index;
  int cost;

  public Node(int index, int cost) {
    this.index = index;
    this.cost = cost;
  }

  @Override
  public int compareTo(Node o) {
    return Integer.compare(this.cost, o.cost);
  }
}


public class BOJ_1753 {

  static ArrayList<Node>[] graph;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken()); // 정점의 개수 V
    int E = Integer.parseInt(st.nextToken()); // 간선의 개수 E

    int K = Integer.parseInt(br.readLine()); // 시작 정점

    graph = new ArrayList[V+1];
    for (int i = 0; i <= V; i++) graph[i] = new ArrayList<>();
    //(u, v, w)
    for (int i = 1; i <= E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph[u].add(new Node(v, w));
    }

    int[] result = dijkstra(V, graph, K);
    for (int i = 1; i <= V; i++) {
      if (result[i] == Integer.MAX_VALUE) {
        bw.write("INF" + "\n");
      } else {
        bw.write(result[i] + "\n");
      }
    }

    bw.flush();
    bw.close();
  }

  /**
   * n : 노드 개수
   * arr : 가중치 2차원 배열
   * start : 시작점
   */
  private static int[] dijkstra(int n, ArrayList<Node>[] graph, int start) {

    int[] result = new int[n + 1];
    boolean[] visited = new boolean[n + 1];

    Arrays.fill(result, Integer.MAX_VALUE);
    result[start] = 0;
    visited[start] = true;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
      int currentNode = pq.poll().index;

      visited[currentNode] = true;

      for (Node next : graph[currentNode]) {
        if (result[next.index] > result[currentNode] + next.cost) {
          result[next.index] = result[currentNode] + next.cost;

          pq.offer(new Node(next.index, result[next.index]));
        }
      }
    }

    return result;
  }

}
