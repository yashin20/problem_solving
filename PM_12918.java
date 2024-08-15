//https://school.programmers.co.kr/learn/courses/30/lessons/12918?itm_content=course14743
//코딩테스트 연습 - 연습문제 - 문자열 다루기 기본

class Solution {
  public boolean solution(String s) {

      // s 길이 검증
      if (s.length() != 4 && s.length() != 6) return false;

      // 문자 포함 여부
      if (s.matches(".*[^0-9].*")) return false;

      return true;
  }
}