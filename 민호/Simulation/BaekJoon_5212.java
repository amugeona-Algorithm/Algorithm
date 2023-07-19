package 민호.Simulation;

import java.util.*;
import java.io.*;

public class BaekJoon_5212 {
    /**
     * 백준 5212
     * 시뮬레이션 - 지구온난화
     * Silver 2
     */

    static int R, C;
    static int dr[] = {-1, 1, 0, 0}; //상 하 좌 우(x좌표)
    static int dc[] = {0, 0, -1, 1}; //상 하 자 우(y좌표)
    static int sr = Integer.MAX_VALUE; //지도의 출력할 시작, 종료 좌표
    static int sc = Integer.MAX_VALUE;
    static int er = Integer.MIN_VALUE;
    static int ec = Integer.MIN_VALUE;
    static char map[][];
    static char mapAfter[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        mapAfter = new char[R][C];

        for (int i = 0; i < R; i++) {
            char tmp[] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp[j];
            }
            mapAfter[i] = map[i].clone(); //2차원 배열 깊은 복사
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                checkIsland(i, j);
            }
        }

        for (int i = sr; i <= er; i++) {
            for (int j = sc; j <= ec; j++) {
                System.out.print(mapAfter[i][j]);
            }
            System.out.println();
        }

    }

    static void checkIsland(int r, int c) {
        int count = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == '.') {
                count++;
            }
        }
        if (count >= 3) {
            mapAfter[r][c] = '.';
        } else {    // count 3이하인 경우 X(섬) -> 섬일때 출력할 좌표 갱신
            sr = Math.min(r, sr);
            sc = Math.min(c, sc);
            er = Math.max(r, er);
            ec = Math.max(c, ec);
        }
    }

}
