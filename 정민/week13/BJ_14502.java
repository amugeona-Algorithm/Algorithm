package 정민.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502 {
    /*
     * 백준 14502
     * 연구소
     * 
     */
    static int N, M, max, index;
    static int[][] map, copyMap;
    static boolean[][] visited;
    static int[] combi;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 }; // 상하좌우

    static class Loca {
        int r;
        int c;

        public Loca(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M]; // 연구소

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = Integer.MIN_VALUE; // -> 바이러스 영역의 최소 크기

        // 0 : 빈칸, 1: 벽, 2 : 바이러스
        combi = new int[3];
        index = N * M;

        makeCombi(0, 0);

        System.out.println(max); // 안전 영역 크기의 최대 출력 : 0의 개수
    }

    public static void makeCombi(int cnt, int start) {
        if (cnt == 3) {
            calcLoca(); // 위치 계산
            return;
        }

        for (int i = start; i < index; i++) {
            int r = i / M;
            int c = i % M;
            if (map[r][c] != 0)
                continue;

            combi[cnt] = i;
            makeCombi(cnt + 1, i + 1);
        }
    }

    public static void calcLoca() {
        copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        for (int i = 0; i < 3; i++) {
            int r = combi[i] / M;
            int c = combi[i] % M;
            copyMap[r][c] = 1; // 벽세우기
        }
        // 바이러스 퍼뜨리기
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 2 && !visited[i][j])
                    virus(i, j);
            }
        }
        countSafe(); // 안전영역 카운팅
    }

    public static void virus(int sr, int sc) {
        Queue<Loca> que = new LinkedList<>();
        que.add(new Loca(sr, sc));
        visited[sr][sc] = true;

        while (!que.isEmpty()) {
            Loca l = que.poll();
            for (int d = 0; d < 4; d++) {
                int nr = l.r + dr[d];
                int nc = l.c + dc[d];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && copyMap[nr][nc] == 0) {
                    copyMap[nr][nc] = 2;
                    visited[nr][nc] = true;
                    que.add(new Loca(nr, nc));
                }
            }
        }

    }

    public static void countSafe() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0)
                    cnt++;
            }
        }
        max = Math.max(max, cnt);
    }

}
