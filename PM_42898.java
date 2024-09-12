//https://school.programmers.co.kr/learn/courses/30/lessons/42898?language=java
//코딩테스트 연습 > 동적계획법(Dynamic Programming) > 등굣길

import java.util.*;

class Solution {

  public int solution(int m, int n, int[][] puddles) {
    
    int mod = 1_000_000_007;
    
    // m x n 격자판
    int[][] dp = new int[m + 1][n + 1];

    // 물웅덩이 접근 불가 표시
    for (int[] p : puddles) dp[p[0]][p[1]] = -1;

    // 출발점 표시
    dp[1][1] = 1;

    for (int x = 1; x <= m; x++) {
        for (int y = 1; y <= n; y++) {

            //출발지 || 물웅덩이
            if ((x == 1 && y == 1) || dp[x][y] == -1) continue;

            //from 위쪽
            if (y > 1 && dp[x][y - 1] != -1) dp[x][y] += dp[x][y - 1] % mod;

            //from 왼쪽
            if (x > 1 && dp[x - 1][y] != -1) dp[x][y] += dp[x - 1][y] % mod;

            dp[x][y] %= mod;
        }
    }

    return dp[m][n];
  }
}