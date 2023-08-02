package 정민.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2630 {
    /*
     * 백준 2630
     * 색종이 만들기
     */
    static int N, white, blue;
    static int[][] map;
    static Queue<Position> que;

    static class Position {
        int sr;
        int sc;
        int er;
        int ec;

        public Position(int sr, int sc, int er, int ec) {
            this.sr = sr;
            this.sc = sc;
            this.er = er;
            this.ec = ec;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        white = 0;
        blue = 0;

        que = new LinkedList<>();
        que.add(new Position(0, 0, N - 1, N - 1));

        while (!que.isEmpty()) {
            Position nP = que.poll();

            if (!isSame(nP.sr, nP.sc, nP.er, nP.ec)) { // 색종이가 다르다면
                /*
                 * 1 3
                 * 2 4
                 */
                int midR = (nP.sr + nP.er) / 2;
                int midC = (nP.sc + nP.ec) / 2;
                que.add(new Position(nP.sr, nP.sc, midR, midC));
                que.add(new Position(midR + 1, nP.sc, nP.er, midC));
                que.add(new Position(nP.sr, midC + 1, midR, nP.ec));
                que.add(new Position(midR + 1, midC + 1, nP.er, nP.ec));
            }

        }

        System.out.println(white);
        System.out.println(blue);

    }

    public static boolean isSame(int sr, int sc, int er, int ec) {
        int type = map[sr][sc]; // 0이면 white, 1이면 blue

        for (int i = sr; i <= er; i++) {
            for (int j = sc; j <= ec; j++) {
                if (type != map[i][j])
                    return false;
            }
        }

        if (type == 0)
            white++;
        else
            blue++;
        return true;

    }
}
