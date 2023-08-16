package 민호.ShortestPath;

import java.util.*;
import java.io.*;

public class BaekJoon_11403 {
    /**
     * 백준 11403
     * 최단거리 - 경로 찾기 (플로이드 알고리즘 - 경로 가능 여부)
     * Sliver 1
     */

    static int N;
    static int[][] tmp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        tmp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tmp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (tmp[i][k] == 1 && tmp[k][j] == 1)
                        tmp[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(tmp[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
