//https://school.programmers.co.kr/learn/courses/30/lessons/12930?itm_content=course14743
//코딩테스트 연습 - 연습문제 - 이상한 문자 만들기

class Solution {
  public String solution(String s) {

        String answer = "";
        int cnt = -1;
        String[] array = s.split("");

        for(String ss : array) {
            cnt = ss.contains(" ") ? -1 : cnt + 1;
            answer += cnt%2 == 0 ? ss.toUpperCase() : ss.toLowerCase(); 
        }
      return answer;
  }
}