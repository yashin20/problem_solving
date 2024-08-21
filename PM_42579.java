//https://school.programmers.co.kr/learn/courses/30/lessons/42579
//코딩테스트 연습 > 해시 > 베스트앨범

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genrePlayCount = new HashMap<>(); //장르 전체 재생수 저장
        Map<String, Map<Integer, Integer>> genreMap = new HashMap<>(); //장르별 음악 분류

        for (int i = 0; i < genres.length; i++) {
            Map<Integer, Integer> map = genreMap.getOrDefault(genres[i], new HashMap<>());
            map.put(i, plays[i]);
            genreMap.put(genres[i], map);

            // 장르별 총 재생수를 계산
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르 총 재생수 기준으로 정렬 (내림차순)
        List<String> genreOrder = new ArrayList<>(genrePlayCount.keySet());
        genreOrder.sort((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1));

        //베스트 앨범에 포함될 인덱스 수집
        List<Integer> resuList = new ArrayList<>();
        for (String genre : genreOrder) {
            Map<Integer, Integer> sortedMap = genreMap.get(genre);
            List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(sortedMap.entrySet());

            //재생수 기준 내림차순 정렬
            sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            //장르별 상위 2곡 추가
            for (int i = 0; i < Math.min(sortedList.size(), 2); i++) {
                resuList.add(sortedList.get(i).getKey());
            }
        }

        //List -> Array
        int[] answer = new int[resuList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = resuList.get(i);
        }
        return answer;
    }
}