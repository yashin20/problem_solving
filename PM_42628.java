//https://school.programmers.co.kr/learn/courses/30/lessons/42628
//코딩테스트 연습 - 힙(Heap) - 이중우선순위큐

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            //숫자 삽입
            if (command.equals("I")) {
                minHeap.add(number);
                maxHeap.add(number);
            } 
            //숫자 삭제
            else if (command.equals("D")) {
                //최댓값 삭제
                if (number == 1) {
                    if (!maxHeap.isEmpty()) {
                        int maxValue = maxHeap.poll();
                        minHeap.remove(maxValue);
                    }
                }
                //최솟값 삭제
                else if (number == -1) {
                    if (!minHeap.isEmpty()) {
                        int minValue = minHeap.poll();
                        maxHeap.remove(minValue);
                    }
                }
            }
        }

        if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            return new int[] {maxHeap.peek(), minHeap.peek()};
        }
        
        return new int[] {0, 0};
    }
}