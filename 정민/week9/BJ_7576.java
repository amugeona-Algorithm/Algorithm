package 정민.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576 {

    /*
     * 백준 7569
     * 토마토
     * dfs/bfs
     */

    static int M, N, days, notYet;
    static int[][] box; // 토마토 저장

    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static public class Loca {
        int r, c;

        public Loca(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static Queue<Loca> que = new LinkedList<Loca>(); // 익은 토마토 넣기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        days = 0;

        // 1: 익힌 토마토
        // 0 : 익지 않은 토마토
        // -1 : 빈 박스

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == 1)
                    que.add(new Loca(i, j));
                else if (box[i][j] == 0)
                    notYet++; // 안익은게 다 없어지면 끝내기
            }
        }

        if (notYet == 0) // 처음부터 안 익은게 없으면 결과 0
            days = 0;
        else
            bfs();

        System.out.println(days);
    }

    public static void bfs() {
        while (!que.isEmpty()) {
            int count = que.size(); // 몇개의 토마토가 익었는지, 몇개를 동시에 확인해야하는지!

            for (int i = 0; i < count; i++) {
                Loca loca = que.poll(); // 확인할 토마토를 꺼내기

                for (int j = 0; j < 4; j++) {
                    int nr = loca.r + dr[j];
                    int nc = loca.c + dc[j];

                    if (nr >= 0 && nc >= 0 && nr < N && nc < M && box[nr][nc] == 0) {
                        box[nr][nc] = 1; // 익은 토마토로~
                        notYet--;
                        que.add(new Loca(nr, nc));
                    }
                }
            }
            // 하루 끝

            days++;
            if (notYet != 0)
                days = -1;
        }
    }
}
