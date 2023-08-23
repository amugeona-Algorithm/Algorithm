package 민호.GraphTraversal;

import java.util.*;
import java.io.*;

public class BaekJoon_7576 {
    /**
     * 백준 7576
     * 그래프 탐색 - 토마토
     * Gold 5
     */

    static int M, N; //박스 가로 길이, 세로 길이
    static int[][] box;
    static int result;
    static int[] dr = {-1, 1, 0, 0};   //상하좌우
    static int[] dc = {0, 0, -1, 1};

    static class Tomato {
        int r;
        int c;

        public Tomato(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = bfs();
        if (result - 1 == 0) {  //하루안에 모두 익는 경우
            System.out.println(0);
        } else if (result == -1) {  //익지않은 토마토가 생기는 경우
            System.out.println(result);
        } else {
            System.out.println(result - 1); //모든 토마토가 익는데 걸리는 최소 일
        }

    }

    static int bfs() {
        Queue<Tomato> queue = new LinkedList<>();
        int day = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) {
                    queue.offer(new Tomato(i, j));
                    count++;
                }
            }
        }

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            count--;

            for (int d = 0; d < 4; d++) {
                int nr = tomato.r + dr[d];
                int nc = tomato.c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && box[nr][nc] == 0) { //익은 토마토 기준 상하좌우가 box 범위 내이며 익지 않은 토마토인 경우
                    box[nr][nc] = 1;
                    queue.offer(new Tomato(nr, nc));
                }
            }

            if (count == 0) {
                day++;
                count = queue.size();
            }
        }
        if (!checkFalse())
            return -1;
        return day;
    }

    static boolean checkFalse() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}
