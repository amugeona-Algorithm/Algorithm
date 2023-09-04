package 지환.backjoon.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back_16234 {
    /*
    백준 16234
    인구이동
     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = new int[]{0,1,0,-1};
    static int[] dc = new int[]{1,0,-1,0}; // 우좌상하
    static int N, L, R;
    static List<Place> unionList = new ArrayList<>();

    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
            }
        }
        System.out.println(check());

    }


    public static int check() {
        int result = 0;
        while (true) {
            boolean isMove = false;
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        int sum = bfs(i, j);
                        if (unionList.size() > 1) {
                            move(sum);
                            isMove = true;
                        }
                    }
                }
            }

            if (!isMove) return result;
            result++;
        }
    }

    static int bfs(int r, int c) {
        Queue<Place> que = new LinkedList<>();
        unionList = new ArrayList<>();

        que.offer(new Place(r, c));
        unionList.add(new Place(r, c));
        visit[r][c] = true;


        //일단 더하고 시작
        int uniPeopleNum = map[r][c];

        while (!que.isEmpty()) {
            Place cur = que.poll();
            for (int dir = 0; dir < 4; dir++) {
                if (cur.r + dr[dir] >= 0 && cur.c + dc[dir] >= 0 && cur.r + dr[dir] < N && cur.c + dc[dir] < N && !visit[cur.r + dr[dir]][cur.c + dc[dir]]) {//방문 가능한 경우
                    if (isOpen(cur.r, cur.c, cur.r + dr[dir], cur.c + dc[dir])) {
                        que.offer(new Place(cur.r + dr[dir], cur.c + dc[dir]));
                        unionList.add(new Place(cur.r + dr[dir], cur.c + dc[dir]));
                        uniPeopleNum += map[cur.r + dr[dir]][cur.c + dc[dir]];
                        visit[cur.r + dr[dir]][cur.c + dc[dir]] = true;
                    }
                }
            }
        }
        //애초에 옆 노드로 못 간경우 여기서 반환되는 것은 자신 하나임
        return uniPeopleNum;
    }

    static void move(int sum) {
        int tmp = sum / unionList.size();
        for (Place p : unionList) {
            map[p.r][p.c] = tmp;
        }
    }
    private static boolean isOpen(int curR, int curC, int nR, int nC) {
        int abs = Math.abs(map[curR][curC] - map[nR][nC]);
        return L <= abs && abs <= R;
    }
    static class Place {
        int r, c;

        public Place(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
