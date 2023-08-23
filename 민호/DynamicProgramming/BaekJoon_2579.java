package 민호.DynamicProgramming;

import java.util.*;
import java.io.*;

public class BaekJoon_2579 {
    /**
     * 백준 2579
     * 동적계획법 - 계단 오르기
     * Sliver 3
     */

    static int N; //계단 개수
    static int[] step;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        step = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            step[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = step[1];

        for (int i = 2; i < N + 1; i++) {
            if (i == 2) {
                dp[2] = step[1] + step[2];
            } else if (i == 3) {
                dp[3] = Math.max(step[1], step[2]) + step[3];
            } else {
                dp[i] = Math.max(dp[i - 3] + step[i - 1], dp[i - 2]) + step[i];
            }

        }

        System.out.println(dp[N]);

    }
}
