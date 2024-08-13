//https://school.programmers.co.kr/learn/courses/30/lessons/77484
//코딩테스트 연습 - 2021 Dev-Matching: 웹 백엔드 개발자(상반기) - 로또의 최고 순위와 최저 순위

import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        //1. 알아볼 수 없는 숫자 개수
        int removedNum = 0;
        for (int num : lottos) {
            if (num == 0) {
                removedNum ++;
            }
        }

        //2. 동일 숫자 개수
        int sameNum = 0;
        for (int i = removedNum; i < 6; i++) {
            for (int k = 0; k < 6; k++) {
                if (lottos[i] == win_nums[k]) {
                    sameNum ++;
                } 
            }
        }

        int maxSameNum = sameNum + removedNum;
        int minSameNum = sameNum;

        return new int[]{rank(maxSameNum), rank(minSameNum)};
    }

    private int rank(int n) {
        switch (n) {
            case 6:
                return 1;

            case 5:
                return 2;
            
            case 4:
                return 3;

            case 3:
                return 4;

            case 2:
                return 5;

            default:
                return 6;
        }
    }


}