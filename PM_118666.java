import java.util.*;

class PM_118666 {
  
  /** survey : 판단 유형
   * choices : 선택지 */
  public String solution(String[] survey, int[] choices) {
    String answer = "";

    char[][] type = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
    int[] score = {0, 3, 2, 1, 0, 1, 2, 3};

    //점수 기록 초기화
    Map<Character, Integer> point = new HashMap<Character, Integer>();
    for (char[] t : type) {
      point.put(t[0], 0);
      point.put(t[1], 0);
    }

    //점수 기록
    for (int i = 0; i < choices.length; i++) {
      if (choices[i] > 4) {
        point.put(survey[i].charAt(1), point.get(survey[i].charAt(1)) + score[choices[i]]);
      } else {
        point.put(survey[i].charAt(0), point.get(survey[i].charAt(0)) + score[choices[i]]);
      }
    }

    //
    for (char[] t : type) {
      answer += (point.get(t[1]) <= point.get(t[0])) ? t[0] : t[1];
    }

    return answer;
  }

}
