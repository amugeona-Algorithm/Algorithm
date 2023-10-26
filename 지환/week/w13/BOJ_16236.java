package 지환.week.w13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {

    /*
    백준 16236
    아기 상어
    골드 3
    */

    private static int N;
    private static int[][] map;

    private static int[] dr = {-1, 0, 0, 1};
    private static int[] dc = {0, -1, 1, 0};
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int sharkLevel = 2;
    private static int sharkCount = 2;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];


        int startR = 0;
        int startC = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if (a == 9) {
                    startR = i;
                    startC = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Node nextShark = bfs(startR, startC);
            if (nextShark == null) {
                break;
            } else {
                //물고기 섭취
                map[nextShark.r][nextShark.c] = 0;
                startR = nextShark.r;
                startC = nextShark.c;
                sharkCount--;
                result += nextShark.dis;
                if (sharkCount == 0) {
                    sharkLevel++;
                    sharkCount = sharkLevel;
                }
            }
        }
        System.out.println(result);
    }

    private static Node bfs(int sharkR, int sharkC) {
        PriorityQueue<Node> fishQueue = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N][N];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sharkR, sharkC, 0));
        isVisited[sharkR][sharkC] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nr = poll.r + dr[dir];
                int nc = poll.c + dc[dir];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !isVisited[nr][nc] && map[nr][nc] <= sharkLevel) {
                    queue.add(new Node(nr, nc, poll.dis + 1));
                    isVisited[nr][nc] = true;
                    //물고기라면
                    if (map[nr][nc] != 0 && map[nr][nc] < sharkLevel) {
                        fishQueue.offer(new Node(nr, nc, poll.dis + 1));
                    }
                }
            }
        }
        if (fishQueue.isEmpty()) {
            return null;
        }
        return fishQueue.poll();
    }


    private static class Node implements Comparable<Node> {

        int r;
        int c;

        int dis;

        public Node(int r, int c, int dis) {
            this.r = r;
            this.c = c;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dis == o.dis) {
                if (this.r == o.r) {
                    return this.c - o.c;
                }
                return this.r - o.r;
            }
            return this.dis - o.dis;
        }
    }
}
