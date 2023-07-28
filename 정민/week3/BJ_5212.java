package 정민.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_5212 {
    /*
     * 백준 5212
     * 지구 온난화
     * 시뮬레이션
     */

    static int R, C;
    static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dc = { 0, 0, -1, 1 };
    static char[][] map, fifty;

    static class Loca {
        int r;
        int c;

        public Loca(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static ArrayList<Loca> list;
    static int sr, sc, er, ec;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        fifty = new char[R][C];
        list = new ArrayList<>();

        sr = Integer.MAX_VALUE;
        sc = Integer.MAX_VALUE;
        er = Integer.MIN_VALUE;
        ec = Integer.MIN_VALUE;

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X')
                    list.add(new Loca(i, j)); // 섬일 경우 한꺼번에 넣고 확인
            }
            System.arraycopy(map[i], 0, fifty[i], 0, C); // 배열 복사 깊은 복사
        }

        for (int i = 0; i < list.size(); i++) {
            melting(list.get(i).r, list.get(i).c);
        }

        for (int i = sr; i <= er; i++) {
            for (int j = sc; j <= ec; j++) {
                System.out.print(fifty[i][j]);
            }
            System.out.println();
        }

    }

    public static void melting(int r, int c) {
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == '.') {
                cnt++;
            }
        }

        if (cnt >= 3) { // 물에 잠기기
            fifty[r][c] = '.';
        } else {
            sr = Math.min(r, sr);
            sc = Math.min(c, sc);
            er = Math.max(r, er);
            ec = Math.max(c, ec);
        }
    }
}
