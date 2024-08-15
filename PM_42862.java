//https://school.programmers.co.kr/learn/courses/30/lessons/42862?itm_content=course14743
//코딩테스트 연습 - 탐욕법(Greedy) - 체육복

import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        //체육복 개수
        int[] shirt = new int[n + 1];
        Arrays.fill(shirt, 1);
        shirt[0] = 0; //0번 학생은 존재하지 않는다.
        
        for (int l : lost) {
            shirt[l] --;
        }

        for (int r : reserve) {
            shirt[r] ++;
        }

        //여벌 체육복이 있는 학생의 왼 / 오 학생 체크
        for (int i = 1; i <= n; i++) {
            if (shirt[i] > 1) {
                // 왼쪽 학생 빌려주기
                if (i > 1 && shirt[i - 1] == 0) {
                    shirt[i] --;
                    shirt[i - 1] ++;
                } 
                //오른쪽 학생 빌려주기
                else if (i < n && shirt[i + 1] == 0) {
                    shirt[i] --;
                    shirt[i + 1] ++;
                }
            }
        }

        
        int answer = 0;
        for (int s : shirt) {
            if (s > 0) answer++;
        }
        return answer;
    }
}