//https://school.programmers.co.kr/learn/courses/30/lessons/67257
//코딩테스트 연습 > 2020 카카오 인턴십 > 수식 최대화

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

  //연산 수행 함수
  private long calculate(long a, long b, char op) {
    if (op == '+') return a + b;
    if (op == '-') return a - b;
    return a * b;
  }

  //주어진 연산자 우선순위에 따라 수식 계산
  private long compute(List<Long> numbers, List<Character> ops, char[] precedence) {
    List<Long> numList = new ArrayList<>(numbers);
    List<Character> opList = new ArrayList<>(ops);

    for (char op : precedence) {
      for (int i = 0; i < opList.size(); ) {
        if (opList.get(i) == op) {
          long result = calculate(numList.get(i), numList.get(i + 1), op);
          numList.set(i, result);
          numList.remove(i + 1);
          opList.remove(i);
        } else {
          i++;
        }
      }
    }

    return Math.abs(numList.get(0));
  }


  public long solution(String expression) {

    //1. 숫자와 연산자로 구분하여 추출
    List<Long> numbers = new ArrayList<>();
    List<Character> ops = new ArrayList<>();

    Matcher matcher = Pattern.compile("\\d+|[-+*]").matcher(expression);
    while (matcher.find()) {
      String token = matcher.group();
      if (token.matches("\\d+")) {
        numbers.add(Long.parseLong(token));
      } else {
        ops.add(token.charAt(0));
      }
    }

    //연산자 우선순위
    char[][] precedences = {
      {'+', '-', '*'},
      {'+', '*', '-'},
      {'-', '+', '*'},
      {'-', '*', '+'},
      {'*', '+', '-'},
      {'*', '-', '+'}
    };

    long maxResult = 0; //연산 최댓값

    for (char[] precedence : precedences) {
      long result = compute(numbers, ops, precedence);
      maxResult = Math.max(maxResult, result);
    }

    return maxResult;
  }
  
}