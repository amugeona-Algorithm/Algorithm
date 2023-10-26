package 지환.week.w14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
      /*
    백준 14501
    퇴사
    실버 3
    */


    private static int dp[];
    private static int t[];

    private static int p[];

    static int n;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            //현재 날짜 i + 걸리는 날짜가 퇴사일이 넘지 않으면
            if (i + t[i] <= n) {
                //(현재 날짜 + 상담 완료 날짜)의 수입 과 [오늘 이전까지의 최대 수입 + 오늘 하루 버는 수입] 비교
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            //상담이 진행 되는 중에 이전 날짜의 최대 금액 유지
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

        }

        System.out.println(dp[n]);
    }
}
