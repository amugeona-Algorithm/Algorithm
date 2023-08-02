package 정민.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BJ_1992 {
    /*
     * 백준 1992
     * 쿼드트리
     * 분할정복
     */
    static int N;
    static char[][] map;
    static String res;
    static List<Character> list;

    static class Loca {
        int sr;
        int sc;
        int er;
        int ec;

        public Loca(int sr, int sc, int er, int ec) {
            this.sr = sr;
            this.sc = sc;
            this.er = er;
            this.ec = ec;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        list = new LinkedList<>();

        /*
         * 쿼드 트리
         * 1 2
         * 3 4 순서
         */
        res = "";
        divide(new Loca(0, 0, N - 1, N - 1)); // 초기화
        System.out.println(res);
    }

    public static boolean isSame(Loca l) {

        char type = map[l.sr][l.sc];

        for (int i = l.sr; i <= l.er; i++) {
            for (int j = l.sc; j <= l.ec; j++) {
                if (type != map[i][j])
                    return false;
            }
        }
        res += type;
        return true;
    }

    public static void divide(Loca l) {
        if (isSame(l))
            return;

        // 자르기!
        res += "(";

        int midR = (l.sr + l.er) / 2;
        int midC = (l.sc + l.ec) / 2;
        divide(new Loca(l.sr, l.sc, midR, midC));
        divide(new Loca(l.sr, midC + 1, midR, l.ec));
        divide(new Loca(midR + 1, l.sc, l.er, midC));
        divide(new Loca(midR + 1, midC + 1, l.er, l.ec));

        res += ")";

    }
}
