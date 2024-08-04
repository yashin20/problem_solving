
public class PM_68936 {
  
  static int[] answer;

    /**
     * 쿼드 압축이 가능한지 확인하는 메서드
     * @param arr : arr
     * @param x : x 시작점
     * @param y : y 시작점
     * @param size : 영역 사이즈
     * @param val : 값
     * @return
     */
    public boolean zip(int[][] arr, int x, int y, int size, int val) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != val) {
                    return false;
                }
            }
        }

        return true;
    }

    public void quadTree(int[][] arr, int x, int y, int size) {
        if (zip(arr, x, y, size, arr[x][y])) {
            if (arr[x][y] == 1) {
                answer[1] ++;
            } else {
                answer[0] ++;
            }
            return;
        }

        //재귀형식으로 4등분하여 탐색
        quadTree(arr, x, y, size/2);
        quadTree(arr, x, y + size/2, size/2);
        quadTree(arr, x + size/2, y, size/2);
        quadTree(arr, x + size/2, y + size/2, size/2);
    }


    public int[] solution(int[][] arr) {
        answer = new int[2];
        quadTree(arr, 0, 0, arr.length);
        return answer;
    }
}
