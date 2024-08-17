//https://school.programmers.co.kr/learn/courses/30/lessons/43164
//코딩테스트 연습 - 깊이/너비 우선 탐색(DFS/BFS) - 여행경로


import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {

        //1. 그래프 생성 
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> result = new LinkedList<>(); //경로 저장 리스트

        //2. 그래프 구성
        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }

        //DFS 호출을 통한 경로 구성
        dfs("ICN", graph, result);
        return result.toArray(new String[0]); //List -> Array 변환
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> result) {
        //'airport' 를 출발지로 하는 도착지 목록
        PriorityQueue<String> destinations = graph.get(airport);
        //도착지를 출발지로 하여 재귀호출
        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll(), graph, result);
        }
        //DFS 의 리프노드 부터 저장됨으로 역순 저장
        result.add(0, airport);
    }
}