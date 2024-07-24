import java.util.*;


public class PM_258712 {
  
  public int solution(String[] friends, String[] gifts) {

    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < friends.length; i++) {
      map.put(friends[i], i);
    }

    //선물지수
    int[] index = new int[friends.length];
    //선물 기록
    int[][] recode = new int[friends.length][friends.length];

    for (String gift : gifts) {
      String[] cur = gift.split(" ");
      index[map.get(cur[0])]++;
      index[map.get(cur[1])]--;
      recode[map.get(cur[0])][map.get(cur[1])]++;
    }

    int answer = 0;
    for (int i = 0; i < friends.length; i++) {
      int count = 0;
      for (int j = 0; j < friends.length; j++) {
        if (i == j) continue;
        if (recode[i][j] > recode[j][i]) count++;
        else if (recode[i][j] == recode[j][i] && index[i] > index[j]) count++;
      }
      answer = Math.max(answer, count);
    }

    return answer;
  }
}
