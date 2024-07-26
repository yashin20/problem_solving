/**
 * PM_250137
 */
public class PM_250137 {

  public int solution(int[] bandage, int health, int[][] attacks) {
    int t = bandage[0]; //시전시간
    int x = bandage[1]; //초당 회복량
    int y = bandage[2]; //추가 회복량
    int maxHealth = health; //최대 체력
    int currentHealth = health; //현재 체력
    int continuousSuccess = 0; // 연속 성공 시간
    int attackIndex = 0; //현재 공격 인덱스
    int totalAttacks = attacks.length; //총 공격 수

    for (int time = 1; time <= 1000; time++) {
      //공격 시간에 공격을 받는 경우
      if (attackIndex < totalAttacks && attacks[attackIndex][0] == time) {
        currentHealth -= attacks[attackIndex][1];
        continuousSuccess = 0; //연속 성공 시간 초기화
        attackIndex++;
      } else {
        //체력 회복
        if (continuousSuccess < t) {
          continuousSuccess ++;
          currentHealth += x;
          if (currentHealth > maxHealth) {
            currentHealth = maxHealth; // 최대 체력 초과 방지
          }
        }
        if (continuousSuccess == t) {
          currentHealth += y;
          if (currentHealth > maxHealth) {
            currentHealth = maxHealth; // 최대 체력 초과 방지
          }
          continuousSuccess = 0; //연속 성공 시간 초기화 
        }
      }

      //현재 체력이 0 이하면 즉시 종료
      if (currentHealth <= 0) {
        return -1;
      }

      //모든 공격이 끝났으면 루프 종료
      if (attackIndex >= totalAttacks) {
        break;
      }
    }

    return currentHealth;
  }
  
}