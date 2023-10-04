package 민호.GraphTraversal;

import java.util.*;
import java.io.*;

public class BaekJoon_17836 {
    /**
     * 백준 17836
     * 그래프 탐색 - 공주님을 구해라
     * Gold 5
     */

    static int N, M, T;
    static int[][] map;
    static int[][][] visit;
    static int[] dr = {-1, 1, 0, 0};    //상하좌우
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r;
        int c;
        int count;
        boolean sword;

        public Node(int r, int c, int count, boolean sword) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.sword = sword;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(0, 0);
        if (result == -1) {
            System.out.println("Fail");
        } else System.out.println(result);


    }

    static int bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r, c, 0, false));
        visit[r][c][0] = 1;

        while (!queue.isEmpty()) {
            Node out = queue.poll();

            if (out.count > T) break;
            if (out.r == N - 1 && out.c == M - 1) return out.count;

            for (int d = 0; d < 4; d++) {
                int nr = out.r + dr[d];
                int nc = out.c + dc[d];
                if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                    if (!out.sword) { //검이 없는 경우 -> 방문하지 않고 0이면 방문 가능
                        if (visit[nr][nc][0] == 0 && map[nr][nc] == 0) {
                            queue.offer(new Node(nr, nc, out.count + 1, false));
                            visit[nr][nc][0] = 1;
                        } else if (visit[nr][nc][0] == 0 && map[nr][nc] == 2) { //방문한 곳이 검인 경우
                            queue.offer(new Node(nr, nc, out.count + 1, true));
                            visit[nr][nc][0] = 1;
                        }
                    } else {  //검을 가지고 있는 경우
                        if (visit[nr][nc][1] == 0) {
                            queue.offer(new Node(nr, nc, out.count + 1, true));
                            visit[nr][nc][1] = 1;
                        }
                    }
                }
            }
        }
        return -1;
    }

}
