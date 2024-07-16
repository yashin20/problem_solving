import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_25206 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    double sum = 0; //유효 등급 합
    double sumMark = 0; //유효 학점 합

    for (int i = 0; i < 20; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      st.nextToken(); //강의명
      double mark = Double.parseDouble(st.nextToken()); //학점
      String grade = st.nextToken(); //등급


      //P 등급일 경우 평균 평점(GPA) 계산에서 제외
      if (!grade.equals("P")) {
        sumMark += mark;
        sum += gradeToPoint(grade) * mark;
      }
    }

    double result = sum/sumMark;

  
    bw.write(String.format("%.6f", result) + "");

    bw.flush();
    bw.close();
  }


  public static double gradeToPoint(String grade) {
    if (grade.equals("A+")) {
      return 4.5;
    } else if (grade.equals("A0")) {
      return 4.0;
    } else if (grade.equals("B+")) {
      return 3.5;
    } else if (grade.equals("B0")) {
      return 3.0;
    } else if (grade.equals("C+")) {
      return 2.5;
    } else if (grade.equals("C0")) {
      return 2.0;
    } else if (grade.equals("D+")) {
      return 1.5;
    } else if (grade.equals("D0")) {
      return 1.0;
    } else {
      return 0.0;
    }
  }
  
}
