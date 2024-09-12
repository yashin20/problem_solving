//https://school.programmers.co.kr/learn/courses/30/lessons/340213
//코딩테스트 연습 > PCCP 기출문제 > [PCCP 기출문제] 1번 / 동영상 재생기


import java.util.*;

class Solution {
  public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

    int videoLen = transForm(video_len);
    int current = transForm(pos);
    int opStart = transForm(op_start);
    int opEnd = transForm(op_end);

    for (String command : commands) {
      //1. 오프닝 위치에 있는지 확인
      if (current >= opStart && current <= opEnd) {
        current = opEnd; //현재 위치 => 오프닝 종료 시점
      }

      //2. 명령 수행
      if (command.equals("next")) {
        current += 10;
      } else if (command.equals("prev")) {
        current -= 10;
      }

      //3. 범위 조정
      if (current > videoLen) current = videoLen;
      if (current < 0) current = 0;
    }

    //1. 오프닝 위치에 있는지 확인
    if (current >= opStart && current <= opEnd) {
      current = opEnd; //현재 위치 => 오프닝 종료 시점
    }

    return reverseTransForm(current);
  }

  //'mm:ss' -> second 
  public int transForm(String mmss) {
    String[] t = mmss.split(":");
    int result = 0 ;
    result += Integer.parseInt(t[0]) * 60;
    result += Integer.parseInt(t[1]);
    return result;
  }

  //second -> 'mm:ss' 
  public String reverseTransForm(int second) {
    int m = second / 60;
    int s = second % 60;

    String result = "";

    result += (m < 10) ? "0" : "";
    result += String.valueOf(m);
    result += ":";
    result += (s < 10) ? "0" : "";
    result += String.valueOf(s);

    return result;
  }
}