package 민호.BackTracking;

import java.util.*;
import java.io.*;

public class BaekJoon_1182 {
    /**
     * 백준 1182
     * 백트래킹 - 부분수열의 합
     * Sliver 2
     */

    static int N, S;
    static int[] Visit;
    static int[] Array;
    static int[] Result;
    static int ResultCount = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        Array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Array[i] = Integer.parseInt(st.nextToken());
        }


        Visit = new int[N];
        Result = new int[N];
        for (int i = 1; i <= N; i++) {
            dfs(i, 0, 0);
        }

        System.out.println(ResultCount);

    }

    static void dfs(int count, int depth, int start) {
        if (count == depth) {
            int sum = 0;
            for (int i = 0; i < Visit.length; i++) {
                if (Visit[i] == 1)
                    sum += Array[i];
            }
            if (sum == S)
                ResultCount++;
            return;
        }

        for (int i = start; i < N; i++) {
            if (Visit[i] != 1) {
                Visit[i] = 1;
                dfs(count, depth + 1, i);
                Visit[i] = 0;
            }
        }
    }
}
