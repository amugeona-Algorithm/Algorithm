package 정민.week8;

import java.util.Scanner;

public class BJ_2579_err {
    /*
     * 백준 2579
     * 계단 오르기
     * dp
     * 
     * 틀린 코드 -> dp 제대로 이해 X
     */
    static int n, max;
    static int[] stair, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        stair = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stair[i] = sc.nextInt();
        }

        dp[n] = stair[n];
        max = 0;

        // top-down
        if (stair[n - 1] >= stair[n - 2])
            steps(n - 1);
        else
            steps(n - 2);

        System.out.println(Math.max(dp[1], dp[2]));
    }

    public static void steps(int idx) {
        if (idx <= 0)
            return;

        if (dp[idx + 1] != 0) {
            // 연속된 수라면
            dp[idx] = dp[idx + 1] + stair[idx];
            steps(idx - 2);
        } else {
            dp[idx] = dp[idx + 2] + stair[idx];
            if (idx <= 1)
                steps(0);
            else if (stair[idx - 1] >= stair[idx - 2]) { // 계단 하나 내려가기
                steps(idx - 1);
            } else {
                // 계단 2개 내려가기
                steps(idx - 2);
            }
        }

    }
}
