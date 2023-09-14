package 정민.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178 {
    /*
     * 백준 2178
     * 미로탐색
     */
    static int N, M, res;
    static char[][] map;
    static boolean[][] visit;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static class Location {
        int r;
        int c;
        int cnt;

        public Location(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j - 1);
                // System.out.println(map[i][j]);
            }
        }

        bfs();
        System.out.println(res);

    }

    public static void bfs() {
        Queue<Location> que = new LinkedList<Location>();
        que.add(new Location(1, 1, 1));
        while (!que.isEmpty()) {
            Location loca = que.poll();
            // 4방탐색
            for (int i = 0; i < 4; i++) {
                int nr = loca.r + dr[i];
                int nc = loca.c + dc[i];
                if (nr > 0 && nc > 0 && nr <= N && nc <= M && map[nr][nc] == '1' && !visit[nr][nc]) {
                    int cnt = loca.cnt;
                    que.add(new Location(nr, nc, cnt + 1));
                    if (nr == N && nc == M) {
                        res = cnt + 1;
                        return;
                    }
                    visit[nr][nc] = true;// 방문 체크
                    // cnt++;
                }
            }
        }
    }
}
