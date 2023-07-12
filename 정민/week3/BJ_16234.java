package 정민.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16234 {
    /*
     * 백준 16234
     * 인구 이동
     * 시뮬레이션
     */
    static int N, L, R, day, union;
    static int[][] map;
    static LinkedList<Loca> tempList, list;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 }; // 상하좌우

    static class Loca {
        int r;
        int c;
        int ppl;

        public Loca(int r, int c, int ppl) {
            this.r = r;
            this.c = c;
            this.ppl = ppl;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        day = 0;

        checkDiff();
        System.out.println(day);

    }

    public static void checkDiff() { // 차이 확인

        // bfs 로 구역 짓기
        while (true) {
            union = 0; // 연합 개수 세기
            visited = new boolean[N][N];
            list = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j])
                        bfs(i, j); // 연합을 이루고 있는 칸의 개수 세기
                }
            }

            if (union == 0) // 연합이 하나도 없을 때
                break;
            moving();

        }

    }

    public static void bfs(int r, int c) {
        Queue<Loca> que = new LinkedList<>();
        que.add(new Loca(r, c, 0));
        visited[r][c] = true;

        tempList = new LinkedList<>();
        int sum = 0; // 연합 인구수

        while (!que.isEmpty()) {
            Loca now = que.poll();
            tempList.add(new Loca(now.r, now.c, 0));
            sum += map[now.r][now.c];

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
                    int diff = Math.abs(map[now.r][now.c] - map[nr][nc]);
                    if (diff >= L && diff <= R) { // 국경선 열려있음
                        que.add(new Loca(nr, nc, 0));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        if (tempList.size() > 1) {
            union++; // 연합 발생
            int count = tempList.size();
            int num = sum / count;

            for (int i = 0; i < count; i++) {
                Loca l = tempList.get(i);
                list.add(new Loca(l.r, l.c, num));
            }
        }

        return;

    }

    public static void moving() {
        for (int i = 0; i < list.size(); i++) {
            Loca l = list.get(i);
            map[l.r][l.c] = l.ppl;
        }

        day++;
    }
}
