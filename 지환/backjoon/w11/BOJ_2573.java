package 지환.backjoon.w11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2573 {
    /*
    빙산
     */

    private static int[][] map;

    private static int[][] temp;
    private static boolean[][] isVisited;
    private static int N, M;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;

        while (hasIce()) {
            time++;
            melt();
            if (isHalf()) {
                break;
            }
        }
        if(hasIce()){
            System.out.println(time);
        }else {
            System.out.println(0);
        }



    }

    private static void melt() {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    for (int dir = 0; dir < 4; dir++) {
                        int nr = i + dr[dir];
                        int nc = j + dc[dir];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < M && (map[nr][nc] > 0)) {
                            list.add(new Node(nr, nc));
                        }
                    }
                }
            }
        }
        for (Node n : list) {
            if (map[n.r][n.c] > 0) {
                map[n.r][n.c]--;
            }
        }
    }

    private static boolean isHalf() {
        temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] > 0) {
                    bfs(i, j);
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < M; l++) {
                            if (temp[k][l] > 0) {
                                return true;
                            }
                        }
                    }
                }
            }
        }


        return false;
    }

    private static boolean hasIce() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void bfs(int r, int c) {
        isVisited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r, c));
        isVisited[r][c] = true;
        temp[r][c] = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nr = poll.r + dr[dir];
                int nc = poll.c + dc[dir];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !isVisited[nr][nc] && temp[nr][nc] > 0) {
                    queue.offer(new Node(nr, nc));
                    temp[nr][nc] = 0;
                    isVisited[nr][nc] = true;
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
