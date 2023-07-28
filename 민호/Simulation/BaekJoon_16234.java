package 민호.Simulation;

import java.util.*;
import java.io.*;

public class BaekJoon_16234 {
    /**
     * 백준 16234
     * 시뮬레이션 - 인구이동
     * Gold 4
     */

    static int N, L, R;
    static int Nation[][];
    static int Visit[][];
    static int dr[] = {-1, 1, 0, 0}; //상하좌우
    static int dc[] = {0, 0, -1, 1};

    static class Loc {
        int r;
        int c;

        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        Nation = new int[N][N];
        Visit = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Nation[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Visit[i][j] != 1)
                    checkOpen(i, j);
            }
        }

    }

    static void checkOpen(int r, int c) { //bfs

        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(r, c));
        Visit[r][c] = 1;


        while (!queue.isEmpty()) {
            Loc out = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = out.r + dr[d];
                int nc = out.c + dc[d];

                if (nr >= 0 && nc >= 0 && nr < N && nc < N && Visit[nr][nc] != 1) { //지도를 벗어나지 않고 방문하지 않은 노드일시
                    int diff = Math.abs(Nation[out.r][out.c] - Nation[nr][nc]); // L <= 각 노드의 값의 차 <= R
                    if (diff >= L && diff <= R) {
                        queue.add(new Loc(nr, nc));
                        Visit[nr][nc] = 1;
                    }
                }
            }
        }
    }
}
