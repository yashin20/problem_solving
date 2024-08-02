
//코딩테스트 연습 스택/큐 다리를 지나는 트럭
//https://school.programmers.co.kr/learn/courses/30/lessons/42583

import java.util.*;

public class PM_42583 {

  
  public class Truck {
    int weight;
    int move;

    public Truck(int weight) {
      this.weight = weight;
      this.move = 1;
    }

    public void moving() {
      move++;
    }
    
  }

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    //대기중인 트럭 저장
    Queue<Truck> waitQ = new LinkedList<>();
    //다리위에 있는 트럭 저장
    Queue<Truck> moveQ = new LinkedList<>();

    //대기중인 트럭 저장 (waitQ 초기화)
    for (int t : truck_weights) {
      waitQ.offer(new Truck(t));
    }

    int answer = 0;
    int curWeight = 0;

    while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
      answer++;

      if (moveQ.isEmpty()) {
        Truck t = waitQ.poll();
        curWeight += t.weight;
        moveQ.offer(t);
        continue;
      }

      for (Truck t : moveQ) {
        t.moving();
      }

      //첫번째 트럭이 다리를 다 건넜다면, 다리에서 내리고 현재 무게를 줄임
      if (moveQ.peek().move > bridge_length) {
        Truck t = moveQ.poll();
        curWeight -= t.weight;
      }

      //다음 트럭이 다리에 올라갈 수 있는지 확인하고, 가능하면 다리에 올립니다.
      if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
        Truck t = waitQ.poll();
        curWeight += t.weight;
        moveQ.offer(t);
      }
    }
    
    return answer;
  }
}
