package 민호.Simulation;

import java.io.*;
import java.util.*;

public class BaekJoon_17144 {
    /**
     * 백준 17144
     * 시뮬레이션 - 미세먼지 안녕!
     * Gold 3
     */

    static int R, C, T;
    static int[][] map;
    static ArrayList<Integer> robot = new ArrayList<>();
    static int time = 0;
    static int result = 0;
    static int[] dr = {-1, 1, 0, 0};    //상하좌우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1)
                    robot.add(i);   //공기청정기 위치 저장
            }
        }

        while (true) {
            if (time == T) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] > 0)
                            result += map[i][j];
                    }
                }
                break;
            }

            diffusion();
            windTop();
            windBot();
            time++;
        }

        System.out.println(result);
    }

    static void diffusion() {
        int[][] tempMap = copyMap();    //확산이 동시에 이루어지기에 서로 영향을 받지 않기위해 새로운 배열을 사용

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
                            map[nr][nc] = map[nr][nc] + tempMap[i][j] / 5;
                            map[i][j] -= tempMap[i][j] / 5;
                        }
                    }
                }
            }
        }
    }

    static void windTop() {
        int topPos = robot.get(0);

        for (int r = topPos - 1; r > 0; r--) {
            map[r][0] = map[r - 1][0];
        }

        for (int c = 0; c < C - 1; c++) {
            map[0][c] = map[0][c + 1];
        }

        for (int r = 0; r < topPos; r++) {
            map[r][C - 1] = map[r + 1][C - 1];
        }

        for (int c = C - 1; c > 1; c--) {
            map[topPos][c] = map[topPos][c - 1];
        }

        map[topPos][1] = 0;
    }

    static void windBot() {
        int botPos = robot.get(1);

        for (int r = botPos + 1; r < R - 1; r++) {
            map[r][0] = map[r + 1][0];
        }

        for (int c = 0; c < C - 1; c++) {
            map[R - 1][c] = map[R - 1][c + 1];
        }

        for (int r = R - 1; r > botPos; r--) {
            map[r][C - 1] = map[r - 1][C - 1];
        }

        for (int c = C - 1; c > 1; c--) {
            map[botPos][c] = map[botPos][c - 1];
        }

        map[botPos][1] = 0;
    }

    static int[][] copyMap() {
        int[][] tempMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tempMap[i][j] = map[i][j];
            }
        }
        return tempMap;
    }
}
