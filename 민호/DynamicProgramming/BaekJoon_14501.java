package 민호.DynamicProgramming;

import java.util.*;
import java.io.*;

public class BaekJoon_14501 {
    /**
     * 백준 14501
     * 동적계회법 - 퇴사
     * Silver 3
     */

    static int N;
    static int[][] array;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        array = new int[N][2];
        dp = new int[N+1];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            if(i + array[i][0] <= N){
                dp[i+array[i][0]] = Math.max(dp[i+array[i][0]], dp[i] + array[i][1]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[N]);
    }
}
