//https://school.programmers.co.kr/learn/courses/30/lessons/43236
//코딩테스트 연습 - 이분탐색 - 징검다리

import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks); //바위 위치 오름차순 정렬

        int left = 0;
        int right = distance;

        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2; //고려해볼 값
            int current = 0; //현재 위치 (시작점 초기화)
            int removedRocks = 0; //제거한 바위 수

            for (int rock : rocks) {
                //바위 사이의 거리 < mid => 바위 제거
                if (rock - current < mid) {
                    removedRocks ++;
                } 
                // 바위 사이의 거리 >= mid => 바위 제거할 필요 X , 현재 위치 갱신
                else {
                    current = rock;
                }
            }

            //'마지막 바위 ~ 도착지점' 고려 
            if (distance - current < mid) removedRocks++;

            // 제거한 바위의 수 > n => 값으로 예상한 mid 가 너무 큼 
            // 범위를 줄여서 다시 계산
            if (removedRocks > n) {
                right = mid - 1;
            } 
            // mid 가 답이 될 수 있음. 더 큰 정답이 존재하는지 확인
            else {
                answer = mid;
                left = mid + 1;
            }
        }

        return answer;
    }
}