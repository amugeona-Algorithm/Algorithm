package 지환.week.w8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2579 {

    /*
    백준 2579
    계단오르기.
    실버 3
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;
    private static int N;
    //3은 몇번 밝았는지 카운트 하기 위함. 1 혹은 2의 값이 들어 올 수 있음. 계단은 3번 이상 밟을 수 없기 때문
    private static int[][] dp = new int[100001][3];
    private static int[] number;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp[1][1] = N;
        number = new int[100001];
        for (int i = 1; i <= N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        //1칸 올라온 상태
        dp[1][1] = number[1];
        //첫번째 칸을 연속해서 두번 올라올 순 없음
        dp[1][2] = 0;
        //두번째칸을 연속해서 올라온 경우는 두번째 칸의 계단 높이만큼만 가능
        dp[2][1] = number[2];
        //두계단을 연속으로 올라운 경우는 첫번째 계단 + 두번째 계단임
        dp[2][2] = number[1] + number[2];

        for (int i = 3; i <= N; i++) {
            //[1] 한번 만 밟고 올라왔면, 2칸전에 한번 밟고 올라온 것과, 2칸전에 두번 올라온 것 중 큰값 + 현재 계단 값이 현재 칸의 큰값임.
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + number[i];
            // 2번  밟고 올라온다면,  전칸에서 1칸만 밝고 올라온것에서 현재 계단 더하기. 전칸은 무조건 밝은 상태임
            dp[i][2] = dp[i - 1][1] + number[i];
        }
        System.out.println(Math.max(dp[N][1], dp[N][2]));

    }
}

