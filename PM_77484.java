//https://school.programmers.co.kr/learn/courses/30/lessons/77484
//코딩테스트 연습 - 2021 Dev-Matching: 웹 백엔드 개발자(상반기) - 로또의 최고 순위와 최저 순위

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
      Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
      int zeroCount = 0;

      for (int lotto : lottos) {
        if (lotto == 0) {
          zeroCount ++;
          continue;
        }

        map.put(lotto, true);
      }

      int sameCount = 0;
      for (int winNum : win_nums) {
        if (map.containsKey(winNum)) sameCount ++;
      }

      int maxRank = 7 - (sameCount + zeroCount);
      int minRank = 7 - sameCount;

      if (maxRank > 6) maxRank = 6;
      if (minRank > 6) minRank = 6;

      return new int[] {maxRank, minRank};
    }
}