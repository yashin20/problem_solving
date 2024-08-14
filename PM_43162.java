//https://school.programmers.co.kr/learn/courses/30/lessons/43162
//코딩테스트 연습 - 깊이/너비 우선 탐색(DFS/BFS) - 네트워크


class Solution {
  public int solution(int n, int[][] computers) {
      boolean[] visited = new boolean[n];  // 방문 여부를 체크할 배열
      int answer = 0;  // 네트워크의 수

      for (int i = 0; i < n; i++) {
          if (!visited[i]) {  // 아직 방문하지 않은 컴퓨터라면
              dfs(i, computers, visited);  // DFS를 수행하여 연결된 모든 컴퓨터를 방문
              answer++;  // 하나의 네트워크가 형성되었으므로 개수를 증가
          }
      }

      return answer;
  }

  // 깊이 우선 탐색 메소드
  private void dfs(int node, int[][] computers, boolean[] visited) {
      visited[node] = true;  // 현재 노드를 방문 처리

      for (int i = 0; i < computers.length; i++) {
          if (computers[node][i] == 1 && !visited[i]) {  // 연결되어 있고 아직 방문하지 않은 노드라면
              dfs(i, computers, visited);  // 재귀적으로 DFS를 수행
          }
      }
  }
}