import java.util.*;

class PM_42888 {

  public String[] solution(String[] record) {

    List<String> answerList = new ArrayList<>();

    //<id, nickname>
    Map<String, String> map = new HashMap<>();

    for(String s : record) {
      String[] words = s.split(" ");
      String type = words[0];
      String id = words[1];

      if (type.equals("Enter") || type.equals("Change")) {
        String nickname = words[2];
        map.put(id, nickname);
      }
    }

    for(int i = 0; i < record.length; i++) {
      String[] words = record[i].split(" ");
      String type = words[0];
      String id = words[1];

      if (type.equals("Enter")) {
        String instructions = map.get(id) + "님이 들어왔습니다.";
        answerList.add(instructions);
      } 
      
      if (type.equals("Leave")) {
        String instructions = map.get(id) + "님이 나갔습니다.";
        answerList.add(instructions);
      }
    }

    String[] answer = new String[answerList.size()];
    answer = answerList.toArray(answer);
    return answer;
  }
}