//https://school.programmers.co.kr/learn/courses/30/lessons/172928
//코딩테스트 연습 - 연습문제 - 공원 산책

class Solution {

  static class Point {
      int x, y;

      public Point(int x, int y) {
          this.x = x;
          this.y = y;
      }

      public void setX(int x) {
          this.x = x;
      }

      public void setY(int y) {
          this.y = y;
      }
  }

  public int[] solution(String[] park, String[] routes) {

      //1. 시작점 찾기
      Point p = findStartPoint(park);

      //2. 명령에 따른 좌표 이동
      for (String route : routes) {
          move(p, park, route);
      }
      
      int[] answer = new int[]{p.y, p.x};
      return answer;
  }

  //좌표 이동시키는 메서드
  private void move(Point p, String[] park, String route) {
      if (check(p, park, route)) {
          String d = route.split(" ")[0]; //방향
          int num = Integer.parseInt(route.split(" ")[1]); //거리

          if (d.equals("N")){
              p.setY(p.y - num);
          }
          else if (d.equals("W")){
              p.setX(p.x - num);
          }
          else if (d.equals("E")){
              p.setX(p.x + num);
          }
          else { // if (d.equals("S"))
              p.setY(p.y + num);
          }
      }
  }


  //이동 가능한지 확인하는 메서드
  private boolean check(Point p, String[] park, String route) {

      Point testPoint = new Point(p.x, p.y);

      String d = route.split(" ")[0]; //방향
      int num = Integer.parseInt(route.split(" ")[1]); //거리

      if (d.equals("N")){
          for (int i = 0; i < num; i++) {
              if (testPoint.y - 1 < 0) {
                  return false;
              }
              if (park[testPoint.y - 1].charAt(testPoint.x) == 'X') {
                  return false;
              }
              testPoint.setY(testPoint.y - 1);
          }
          return true;
      }
      else if (d.equals("W")){
          for (int i = 0; i < num; i++) {
              if (testPoint.x - 1 < 0) {
                  return false;
              }
              if (park[testPoint.y].charAt(testPoint.x - 1) == 'X') {
                  return false;
              }
              testPoint.setX(testPoint.x - 1);
          }
          return true;
      }
      else if (d.equals("E")){
          for (int i = 0; i < num; i++) {
              if (testPoint.x + 1 >= park[0].length()) {
                  return false;
              }
              if (park[testPoint.y].charAt(testPoint.x + 1) == 'X') {
                  return false;
              }
              testPoint.setX(testPoint.x + 1);
          }
          return true;
      }
      else { // if (d.equals("S"))
          for (int i = 0; i < num; i++) {
              if (testPoint.y + 1 >= park.length) {
                  return false;
              }
              if (park[testPoint.y + 1].charAt(testPoint.x) == 'X') {
                  return false;
              }
              testPoint.setY(testPoint.y + 1);
          }
          return true;
      }
  }


  private Point findStartPoint(String[] park) {
      for (int y = 0; y < park.length; y++) {
          for (int x = 0; x < park[0].length(); x++) {
              if ('S' == park[y].charAt(x)) {
                  return new Point(x, y);
              }
          }
      }

      return new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
  }

}