package 지환.week.w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1992 {
    /*
    백준 1992
    쿼드 트리
     */

    private static int N;
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        divideMap(0, 0, N);
        System.out.println(sb.toString());

    }

    static void divideMap(int r, int c, int size) {
        if (canDiv(r, c, size) || size == 1) {
            sb.append(map[r][c]);
            return;
        }
        size = size / 2;
        sb.append("(");
        divideMap(r, c, size);
        divideMap(r, c + size, size);
        divideMap(r + size, c, size);
        divideMap(r + size, c + size, size);
        sb.append(")");
    }

    public static boolean canDiv(int r, int c, int dist) {
        int value = map[r][c];
        for (int i = r; i < r + dist; i++) {
            for (int j = c; j < c + dist; j++) {
                if (value != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

