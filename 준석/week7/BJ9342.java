package 준석.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9342 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String data = br.readLine();
            if(play(data))
            System.out.println("Infected!");
            else{
                System.out.println("Good");
            }
        }
    }
    public static boolean play(String value) {
        int idx = 0;

        // 첫 번째 조건 확인
        while (idx < value.length() && value.charAt(idx) == 'A') {
            idx++;
        }

        // 두 번째 조건 확인
        if (idx >= value.length() || value.charAt(idx) != 'F') {
            return false;
        }
        while (idx < value.length() && value.charAt(idx) == 'F') {
            idx++;
        }

        // 세 번째 조건 va
        if (idx >= value.length() || value.charAt(idx) != 'C') {
            return false;
        }
        while (idx < value.length() && value.charAt(idx) == 'C') {
            idx++;
        }

        // 네 번째 조건 확인
        while (idx < value.length()) {
            char ch = value.charAt(idx);
            if (ch != 'A' && ch != 'F' && ch != 'C') {
                return false;
            }
            idx++;
        }

        return true;
    }
}
