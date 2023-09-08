package 지환.backjoon.w8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_1463 {

    /*
    백준 1463
    1로 만들기
    실버 3
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dp = new int[1000001];
    private static int N;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            //i가 3으로 나누어 떨어지는 경우, i/3 + 2 와 1이 되는 횟수가 같기 때문에 최솟값 구함
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

