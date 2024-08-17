//https://school.programmers.co.kr/learn/courses/30/lessons/92335?itm_content=course14743
//코딩테스트 연습 - 2022 KAKAO BLIND RECRUITMENT - k진수에서 소수 개수 구하기


class Solution {
  public int solution(int n, int k) {

    StringBuilder sb = new StringBuilder();
    int answer = 0;
    
    //1. n -> k진법 변환
    while (n > 0) {
      sb.append(n % k);
      n /= k;
    }
    sb.reverse();

    //2. 0을 기준으로 분할
    String[] numbers = sb.toString().split("0");

    //3. 소수 찾기
    for (String num : numbers) {
      if (!num.isEmpty()) {
        if (isPrime(Long.parseLong(num))) answer++;
      }
    }

      return answer;
  }

  private boolean isPrime(long x) {
    if (x < 2) return false;
    if (x == 2) return true;
    if (x % 2 == 0) return false;
    for (int i = 3; i <= Math.sqrt(x); i += 2) {
      if (x % i == 0) return false;
    }

    return true;
  }
}