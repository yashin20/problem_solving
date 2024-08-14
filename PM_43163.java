//https://school.programmers.co.kr/learn/courses/30/lessons/43163
//코딩테스트 연습 - 깊이/너비 우선 탐색(DFS/BFS) - 단어 변환

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    class WordNode {
        String word;
        int steps;

        public WordNode (String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }


    public int solution(String begin, String target, String[] words) {

        // # words 에 target 이 존재하는지 확인
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        Queue<WordNode> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length]; //노드 방문 여부 체크 배열

        queue.offer(new WordNode(begin, 0));

        while (!queue.isEmpty()) {
            //초기 설정
            WordNode current = queue.poll();
            String currentWord = current.word;
            int currentSteps = current.steps;

            //목표 단어에 도달한 경우 변환 단계 수 반환
            if (currentWord.equals(target)) {
                return currentSteps;
            }

            //아직 방문하지 않았고, 변환 가능한 단어
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(currentWord, words[i])) {
                    visited[i] = true; //방문 처리
                    queue.offer(new WordNode(words[i], currentSteps + 1));
                }
            }
        }

        return 0; //목표 단어에 도달할 수 없는 경우
    }

    private boolean canConvert(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount ++;
            }
            if (diffCount > 1) {
                return false;
            }
        }

        return diffCount == 1;
    }
}