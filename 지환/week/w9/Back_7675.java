package 지환.week.w9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_7675 {

    /*
    백준 7675
    토마토
    골드5
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Tomato[][] map;
    private static int result = -1;
    private static int R, C;
    private static Queue<Tomato> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new Tomato[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int color = Integer.parseInt(st.nextToken());
                map[i][j] = new Tomato(i, j, color);
                if (color == 1) {
                    queue.add(map[i][j]);
                }
            }
        }

        bfs();
        System.out.println(result);

    }

    static void bfs() {
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            int r = tomato.getR();
            int c = tomato.getC();


            for (int i = 0; i < 4; i++) {
                int dirR = r + dr[i];
                int dirC = c + dc[i];

                if (dirC < 0 || dirC >= C || dirR < 0 || dirR >= R) continue;
                Tomato dirTomato = map[dirR][dirC];
                if (dirTomato.getTime() == 0) {
                    //토마토 색깔이 변했다고 가정. 한번도 진입하기 않은경우(0) 인 경우 ,
                    // 이전 토마토 시간 + 하루 추가
                    int beforeTomatoTime = map[r][c].getTime();
                    dirTomato.setTime(beforeTomatoTime + 1);
                    //색깔이 변한 토마토 나중에 탐색하기 위해서 추가
                    queue.offer(dirTomato);
                }
            }
        }

        if (hasZero()) {
            result = -1;

        }else {

            int max = Integer.MIN_VALUE;
            //각맵에서 time 들의 최대값을 찾음.
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    max = Math.max(map[i][j].getTime(), max);
                }
            }

            //마지막 처리날 값은 토마토가 익고 하루가 지난 시점이기 때문에 max - 1 해줌
            result = max - 1;
        }
    }

    private static boolean hasZero() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j].getTime() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Tomato {
        int r;
        int c;

        int time;

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public Tomato(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}