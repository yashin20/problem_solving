
//https://school.programmers.co.kr/learn/courses/30/lessons/42861
//코딩테스트 연습 - 탐욕법(Greedy) - 섬 연결하기

import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] costs) {
        int sum = 0;

        //1. 부모 노드를 저장할 배열
        int[] island = new int[n];
        for (int i = 0; i < n; i++){
            island[i] = i;
        }

        //2. 간선들을 비용 기준 오름차순 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        for (int i = 0; i < costs.length; i++) {
            //서로 다른 집합에 있는 경우
            if (find(island, costs[i][0]) != find(island, costs[i][1])) {
                unite(island, costs[i][0], costs[i][1]);
                sum += costs[i][2];
            }
        }

        return sum;
    }


    private int find(int[] island, int x) {
        if (island[x] == x) {
            return x;
        }
        return find(island, island[x]);
    }

    private void unite(int[] island, int x, int y) {
        int a = find(island, x);
        int b = find(island, y);
        island[b] = a;
    }
}