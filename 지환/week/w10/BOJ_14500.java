package 지환.week.w10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14500 {
     /*
    백준 14500
    테트로미노
    골드4
     */


    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int R;
    private static int C;
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int result = 0;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = array[0];
        C = array[1];
        map = new int[R][C];
        isVisited = new boolean[R][C];
        StringTokenizer st;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                isVisited[i][j] = true;
                dfs(i, j, 1, map[i][j], isVisited);
                isVisited[i][j] = false;
                check(i, j);
            }
        }

        System.out.println(result);
    }

    private static void dfs(int r, int c, int count, int sum, boolean[][] isVisited) {
        if (count >= 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nR = r + dr[dir];
            int nC = c + dc[dir];

            if (nR >= 0 && nC >= 0 && nR < R && nC < C && !isVisited[nR][nC]) {
                isVisited[nR][nC] = true;
                dfs(nR, nC, count + 1, sum + map[nR][nC], isVisited);
                isVisited[nR][nC] = false;

            }
        }
    }

    static void check(int r, int c) {
        if (r < R - 2 && c < C - 1)
            result = Math.max(result, map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 1][c + 1]);

        if (r < R - 2 && c > 0)
            result = Math.max(result, map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 1][c - 1]);

        if (r < R - 1 && c < C - 2)
            result = Math.max(result, map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r + 1][c + 1]);

        if (r > 0 && c < C - 2)
            result = Math.max(result, map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r - 1][c + 1]);
    }

}
