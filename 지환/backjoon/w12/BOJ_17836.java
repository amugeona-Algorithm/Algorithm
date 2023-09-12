package 지환.backjoon.w12;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_17836 {

     /*
    백준 17836
    공주님을 구해라
    골드 5
   */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, T;
    private static int[][] map;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static boolean[][] isVisited;
    private static int swordDis = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = array[0];
        M = array[1];
        T = array[2];
        isVisited = new boolean[N + 1][M + 1];
        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            int[] array1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= M; j++) {
                map[i][j] = array1[j - 1];
            }
        }
        bfs(1, 1);
        if (map[N][M] == 0 && swordDis <= T){
            System.out.println(swordDis);

        }
        else if (map[N][M] != 0 && swordDis <= T) {
            System.out.println(Math.min(map[N][M], swordDis));
        } else if (map[N][M] != 0 && map[N][M] <= T) {
            System.out.println(map[N][M]);
        } else {
            System.out.println("Fail");
        }

    }

    private static void bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r, c));
        isVisited[r][c] = true;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nr = poll.r + dr[dir];
                int nc = poll.c + dc[dir];

                if (nr > 0 && nr <= N && nc > 0 && nc <= M && !isVisited[nr][nc] && (map[nr][nc] == 0 || map[nr][nc] == 2)) {
                    if (map[nr][nc] == 2) {
                        //검 흭득 시 현 위치에 1더한 값 에서 + 공주와의 남은 거리
                        swordDis = Math.abs(N - nr) + Math.abs(M - nc) + map[poll.r][poll.c] + 1;
                    }
                    isVisited[nr][nc] = true;
                    map[nr][nc] = map[poll.r][poll.c] + 1;
                    queue.offer(new Node(nr, nc));
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
