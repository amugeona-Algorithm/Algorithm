package 민호.DynamicProgramming;

import java.util.*;
import java.io.*;

public class BaekJoon_1912 {
    /**
     * 백준 1912
     * 동적계획법 - 연속합
     * Sliver 2
     */

    static int N;
    static int[] array;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        array = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = array[0];
        int max = array[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(dp[i], max);
        }

        System.out.println(max);

        /*for(int i=1; i<N; i++){
            if(dp[i-1] + array[i] >= 0){
                dp[i] = dp[i-1] + array[i];
            }
            if(dp[i-1] + array[i] < 0){
                dp[i] = array[i];
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());*/
    }
}
