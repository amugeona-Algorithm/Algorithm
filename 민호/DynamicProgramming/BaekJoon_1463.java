package 민호.DynamicProgramming;

import java.util.*;
import java.io.*;

public class BaekJoon_1463 {
    /**
     * 백준 1463
     * 동적계획법 - 1로 만들기
     * SLiver 3
     */

    static int N;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        DP = new int[N + 1];

        DP[0] = 0;
        DP[1] = 0;

        //Bottom up
        for (int i = 2; i < N + 1; i++) {
            DP[i] = DP[i - 1] + 1; //2와 3으로 나누어 떨어지지 않는 경우 = 이전 단계에서 -1 연산 한번 추가
            if (i % 2 == 0) {
                DP[i] = Math.min(DP[i], DP[i / 2] + 1); //2로 나누어 떨어지는 경우 = -1 연산 OR 나누기 2 연산 가능
            }
            if (i % 3 == 0)
                DP[i] = Math.min(DP[i], DP[i / 3] + 1); //3으로 나누어 떨어지는 경우 = -1 연산 OR 나누기 3 연산 가능

        }

        System.out.println(DP[N]);
    }
}
