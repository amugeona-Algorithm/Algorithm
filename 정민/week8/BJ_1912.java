package 정민.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1912 {
    /*
     * 백준 1912
     * 연속 합
     * dp
     */
    static int N, max;
    static int[] arr, dp;

    /*
     * Dynamic programming
     * 이미 계산된 결과는 별도의 메모리 영역에 저장해 다시 계산하지 않도록 설계함으로써 메모리를 적절히 사용하여 수행시간 향상
     * top-down / bottom-top 2가지
     * 
     * top-down
     * 상위 문제를 해결하기 위해 하위 문제를 재귀적으로 호출하여 해결
     * 하위문제를 저장해 놓기 위해 memoization
     * 
     * bottom-up
     * 하위에서부터 문제를 해결해나가면서 먼저 계산햇던 문제들의 값을 활용해 상위 문제를 해결해나가는 방식
     * dp의 전형적인 형태
     * 문제 결과 값 저장용 리스트는 dp 테이블
     * 반복문 사용해 구현
     * 
     * memoization 메모제이션
     * dp 구현 방법 중 하나
     * 한 번 계산한 결과를 메모리 공간에 메모하는 기법
     * 
     */

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N]; // 수열 저장 배열
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp
        dp[0] = arr[0];
        max = dp[0];

        // bottom-up
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }

}
