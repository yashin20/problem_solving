//https://school.programmers.co.kr/learn/courses/30/lessons/250121
//코딩테스트 연습 - PCCE 기출문제 - [PCCE 기출문제] 10번 / 데이터 분석

import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        String[] arr = {"code", "date", "maximum", "remain"};
        List<String> list = Arrays.asList(arr);
        int extIdx = list.indexOf(ext);
        int sort_byIdx = list.indexOf(sort_by);

        int[][] answer = Arrays.stream(data).filter(o1 -> o1[extIdx] < val_ext)
                                .sorted((o1, o2) -> o1[sort_byIdx] - o2[sort_byIdx])
                                .toArray(int[][]::new);

        return answer;
    }
}