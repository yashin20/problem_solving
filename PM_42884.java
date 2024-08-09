//https://school.programmers.co.kr/learn/courses/30/lessons/42884
//코딩테스트 연습 - 탐욕법(Greedy) - 단속카메라

import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        //도착지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int cameraPosition = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            // 현재 카메라가 이 경로의 시작점 이전에 있으면, 새로운 카메라가 필요함
            if (cameraPosition < route[0]) {
                answer++;
                cameraPosition = route[1];  // 새로운 카메라 위치를 현재 경로의 끝 지점으로 설정
            }
        }
        
        return answer;
    }
}