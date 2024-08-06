import java.util.*;

class Solution {


    public int solution(int[] info, int[][] edges) {

        //트리를 표현할 리스트 생성
        List<Integer>[] tree = new ArrayList[info.length];

        //트리 초기화
        for(int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }

        //간선 정보를 이용한 트리 구성
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }

        // 최대 양의 수를 저장할 변수
        int[] maxSheep = new int[1];
        
        List<Integer> initialVisited = new ArrayList<>();
        initialVisited.add(0); // 루트 노드를 초기 방문 리스트에 추가
        // DFS 탐색 시작
        dfs(tree, info, 0, 0, initialVisited, maxSheep);

        return maxSheep[0];
    }

    private void dfs(List<Integer>[] tree, int[] info, int sheep, int wolf, List<Integer> visited, int[] maxSheep) {
        // 현재 노드의 정보를 기반으로 양과 늑대의 수를 업데이트합니다.
        if (info[visited.get(visited.size() - 1)] == 0) {
            sheep++;  // 현재 노드에 양이 있으면 양의 수 증가
        } else {
            wolf++;  // 현재 노드에 늑대가 있으면 늑대의 수 증가
        }
    
        // 양의 수가 늑대의 수보다 같거나 적으면 이 경로 무효
        if (sheep <= wolf) {
            return;
        }
    
        // 현재까지 모은 양의 수가 최대 양의 수를 갱신
        maxSheep[0] = Math.max(maxSheep[0], sheep);
    
        // 지금까지 탐색한 노드에서 방문 가능한 노드의 집합
        List<Integer> nextNodes = new ArrayList<>();
        for (int v : visited) {
            nextNodes.addAll(tree[v]);
        }
    
        // 방문하지 않은 다음 노드를 재귀적으로 탐색
        for (int next : nextNodes) {
            if (!visited.contains(next)) {
                List<Integer> newVisited = new ArrayList<>(visited);
                newVisited.add(next);
                dfs(tree, info, sheep, wolf, newVisited, maxSheep);
            }
        }
    }
    

}