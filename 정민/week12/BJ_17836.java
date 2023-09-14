package 정민.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17836 {
    /*
     * 백준 17836
     * 공주님을 구해라
     */
    static int N, M, T, res;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 }; // 상하좌우
    static int[][] map;
    static boolean[][] visited;
    static int[] gramPos;

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
        T = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        gramPos = new int[2];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    gramPos[0] = i;
                    gramPos[1] = j;
                }
            }
        }
        // 0: 빈 공간, 1: 마법 벽, 2: 무기
        // 1,1 시작, 최단거리 -> bfs

        bfs();
        System.out.println(res > T ? "false" : res);
    }

    public static void bfs() {
        Queue<Loca> que = new LinkedList<>();
        que.add(new Loca(1, 1));
        visited[1][1] = true;
        int time = 0;

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {

                Loca l = que.poll();

                if (l.r == gramPos[0] && l.c == gramPos[1]) { // 검 찾으면
                    res = time + (N - l.r) + (M - l.c);
                    continue;
                } else if (l.r == N && l.c == M) {
                    res = Math.min(time, res);
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = l.r + dr[d];
                    int nc = l.c + dc[d];
                    if (nr >= 1 && nc >= 1 && nr <= N && nc <= M && !visited[nr][nc] && map[nr][nc] != 1) {
                        que.add(new Loca(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
            time++;
        }

    }

}
