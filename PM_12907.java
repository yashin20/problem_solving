
//https://school.programmers.co.kr/learn/courses/30/lessons/12907
//코딩테스트 연습 - 연습문제 - 거스름돈


class Solution {
  public int solution(int n, int[] money) {

      //0 ~ n원을 만드는 방법 수
      int[] dp = new int[n + 1];
      dp[0] = 1;

      for (int coin : money) {
          for (int i = coin; i <= n; i++) {
              // dp[i] : i원을 만드는 방법의 수
              // dp[i - coin] : i - coin 원을 만드는 방법의 수 
              // == i - coin 원을 만든 후 + coin 을 더하는 수 (coin 을 추가할때 생기는 방법 수)
              dp[i] = (dp[i] + dp[i - coin]) % 1_000_000_007;
          }
      }

      return dp[n];
  }
}