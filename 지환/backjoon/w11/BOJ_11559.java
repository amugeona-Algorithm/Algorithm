package 지환.backjoon.w11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11559 {
    /*
    백준 11559
    뿌요뿌요
    골드1
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char[][] map = new char[12][6];
    private static boolean[][] isVisited = new boolean[12][6];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = s.charAt(j);
            }
        }


        int count = 0;
        while (true) {
            boolean flag = false;

            isVisited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!isVisited[i][j] && map[i][j] != '.') {
                        if (bfs(i, j)) {
                            flag = true;
                        }
                    }
                }
            }
            if (!flag) {
                break;
            }
            count++;
            down();
        }
        System.out.println(count);
    }

    private static void down() {
        for (int k = 0; k < 6; k++) {
            for (int l = 11; l >= 0; l--) {
                if (map[l][k] != '.') {
                    int nr = l;
                    while (true) {
                        nr++;
                        if (nr < 12 && map[nr][k] == '.') {
                            map[nr][k] = map[nr - 1][k];
                            map[nr - 1][k] = '.';
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean bfs(int r, int c) {
        Queue<Slime> queue = new LinkedList<>();
        List<Slime> list = new ArrayList<>();
        queue.offer(new Slime(r, c));
        list.add(new Slime(r, c));
        isVisited[r][c] = true;

        while (!queue.isEmpty()) {
            Slime slime = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = slime.r + dr[i];
                int nc = slime.c + dc[i];
                if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6 || isVisited[nr][nc] || map[nr][nc] != map[r][c]) {
                    continue;
                }
                queue.offer(new Slime(nr, nc));
                list.add(new Slime(nr, nc));
                isVisited[nr][nc] = true;
            }
        }

        if (list.size() >= 4) {
            for (Slime s : list) {
                map[s.r][s.c] = '.';
            }
            return true;
        }
        return false;
    }

    static class Slime {
        int r;
        int c;

        public Slime(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
