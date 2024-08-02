import java.util.*;

public class PM_92341 {

  //시간을 '분' 단위로 변환 
  // hh:mm -> mm
  private int toMinute(String t) {
    String[] arr = t.split(":");
    return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
  }

  //시간 -> 요금으로 변환
  // time -> fee
  private int toFee(int t, int[] fees) {
    if (t < fees[0]) {
      return fees[1];
    }

    // 기본요금 + 추가시간 * 단위 요금
    return fees[1] + ((t - fees[0] + fees[2] - 1) / fees[2]) * fees[3];
  }

  /*
   * fees : [기본 시간, 기본 요금, 단위 시간, 단위 요금]
   * records[n] : "시간 차번호 IN/OUT"
   * result : 차량 번호가 작은 자동차부터 요금 출력
   */
  public int[] solution(int[] fees, String[] records) {
    Map<String, Integer> map = new HashMap<>();

    for (String r : records) {
      StringTokenizer st = new StringTokenizer(r);
      int time = toMinute(st.nextToken()); // min 단위 시간
      String num = st.nextToken();
      String type = st.nextToken();

      //누적 시간 계산
      if (type.equals("IN")) {
        map.put(num, map.getOrDefault(num, 0) - time);
      } else { // OUT
        map.put(num, map.getOrDefault(num, 0) + time);
      }
    } // for 문

    //누적 시간이 0 이하 일 경우 마지막 출차를 안한 것으로 계산
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() <= 0) {
        entry.setValue(entry.getValue() + toMinute("23:59"));
      }
    }

    // 차량 번호 정렬
    List<String> keySet = new ArrayList<>(map.keySet());
    Collections.sort(keySet);

    // 결과를 List<Integer>에 담기
    List<Integer> answer = new ArrayList<>();
    for (String key : keySet) {
      //누적 시간을 요금으로 변환
      answer.add(toFee(map.get(key), fees));
    }

    // List<Integer>를 int[] 배열로 변환
    int[] result = answer.stream().mapToInt(Integer::intValue).toArray();

    return result;

  }// solution
}
