
//https://school.programmers.co.kr/learn/courses/30/lessons/17678
//코딩테스트 연습 - 2018 KAKAO BLIND RECRUITMENT - [1차] 셔틀버스

import java.util.Arrays;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {

        int[] crewTimes = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            crewTimes[i] = toMinute(timetable[i]);
        }
        Arrays.sort(crewTimes);

        int[] busTimes = new int[n];
        for (int i = 0; i < n; i++) {
            busTimes[i] = 540 + t * i;
        }

        int crewIdx = 0;
        int lastCrewTime = 0;

        for (int busTime : busTimes) {
            int count = 0;

            while (count < m && crewIdx < crewTimes.length &&
                    crewTimes[crewIdx] <= busTime) {
                lastCrewTime = crewTimes[crewIdx];
                count ++;
                crewIdx ++;
            }

            if (busTime == busTimes[n - 1]) {
                if (count < m) {
                    return toTime(busTime);
                } else {
                    return toTime(lastCrewTime - 1);
                }
            }
        }

        return toTime(busTimes[n - 1]);
    }

    //HH:MM -> minute
    private int toMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    // 분을 HH:MM 형식으로 변환
    private String toTime(int minute) {
        int hours = minute / 60;
        int minutes = minute % 60;
        return String.format("%02d:%02d", hours, minutes);
    }
}