//https://school.programmers.co.kr/learn/courses/30/lessons/67259
//코딩테스트 연습 > 2020 카카오 인턴십 > 경주로 건설

import java.util.*;

class Solution {

  //방향 벡터 (상, 하, 좌, 우)
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};

  public int solution(int[][] board) {
    int N = board.length;

    //방향별로 비용을 저장할 배열 (x좌표, y좌표, 방향(상하좌우))
    int[][][] cost = new int[N][N][4];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        Arrays.fill(cost[i][j], Integer.MAX_VALUE);
      }
    }

    //Queue
    Queue<int[]> q = new LinkedList<>();

    //출발지(0, 0) 초기화 
    for (int i = 0; i < 4; i++) {
      cost[0][0][i] = 0;
      //{x좌표, y좌표, 이동방향, 최소비용} 초기값 Queue에 투입
      //출발지 (0,0) 에서 4방향 (0, 1, 2, 3) 으로 출발
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

        //범위 안에 존재하는가
        if (nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] == 0) {

          int newCost = currentCost + 100;

          //기존방향과 다른방향 -> 곡선비용 추가
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

    //4방향중 최솟값 도출
    return Math.min(Math.min(cost[N-1][N-1][0], cost[N-1][N-1][1]), 
                    Math.min(cost[N-1][N-1][2], cost[N-1][N-1][3]));
  }
}