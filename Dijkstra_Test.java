//Node

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
  int index;
  int cost;

  public Node(int index, int cost) {
    this.index = index;
    this.cost = cost;
  }

  /*
   * this.cost > o.cost : -1
   * this.cost < o.cost : 1
   * this.cost == o.cost : 0
   */
  @Override
  public int compareTo(Node o) {
    return Integer.compare(this.cost, o.cost);
  }
}

public class Dijkstra_Test {

  static ArrayList<Node>[] graph;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //그래프 초기화
    graph = new ArrayList[7]; //1 ~ 6
    for (int i = 0; i <= 6; i++) graph[i] = new ArrayList<>();

    // 양방향 간선 추가
    graph[4].add(new Node(1, 10));
    graph[1].add(new Node(4, 10)); // 반대 방향

    graph[3].add(new Node(5, 24));
    graph[5].add(new Node(3, 24)); // 반대 방향

    graph[5].add(new Node(6, 2));
    graph[6].add(new Node(5, 2)); // 반대 방향

    graph[3].add(new Node(1, 41));
    graph[1].add(new Node(3, 41)); // 반대 방향

    graph[5].add(new Node(1, 24));
    graph[1].add(new Node(5, 24)); // 반대 방향

    graph[4].add(new Node(6, 50));
    graph[6].add(new Node(4, 50)); // 반대 방향

    graph[2].add(new Node(4, 66));
    graph[4].add(new Node(2, 66)); // 반대 방향

    graph[2].add(new Node(3, 22));
    graph[3].add(new Node(2, 22)); // 반대 방향

    graph[1].add(new Node(6, 25));
    graph[6].add(new Node(1, 25)); // 반대 방향

    //정점 개수 : 6, 시작점 : 정점 4
    int[] result = dijkstra(6, graph, 4);

    for (int i = 1; i <= 6; i++) {
      if (result[i] == Integer.MAX_VALUE) {
        bw.write("INF "); // 도달할 수 없는 경우
      } else {
        bw.write(result[i] + " ");
      }
    }

    bw.flush();
    bw.close();
  }


  private static int[] dijkstra(int n, ArrayList<Node>[] graph, int start) {

    int[] distance = new int[n + 1];
    boolean[] visited = new boolean[n + 1];
  
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[start] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int currentNode = node.index;
      
      visited[currentNode] = true;

      //인접한 노드 탐색
      for (Node adjacentNode : graph[currentNode]) {
        if (!visited[adjacentNode.index] && distance[adjacentNode.index] > distance[currentNode] + adjacentNode.cost) {
          distance[adjacentNode.index] = distance[currentNode] + adjacentNode.cost;

          pq.offer(new Node(adjacentNode.index, distance[adjacentNode.index]));
        }
      
      }
    }

    //10 66 51 0 34 35


    return distance;
  }


}