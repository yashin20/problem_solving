//https://school.programmers.co.kr/learn/courses/30/lessons/43238
//코딩테스트 연습 - 이분탐색 - 입국심사


class Solution {
  public long solution(int n, int[] times) {
      //배열의 최솟값 / 최댓값 찾기
      int minTime = Integer.MAX_VALUE;
      int maxTime = 0;
      for (int time : times) {
          if (time < minTime) {
              minTime = time;
          }
          if (time > maxTime) {
              maxTime = time;
          }
      }

      long left = minTime;
      long right = (long) n * maxTime;
      long answer = right;

      while (left <= right) {
          
          long mid = (left + right) / 2;
          long total = 0; // mid 시간 동안 심사 가능한 사람 수

          for (int time : times) {
              total += mid / time;
          }

          if (total >= n) {
              answer = mid;
              right = mid - 1;
          } else {
              left = mid + 1;
          }
      }

      return answer;
  }
}