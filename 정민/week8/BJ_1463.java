package 정민.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1463 {

    /*
     * 백준 1463
     * 1로 만들기
     * dp
     */

    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = 0; // 1은 1자체

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 이전에 1을 만든 dp[i-1]에 1을 더하면 i 값 -> 3번 : 1을 뺸다 사용

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }

        System.out.println(dp[N]);

    }
}
