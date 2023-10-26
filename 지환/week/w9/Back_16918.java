package 지환.week.w9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Back_16918 {

    /*
    백준 16918
    봄버맨
    실버 1
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int R, C, N;
    static String[][] map;
    private static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = array[0];
        C = array[1];
        N = array[2];
        map = new String[R][C];

        for (int i = 0; i < R; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = split[j];
            }
        }

        for (int time = 2; time <= N; time++) {
            if (time % 2 == 0) {
                //설치
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        //기존에 폭탄이 있으면 큐에 추가.-> 터트릴예정이라
                        if (map[i][j].equals("O")) {
                            q.offer(new Point(i, j));
                        }
                    }
                }
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        map[i][j] = "O";
                    }
                }
            } else {
                //폭파
                bfs();
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    private static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            Point temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            map[x][y] = ".";

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                map[nx][ny] = ".";
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

