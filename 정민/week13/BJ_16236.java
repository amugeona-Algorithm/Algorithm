package 정민.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236 {
    /*
     * 백준 16236
     * 아기 상어
     * gold 3
     */
    static int N, sec, babySize, cnt;
    static int[][] map;
    static int[] dr = { -1, 0, 0, 1 }; // 상좌우하
    static int[] dc = { 0, -1, 1, 0 };
    static ArrayList<Shark> list;
    static Shark baby;

    static class Shark implements Comparable<Shark> {
        int r;
        int c;
        int size;
        int time;

        public Shark(int r, int c, int size, int time) {
            this.r = r;
            this.c = c;
            this.size = size;
            this.time = time;
        }

        @Override
        public int compareTo(Shark shark) {
            if (this.r == shark.r) {
                return this.c - shark.c;
            } else
                return this.r - shark.r;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        sec = 0;
        babySize = 2; // 아기상어 크기
        cnt = 0; // 크기 키워주기 위해서, 몇마리 먹었는지

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9)
                    baby = new Shark(i, j, babySize, 0);
            }
        }

        while (true) {
            if (!findDist(baby.r, baby.c)) // 탐색하면서 가장 가까이 만난 작은 물고기 먹기
                break;
        }

        System.out.println(sec);

    }

    public static boolean findDist(int sr, int sc) {
        Queue<Shark> que = new LinkedList<>();
        que.add(baby); // 초기 셋
        int bs = baby.size; // 아기상어 크기
        boolean[][] visited = new boolean[N][N]; // bfs 위한 방문 배열
        map[sr][sc] = 0; // 9로 저장되어 있던 아기상어 숫자 바꿔주기
        visited[sr][sc] = true;

        list = new ArrayList<>(); // 잡아먹을 수 있는 상어 리스트

        while (!que.isEmpty()) {
            int qsize = que.size(); // 같은 위치, 같은 초 만큼만,

            for (int q = 0; q < qsize; q++) {
                Shark s = que.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = s.r + dr[d];
                    int nc = s.c + dc[d];

                    if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
                        if (map[nr][nc] > bs) { // 크기가 크다면 피해가기
                            continue;
                        } else if (map[nr][nc] == bs || map[nr][nc] == 0) { // 지나갈수 있는 위치라면
                            que.add(new Shark(nr, nc, 0, s.time + 1));
                            visited[nr][nc] = true;
                        } else { // 잡아먹을 수 있다면
                            list.add(new Shark(nr, nc, map[nr][nc], s.time + 1));
                        }
                    }
                }
            }

            if (list.size() > 0) { // 잡아먹을 수 있는 상어가 있다면, 잡아먹기!
                eat();
                return true;
            }

        }
        return false;
    }

    public static void eat() {
        Collections.sort(list);
        Shark dele = list.get(0);

        cnt++;

        if (cnt == babySize) {
            cnt = 0;
            babySize++;
        }

        baby = new Shark(dele.r, dele.c, babySize, 0);
        sec += dele.time;
    }
}
