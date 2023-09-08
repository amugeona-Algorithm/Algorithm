package 지환.backjoon.w8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1912 {

    /*
    백준 1912
    연속합.
    실버 2
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int[] dp = new int[100001];
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 첫번째 연속합의 결과는 그 위치의 원 배열의 숫자로 지정.
        dp[0] = numbers[0];

        int max = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = numbers[i];
            // 그동안의 합( 이전까지의 합 + 현재 넘버 ) 와 현재 dp[i] 중 더 큰걸 dp[i] 에 넣음
            dp[i] = Math.max(dp[i], dp[i - 1] + numbers[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}

