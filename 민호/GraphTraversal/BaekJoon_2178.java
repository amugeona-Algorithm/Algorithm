package 민호.GraphTraversal;

import java.util.*;
import java.io.*;

public class BaekJoon_2178 {
    /**
     * 백준 2178
     * 그래프 탐색 - 미로 탐색
     * Sliver 1
     */

    static int N, M;
    static int[][] array;
    static int[][] visit;
    static int[][] result;
    static int[] dr = {-1, 1, 0, 0};   //상하좌우
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        visit = new int[N][M];
        result = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                array[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(result[N - 1][M - 1]);

    }

    static void bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();

        visit[r][c] = 1;
        result[r][c] = 1;
        queue.offer(new Node(r, c));

        while (!queue.isEmpty()) {
            Node out = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = out.r + dr[d];
                int nc = out.c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && visit[nr][nc] == 0 && array[nr][nc] == 1) {
                    visit[nr][nc] = 1;
                    result[nr][nc] = result[out.r][out.c] + 1;
                    queue.offer(new Node(nr, nc));
                }
            }
        }
    }
}
