package 지환.w14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5547 {
          /*
    백준 5547
    일루미네이션
    골드 4
    */

    static int w, h;
    static int[][] map;
    static int[][] odd = { {0, -1}, { -1,  0}, {-1, 1}, {0, 1}, {1,  1}, {1, 0}};
    static int[][] even = { {0, -1}, { -1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}};
    static boolean[][] visit;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        //전체 맵의 테두까지 포함해야하기 때문에 + 2 , 0 으로 한번 테두리를 감싸서 정육각형 형태로 유지하기 위함
        map = new int[w + 2][h + 2];
        visit = new boolean[w + 2][h + 2];
        result = new int[w + 2][h + 2];

        for (int i = 1; i <= w; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= h; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    visit[i][j] = true;
                }
            }
        }
        bfs(0, 0);
        int answer = 0;
        for (int i = 0; i < w + 2; i++) {
            for (int j = 0; j < h + 2; j++) {
                answer += result[i][j];
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        visit[r][c] = true;

        while (!q.isEmpty()) {
            Node poll = q.poll();
            int tempR = poll.x;
            int tempC = poll.y;

            for (int dir = 0; dir < 6; dir++) {
                int nr = 0;
                int nc = 0;
                if (r % 2 == 1) {
                    nr = tempR + odd[dir][0];
                    nc = tempC + odd[dir][1];
                } else {
                    nr = tempR + even[dir][0];
                    nc = tempC + even[dir][1];
                }

                if (nr < 0 || nr >= w + 2 || nc < 0 || nc >= h + 2) continue;
                if (map[nr][nc] == 1) {
                    result[r][c]+=1;
                    continue;
                }
                if (visit[nr][nc]) continue;
                visit[nr][nc] = true;
                q.add(new Node(nr, nc));
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
