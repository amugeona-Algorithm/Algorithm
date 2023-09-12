package 지환.backjoon.w12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178 {
    /*
  백준 2178
  미로탐색
  실버1
   */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static int N, M;
    private static boolean[][] isVisited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = array[0];
        M = array[1];
        map = new int[N + 1][M + 1];
        isVisited = new boolean[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            int[] array1 = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = array1[j - 1];
            }
        }


        bfs(1, 1);

        System.out.println(map[N][M]);
    }


    private static void bfs(int r, int c) {
        isVisited = new boolean[N + 1][M + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r, c));
        isVisited[r][c] = true;
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nr = poll.r + dr[dir];
                int nc = poll.c + dc[dir];

                if (nr > 0 && nr <= N && nc > 0 && nc <= M && !isVisited[nr][nc]) {
                    if(map[nr][nc]==1) {
                        isVisited[nr][nc] = true;
                        map[nr][nc] = map[poll.r][poll.c] + 1;
                        queue.offer(new Node(nr, nc));
                    }
                }

            }
        }
    }

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
