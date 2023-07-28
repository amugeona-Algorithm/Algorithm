package 민호.BackTracking;

import java.util.*;
import java.io.*;

public class BaekJoon_15649 {
    /**
     * 백준 15649
     * 백트래킹 - N과 M(1) - DFS
     * Silver 3
     */

    static int N, M;
    static int[] result;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        visit = new int[N];

        dfs(N, M, 0);
    }

    static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {

            if (visit[i] != 1) {
                visit[i] = 1;
                result[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = 0;
            }
        }
    }
}
