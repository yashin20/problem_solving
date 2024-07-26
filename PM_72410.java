class PM_72410 {

  public String solution(String new_id) {

    //step 1
    String answer = new_id.toLowerCase();

    //step 2 - regex 에 해당하지 않는 문자는 모두 제거함.
    String regex = "[^a-z0-9._-]";
    answer = answer.replaceAll(regex, "");

    //step 3 - 마침표 2개이상 연속 -> 1개
    answer = answer.replaceAll("\\.{2,}", ".");

    //step 4
    answer = answer.replaceAll("^\\.|\\.$", "");

    //step 5
    answer = answer.isEmpty() ? "a" : answer;

    //step 6
    answer = answer.length() >= 16 ? answer.substring(0, 15) : answer;
    answer = answer.replaceAll("\\.$", "");

    //step 7
    while (answer.length() < 3) {
      answer += answer.charAt(answer.length() - 1);
    }

    return answer;
  }
  
}

//https://school.programmers.co.kr/learn/courses/30/lessons/72410