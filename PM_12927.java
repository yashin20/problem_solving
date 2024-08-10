//https://school.programmers.co.kr/learn/courses/30/lessons/12927
//코딩테스트 연습 - 연습문제 - 야근 지수

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        // 최대 힙 구현 - 우선순위 큐 + 내림차순 정렬
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            maxHeap.add(work);
        }

        for (int i = 0; i < n; i++) {
            if (!maxHeap.isEmpty()) {
                int maxWork = maxHeap.poll();
                if (maxWork > 0) {
                    maxHeap.add(maxWork - 1);
                }
            }
        }

        long answer = 0;
        while (!maxHeap.isEmpty()) {
            int work = maxHeap.poll();
            answer += (long) work * work;
        }

        return answer;
    }
}