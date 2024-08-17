public class hello {

  public static String fun(String s) {

    StringBuilder answer = new StringBuilder();

        String[] words = s.split("\\s+", -1);
        for (String word : words) {
            word = word.toLowerCase();
            StringBuilder newWord = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    newWord.append(Character.toUpperCase(word.charAt(i)));
                } else {
                    newWord.append(word.charAt(i));
                }
            }
    
            //첫단어가 아닐 경우 공백 추가
            if (answer.length() > 0) {
                answer.append(" ");
            }
            answer.append(newWord);
        }
    
        return answer.toString();
}

  public static void main(String[] args) {

    System.out.println(fun("disappeared aPpEaReD"));
  }
}