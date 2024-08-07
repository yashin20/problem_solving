import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public int solution(int n, int[][] edge) {

        //그래프 선언 및 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        //간선 양방향 연결
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        //거리 저장 배열
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[1] = 0; //시작점 초기화

        // BFS 를 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); //시작점 추가

        //BFS 탐색
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                //방문하지 않은 노드인 경우
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[current] + 1;
                    queue.add(neighbor); // 방문한 노드 추가 -> 방문한 노드와 인접한 노드 탐색하려고
                }
            }
        }

        int maxDistance = 0;
        int count = 0;
        for (int distance : distances) {
            if (distance > maxDistance) {
                maxDistance = distance;
                count = 1;
            } else if (distance == maxDistance) {
                count ++;
            }
        }

        return count;
    }
}