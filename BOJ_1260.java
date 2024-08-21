import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ_1260 {

  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static List<Integer> dfsResult;
  static List<Integer> bfsResult;

  private static void dfs(int start) {
    visited[start] = true;
    dfsResult.add(start);
    for (int v : graph[start]) {
      if (!visited[v]) {
        dfs(v);
      }
    }
  }

  private static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    visited[start] = true;
    queue.add(start);

    while (!queue.isEmpty()) {
      int v = queue.poll();
      bfsResult.add(v);

      for (int next : graph[v]) {
        if (!visited[next]) {
          visited[next] = true;
          queue.add(next);
        }
      }
    }
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()); //노드의 개수
    int m = Integer.parseInt(st.nextToken()); //간선의 개수
    int start = Integer.parseInt(st.nextToken()); //시작 노드

    //그래프 초기화
    graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }
    visited = new boolean[n + 1];

    //그래프 구성 (간선 입력)
    for (int i = 0; i < m; i++) {
      String[] edge = br.readLine().split(" ");
      int u = Integer.parseInt(edge[0]);
      int v = Integer.parseInt(edge[1]);
      graph[u].add(v);
      graph[v].add(u);
    }

    //각 정점과 인접한 정점의 리스트를 오름차순 정렬
    for (int i = 1; i <= n; i++) {
      Collections.sort(graph[i]);
    }

    //DFS
    dfsResult = new ArrayList<>();
    visited = new boolean[n + 1];
    dfs(start);
    bw.write(String.join(" ", dfsResult.stream().map(String::valueOf).toArray(String[]::new)));

    bw.write("\n");

    //BFS
    bfsResult = new ArrayList<>();
    visited = new boolean[n + 1];
    bfs(start);
    bw.write(String.join(" ", bfsResult.stream().map(String::valueOf).toArray(String[]::new)));

    bw.flush();
    bw.close();
  }

}
