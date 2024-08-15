//https://school.programmers.co.kr/learn/courses/30/lessons/12945?itm_content=course14743
//코딩테스트 연습 - 연습문제 - 피보나치 수


import java.util.*;

class Solution {

    int[] arr;

    public int solution(int n) {

        arr = new int[n + 1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;

        fido(n);

        return arr[n];
    }

    private int fido(int x) {
        if (arr[x] != -1) {
            return arr[x];
        }
        
        arr[x] = (fido(x - 1) + fido(x - 2)) % 1234567;
        return arr[x];
    }
}