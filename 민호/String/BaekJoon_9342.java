package 민호.String;

import java.util.*;
import java.io.*;

public class BaekJoon_9342 {
    /**
     * 백준 9342
     * 문자열 - 염색체 (정규식)
     * Sliver 3
     */

    static int T; //테스트 케이스 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String string = st.nextToken();

            if (parse(string))   //조건 만족
                System.out.println("Infected!");
            else                //조건 불만족
                System.out.println("Good");
        }
    }

    static boolean parse(String string) {
        String pattern = "^[A-F]?A+F+C+[A-F]?$";
        return string.matches(pattern);
    }
}
