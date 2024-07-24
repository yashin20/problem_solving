import java.util.*;

class PM_150370 {
  
  public int[] solution(String today, String[] terms, String[] privacies) {
    
    List<Integer> answer = new ArrayList<>();

    int date = getDate(today);

    Map<String, Integer> termMap = new HashMap<>();
    for (String s : terms) {
      String[] term = s.split(" ");

      termMap.put(term[0], Integer.parseInt(term[1]));
    }
    for (int i = 0; i < privacies.length; i++) {
      String[] privacy = privacies[i].split(" ");

      if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
        answer.add(i + 1);
      }
    }

    return answer.stream().mapToInt(Integer -> Integer).toArray();
  }

  //날짜를 '일' 단위로 변환
  private int getDate(String today) {
    String[] date = today.split("\\."); /**'.' 은 정규식에서 특별한 의미를 가짐으로 '\\.' 백슬래쉬 2개를 붙어 표현한다. */
    int year = Integer.parseInt(date[0]);
    int month = Integer.parseInt(date[1]);
    int day = Integer.parseInt(date[2]);
    return (year * 12 * 28) + (month * 28) + day;
  }
}
