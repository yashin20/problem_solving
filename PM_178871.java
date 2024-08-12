//https://school.programmers.co.kr/learn/courses/30/lessons/178871
//코딩테스트 연습 - 연습문제 - 달리기 경주

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            int plus_idx = map.get(calling);
            int minus_idx = plus_idx - 1;

            String minus_name = players[minus_idx];

            //1. map 갱신
            map.put(minus_name, plus_idx);
            map.put(calling, minus_idx);

            //2. players 갱신
            players[minus_idx] = calling;
            players[plus_idx] = minus_name;
        }

        return players;
    }
}