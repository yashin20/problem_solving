//https://school.programmers.co.kr/learn/courses/30/lessons/67256
//코딩테스트 연습 > 2020 카카오 인턴십 > 키패드 누르기



import java.util.*;

class Solution {

  class Location {
    int x;
    int y;

    public Location (int x, int y){
      this.x = x;
      this.y = y;
    }
  }


  public String solution(int[] numbers, String hand) {

    StringBuilder answer = new StringBuilder();

    Location rightThumb = new Location(2, 3);
    Location leftThumb = new Location(0, 3);
    
    for (int n : numbers) {
      if (n == 1 || n == 4 || n == 7) {
        leftThumb = new Location(0 , n / 3);
        answer.append("L");
      }

      if (n == 3 || n == 6 || n == 9) {
        rightThumb = new Location(2 , (n / 3) - 1);
        answer.append("R");
      }

      if (n == 2 || n == 5 || n == 8 || n == 0) {
        int numX = 1;
        int numY = (n == 0) ? 3 : n / 3;

        int right = Math.abs(numX - rightThumb.x) + Math.abs(numY - rightThumb.y);
        int left = Math.abs(numX - leftThumb.x) + Math.abs(numY - leftThumb.y);

        //왼손 사용
        if (right > left) {
          leftThumb = new Location(numX , numY);
          answer.append("L");
        } 
        //오른손 사용
        else if (left > right) {
          rightThumb = new Location(numX , numY);
          answer.append("R");
        }
        //우선순위 따짐
        else {
          if (hand.equals("right")) {
            rightThumb = new Location(numX , numY);  // 오른손잡이일 경우
            answer.append("R");
          } else {
            leftThumb = new Location(numX , numY);   // 왼손잡이일 경우
            answer.append("L");
          }
        }

      }
    }

    return answer.toString();
  }

}