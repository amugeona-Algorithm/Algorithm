package 지환.backjoon.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2615 {
    /*
    백준 2615
    오목
     */

    static int[][] map = new int[19][19];
    static int[] dr = {-1, 0, 1, 1}; // 우상, 우, 우하 ,하
    static int[] dc = {1, 1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int winner = 0;
        int x = 0;
        int y = 0;

        outer: for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[j][i] == 1 || map[j][i] == 2) {
                    for (int dir = 0; dir < 4; dir++) {
                        count = 1;
                        countRock(j, i, dir, map[j][i]);
                        if (count == 5 && isFive(j, i, dir, map[j][i])) {
                            winner = map[j][i];
                            x = j + 1;
                            y = i + 1;
                            break outer;
                        }
                    }
                }
            }
        }
        System.out.println(winner);
        if (winner != 0) {
            System.out.println(x + " " + y);
        }
    }

    private static boolean isFive(int r, int c, int dir, int rock) {
        int nr = r - dr[dir];
        int nc = c - dc[dir];

        if (nr >= 0 && nc >= 0 && nr < 19 && nc < 19 && map[nr][nc] == rock) {
            return false;
        } else return true;
    }

    static int count = 0;

    public static void countRock(int r, int c, int dir, int rockColor) {
        int nextRow = r + dr[dir];
        int nextCol = c + dc[dir];
        if (nextRow >= 0 && nextCol >= 0 && nextRow < 19 && nextCol < 19 && map[nextRow][nextCol] == rockColor) {
            count++;
            countRock(nextRow, nextCol, dir, rockColor);
            return;
        }
    }
}
