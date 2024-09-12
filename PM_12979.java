//https://school.programmers.co.kr/learn/courses/30/lessons/12979
//코딩테스트 연습 > Summer/Winter Coding(~2018) > 기지국 설치

import java.util.*;

class Solution {
  public int solution(int n, int[] stations, int w) {
    
    int answer = 0;
    int coverage = 2 * w + 1; //한 기지국이 커버하는 범위
    int start = 1; //첫번째 아파트 부터 시작

    // 각 기지국의 이전과 이후에 빈 구간이 있는지 확인
    for (int station : stations) {
      int left = station - w; // 현재 기지국이 커버하는 왼쪽 끝
      int right = station + w; // 현재 기지국이 커버하는 오른쪽 끝
      
      // 빈 구간이 존재하는 경우 (이전 기지국과의 사이)
      if (start < left) {
          int len = left - start;
          answer += (len + coverage - 1) / coverage; // 필요한 기지국 수
      }
      // 다음 커버 구간의 시작은 현재 기지국이 커버하는 구간의 끝 다음
      start = right + 1;
    }
    
    // 마지막 기지국 이후에 빈 구간이 있는지 확인
    if (start <= n) {
        int len = n - start + 1;
        answer += (len + coverage - 1) / coverage; // 필요한 기지국 수
    }

    return answer;
  }
}