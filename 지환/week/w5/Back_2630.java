package 지환.week.w5;

import java.io.*;
import java.util.*;

public class Back_2630 {
    /*
    백준 2630
    색종이 만들기
    분할정복
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static StringTokenizer st;

    private static int blue = 0;
    private static int write = 0;

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideMap(0, 0, n);

        System.out.println(write);
        System.out.println(blue);
    }

    static void divideMap(int r, int c, int dist) {

        if (isAllSameColor(r, c, dist) || dist == 1) {
            if (map[r][c] == 1) {
                blue++;
            } else {
                write++;
            }
        } else {
            divideMap(r, c, dist / 2);
            divideMap(r, c + dist / 2, dist / 2);
            divideMap(r + dist / 2, c, dist / 2);
            divideMap(r + dist / 2, c + dist / 2, dist / 2);
        }
    }

    static boolean isAllSameColor(int r, int c, int dist) {
        int color = map[r][c];
        for (int i = r; i < r + dist; i++) {
            for (int j = c; j < c + dist; j++) {
                if (color != map[i][j]) return false;
            }
        }
        return true;
    }
}

