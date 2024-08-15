//https://school.programmers.co.kr/learn/courses/30/lessons/42627
//코딩테스트 연습 - 힙(Heap) - 디스크 컨트롤러

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {

        //1. 작업을 요청 시간 기준 오름차순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        //최소 힙 구성 - 작업 소요 시간이 짧은 기준
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int jobIdx = 0; //작업 인덱스
        int jobCnt = 0; //완료 작업 수
        int totalWaitTime = 0; //총 작업 소요시간 누적
        int currentTime = 0; //현재 시간

        //2. 모든 작업을 완료할때 까지 반복
        while (jobCnt < jobs.length) {
            //현재 시간에 작업할 수 있는 작업을 최소힙에 추가
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= currentTime) {
                minHeap.offer(jobs[jobIdx]);
                jobIdx ++;
            }

            //우선순위 큐에서 작업을 꺼내 처리
            if (!minHeap.isEmpty()) {
                int[] job = minHeap.poll(); //작업 대상
                currentTime += job[1]; //현재 시간을 작업이 끝난 시간으로 이동
                totalWaitTime += currentTime - job[0]; //"작업 요청 시점 ~ 작업 완료 시점" 시간을 누적
                jobCnt ++;
            } else {
                currentTime = jobs[jobIdx][0]; //다음 작업 요청 시간으로 이동
            }
        }

        return totalWaitTime / jobs.length;
    }
}