package 지환.week.w11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2636 {
    /*
    백준 2636
    치즈
    골드 4
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int R;
    private static int C;

    public static void main(String[] args) throws IOException {
        String[] split = br.readLine().split(" ");

        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int count = 0;
        int cheCount = countChe();
        while (hasChe()) {
            cheCount = countChe();
            bfs(0, 0);

            count++;
        }
        System.out.println(count);
        System.out.println(cheCount);
    }

    private static int countChe() {
        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean hasChe() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }


    private static void bfs(int r, int c) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        isVisited = new boolean[R][C];

        isVisited[r][c] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r, c));
        List<Node> nexts = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nr = poll.r + dr[dir];
                int nc = poll.c + dc[dir];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !isVisited[nr][nc]) {
                    //치즈면 리스트에 넣어두고 다음 탐색
                    if (map[nr][nc] == 1) {
                        nexts.add(new Node(nr, nc));

                    } else {
                        queue.offer(new Node(nr, nc));
                        isVisited[nr][nc] = true;
                    }
                }
            }
        }
        for (Node n : nexts) {
            map[n.r][n.c] = 0;
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
