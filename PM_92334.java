import java.util.*;

class PM_92334 {
  
  public int[] solution(String[] id_list, String[] report, int k) {
    int[] answer = new int[id_list.length];

    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < id_list.length; i++) {
      map.put(id_list[i], i);
    }

    //신고 기록
    int[][] recode = new int[id_list.length][id_list.length];
    for (String r : report) {
      String[] id = r.split(" ");
      recode[map.get(id[0])][map.get(id[1])] = 1;
    }

    //정지 유저 리스트
    List<Integer> ban_list = new ArrayList<>();
    for (int i = 0; i < id_list.length; i++) {
      int sum = 0;
      for (int j = 0; j < id_list.length; j++) {
        sum += recode[j][i];
      }
      
      if (sum >= k) {ban_list.add(i);}
    }

    //정비 메일 발송 건수
    for (int i = 0; i < id_list.length; i++) {
      int sum = 0;
      for (int j : ban_list) {
        sum += recode[i][j];
      }
      
      answer[i] = sum;
    }

    return answer;
  }
}
