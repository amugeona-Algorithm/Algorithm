package 지환.week.w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Back_9352 {
    /*
    백준 9352
    염색체
    실버 3
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringBuffer sb = new StringBuffer();
    private static StringTokenizer st;

    //정규 표현식, [] 은 집합, ? 은 0개 혹은 1개 발생 의미, $는 뒤에 문자가 없음을 의미, ^ 은 문자열 시작.
    private static String REGEX = "^[A,B,C,D,E,F]?A+F+C+[A,B,C,D,E,F]?$";
    private static int T;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            if (Pattern.matches(REGEX, br.readLine())) {
                sb.append("Infected!").append("\n");
            } else {
                sb.append("Good").append("\n");
            }
        }
        System.out.printf(sb.toString());
    }

}

