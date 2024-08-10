//https://school.programmers.co.kr/learn/courses/30/lessons/12938
//코딩테스트 연습 - 연습문제 - 최고의 집합

class Solution {
    public int[] solution(int n, int s) {

        int quotient = s / n; // 몫
        int remainder = s % n; //나머지

        if (n > s) return new int[]{-1};

        int[] answer = new int[n];

        for (int i = n - 1; i > -1; i--) {
            if (remainder > 0) {
                answer[i] = quotient + 1;
                remainder --;
            } else {
                answer[i] = quotient;
            }
        }

        return answer;
    }
}