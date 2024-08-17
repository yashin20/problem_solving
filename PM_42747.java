//https://school.programmers.co.kr/learn/courses/30/lessons/42747?itm_content=course14743
//코딩테스트 연습 - 정렬 - H-Index

import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        
        return 0;
    }
}
