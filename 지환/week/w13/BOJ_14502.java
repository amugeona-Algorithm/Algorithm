package 지환.week.w13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
    /*
    백준 14502
    연구소
    골드 5
    */

    private static int N, M;
    private static int[][] map;
    private static boolean[][] isVisited;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[][] cp;
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];
        cp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cp[i][j] = map[i][j];
            }
        }

        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int count) {
        if (count == 3) {
            //바이러스 칸 에서 부터 bfs 시작

            result = Math.max(bfs(),result);

            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cp[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cp[i][j] == 2) {
                    queue.offer(new Node(i, j));
                    isVisited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nr = poll.r + dr[dir];
                int nc = poll.c + dc[dir];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !isVisited[nr][nc] && cp[nr][nc] == 0) {
                    //바이러스 퍼짐
                    cp[nr][nc] = 2;
                    Node node = new Node(nr, nc);
                    isVisited[nr][nc] = true;
                    queue.offer(node);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cp[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
