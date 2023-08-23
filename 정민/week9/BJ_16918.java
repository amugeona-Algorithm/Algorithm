package 정민.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BJ_16918
 * 봄버맨
 */

class Bomb {
    int r;
    int c;

    public Bomb(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class BJ_16918 {
    static int R, C, N;
    static int sec = 1;
    static char[][] map;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 }; // 상하좌우
    static ArrayList<Bomb> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        list = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 1초 지남

        if (N % 2 == 0) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print('O');
                }
                System.out.println();
            }
            System.exit(0);
        }

        while (sec != N) {
            checkBomb(); // 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다.
            sec++;
            if (N == sec)
                break;
            destroy();
            sec++;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void checkBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O')
                    list.add(new Bomb(i, j)); // 먼저 파괴해야할 폭탄
                else
                    map[i][j] = 'O'; // 설치되어 있지 않은 칸에 폭탄 설치
            }
        }
    }

    public static void destroy() {
        // bfs
        for (int i = 0; i < list.size(); i++) {
            Bomb boom = list.get(i);
            map[boom.r][boom.c] = '.';

            for (int d = 0; d < 4; d++) {
                int nr = boom.r + dr[d];
                int nc = boom.c + dc[d];
                if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] == 'O') {
                    map[nr][nc] = '.';
                }
            }
        }
        list.clear();
    }

}