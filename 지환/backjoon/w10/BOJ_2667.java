package Algorithm.지환.backjoon.w10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_2667 {
     /*
    백준 14500
    단지번호 붙히기
     */

    private static int N;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] array = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = array[j];
            }
        }
        boolean[][] isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    count = 0;
                    isVisited[i][j] = true;
                    dfs(i, j, isVisited);
                    list.add(count);
                    isVisited[i][j] = false;
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }


    static int count = 0;

    private static int dfs(int r, int c, boolean[][] isVisited) {

        map[r][c] = 0;
        count++;

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited[nr][nc] || map[nr][nc] == 0) {
                continue;
            }

            isVisited[nr][nc] = true;
            dfs(nr, nc, isVisited);
            isVisited[nr][nc] = false;
        }
        return count;
    }
}
