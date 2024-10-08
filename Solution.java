//https://school.programmers.co.kr/learn/courses/30/lessons/67259
//코딩테스트 연습 > 2020 카카오 인턴십 > 경주로 건설

import java.util.*;

class Solution {

  //방향 벡터 (상, 하, 좌, 우) - x축 : 가로 - y축 : 세로
  int[] dx = {0, 0, -1, 1};
  int[] dy = {1, -1, 0, 0};

  public int solution(int[][] board) {

    int N = board.length; //좌표평면 사이즈

    //방향별로 cost 저장할 배열(x, y, min cost)
    int[][][] cost = new int[N][N][4];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        Arrays.fill(cost[i][j], Integer.MAX_VALUE);
      }
    }

    //BFS - Queue
    Queue<int[]> q = new LinkedList<>();

    //출발지 (0, 0) 초기화 + 출발지에서 상하좌우 탐색 큐에 추가
    for (int i = 0; i < 4; i++) {
      cost[0][0][i] = 0;
      q.offer(new int[]{0, 0, i, 0});
    }

    //BFS 탐색
    while (!q.isEmpty()) {
      int[] current = q.poll();
      int x = current[0];
      int y = current[1];
      int direction = current[2];
      int currentCost = current[3];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        //가고자 하는 곳이 접근 가능한 곳인가?
        if (nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] == 0) {

          //직선 건설비용
          int newCost = currentCost + 100;

          //기존 방향과 다름 : 곡선 건설비용 추가
          if (direction != i) {
            newCost += 500;
          }

          //기존 경로보다 최소 경로를 찾았을때만 탐색
          if (newCost < cost[nx][ny][i]) {
            cost[nx][ny][i] = newCost;
            q.offer(new int[]{nx, ny, i, newCost});
          }
        }
      }
    }

    //4방향 중에서 최솟값 구하기
    return Math.min(Math.min(cost[N-1][N-1][0], cost[N-1][N-1][1]), 
                    Math.min(cost[N-1][N-1][2], cost[N-1][N-1][3]));
  }
}