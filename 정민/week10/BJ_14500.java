package 정민.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500 {

    /*
     * 백준 14500
     * 테트로미노
     */

    static int N, M, max;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 }; // 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        max = Integer.MIN_VALUE; // 결과 최대 출력
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j);
            }
        }
        System.out.println(max);
    }

    public static void dfs(int r, int c) {
        isVisited[r][c] = true;
        romino(r, c, 1, map[r][c]); // 깊이 얼마인지 구하기
        checkLast(r, c);
        isVisited[r][c] = false;
    }

    public static void romino(int r, int c, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(sum, max);
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nc >= 0 && nr < N && nc < M && !isVisited[nr][nc]) {
                isVisited[nr][nc] = true;
                romino(nr, nc, cnt + 1, sum + map[nr][nc]);
                isVisited[nr][nc] = false;
            }
        }
    }

    public static void checkLast(int r, int c) {
        //
        if (r - 1 >= 0 && c + 1 < M && c - 1 >= 0) {
            max = Math.max(map[r][c] + map[r - 1][c] + map[r - 1][c - 1] + map[r - 1][c + 1], max);
        }
        if (r + 1 < N && c + 1 < M && c - 1 >= 0) {
            max = Math.max(map[r][c] + map[r + 1][c] + map[r + 1][c - 1] + map[r + 1][c + 1], max);
        }
        if (c - 1 >= 0 && r + 1 < N && r - 1 >= 0) {
            max = Math.max(map[r][c] + map[r][c - 1] + map[r - 1][c - 1] + map[r + 1][c - 1], max);
        }
        if (r - 1 >= 0 && r + 1 < N && c + 1 < M) {
            max = Math.max(map[r][c] + map[r - 1][c + 1] + map[r][c + 1] + map[r + 1][c + 1], max);
        }
    }
}
