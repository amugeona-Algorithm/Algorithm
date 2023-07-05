package 정민.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2615 {
    /*
     * 백준 2615
     * 오목
     * 구현
     */
    static String[][] map = new String[19][19];
    static int[] dr = { -1, 0, 1, 1 }; // 우상, 우, 우하, 하
    static int[] dc = { 1, 1, 1, 0 };
    static String winner = "0";
    static int x = -1, y = -1;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            map[i] = br.readLine().split(" ");
        }

        // 가장 왼쪽에 있는 것 부터 출력
        outer: for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[j][i].equals("1") || map[j][i].equals("2")) {

                    // 돌이 있으면 탐색, 방향 위치 어디?
                    for (int d = 0; d < 4; d++) {
                        cnt = 1;
                        countRock(j, i, d, map[j][i]);
                        if (cnt == 5 && isFive(j, i, d, map[j][i])) {
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
        if (!winner.equals("0"))
            System.out.println(x + " " + y);
    }

    public static void countRock(int r, int c, int dir, String rock) {
        int nr = r + dr[dir];
        int nc = c + dc[dir];
        if (nr >= 0 && nc >= 0 && nr < 19 && nc < 19 && map[nr][nc].equals(rock)) {
            cnt++;
            countRock(nr, nc, dir, rock);
            return;
        }
    }

    public static boolean isFive(int r, int c, int dir, String rock) {
        int nr = r - dr[dir];
        int nc = c - dc[dir];

        if (nr >= 0 && nc >= 0 && nr < 19 && nc < 19 && map[nr][nc].equals(rock))
            return false;
        else
            return true;
    }
}
