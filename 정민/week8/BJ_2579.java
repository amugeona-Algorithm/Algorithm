package 정민.week8;

import java.util.Scanner;

public class BJ_2579 {
    /*
     * 백준 2579
     * 계단 오르기
     * dp
     */
    static int n, max;
    static int[] stair, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        stair = new int[301];
        dp = new int[301];

        for (int i = 1; i <= n; i++) {
            stair[i] = sc.nextInt();
        }

        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        dp[3] = Math.max(stair[1], stair[2]) + stair[3];

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
        }

        System.out.println(dp[n]);
    }
}
