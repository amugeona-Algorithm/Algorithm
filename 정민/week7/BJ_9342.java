package 정민.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9342 {
    /*
     * 백준 9342
     * 염색체
     * 문자열
     */
    static int T;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String dna = br.readLine();

            boolean isPattern = checkString(dna);

            if (isPattern)
                sb.append("Infected!\n");
            else
                sb.append("Good\n");
        }

        System.out.println(sb);
    }

    public static boolean checkString(String s) {
        // 문자열은 {A, B, C, D, E, F} 중 0개 또는 1개로 시작해야 한다.
        int idx = 0;

        if (s.charAt(0) - 'A' >= 1 && s.charAt(0) - 'A' <= 5)
            idx = 1;
        else
            idx = 0;

        int cntA = 0;

        while (true) {
            if (idx < s.length() && s.charAt(idx) == 'A') {
                cntA++;
                idx++;
            } else
                break;
        }

        if (cntA == 0)
            return false;

        int cntF = 0;

        while (true) {
            if (idx < s.length() && s.charAt(idx) == 'F') {
                cntF++;
                idx++;
            } else
                break;
        }

        if (cntF == 0)
            return false;

        int cntC = 0;

        while (true) {
            if (idx < s.length() && s.charAt(idx) == 'C') {
                cntC++;
                idx++;
            } else
                break;
        }

        if (cntC == 0)
            return false;

        if (idx == s.length())
            return true;
        else if (idx == s.length() - 1 && s.charAt(idx) - 'A' >= 0 && s.charAt(idx) - 'A' <= 5)
            return true;
        else
            return false;
    }

}
