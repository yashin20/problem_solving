//https://school.programmers.co.kr/learn/courses/30/lessons/64062
//코딩테스트 연습 - 2019 카카오 개발자 겨울 인턴십 - 징검다리 건너기


class Solution {
  public int solution(int[] stones, int k) {

      //left : 징검다리를 건널 수 있는 사람의 최솟값
      //right : 징검다리를 건널 수 있는 사람의 최댓값
      int left = 1; 
      int right = Integer.MIN_VALUE;

      // left / right 초기화
      for (int stone : stones) {
          if (stone > right) {
              right = stone;
          }
      }

      //이진 탐색으로 범위 줄이기
      while (left <= right) {
          int mid = (left + right) / 2;
          if (skip(stones, k, mid)) {
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }

      return right;
  }

  // 징검다리를 건널 수 있는지 판단하는 메서드
  private boolean skip (int[] stones, int k, int mid) {
      int skip_stone = 0;
      for (int stone : stones) {
          if (stone - mid < 0) {
              skip_stone ++;
              if (skip_stone >= k) {
                  return false;
              }
          } else {
              skip_stone = 0;
          }
      }
      return true;
  }

}