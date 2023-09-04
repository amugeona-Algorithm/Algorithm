package 지환.backjoon.w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_17829 {
    /*
    백준 17829
    222-풀링
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
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(divideMap(0, 0, N));

    }

    static int divideMap(int r, int c, int dist) {

        if (dist == 2) {
            int[] arr = new int[4];
            int index = 0;
            for (int i = r; i < r + 2; i++) {
                for (int j = c; j < c + 2; j++) {
                    arr[index++] = map[i][j];
                }
            }
            Arrays.sort(arr);
            return arr[2];
        } else {
            int[] arr = new int[4];
            dist = dist / 2;
            arr[0] = divideMap(r, c, dist);
            arr[1] = divideMap(r, c + dist, dist);
            arr[2] = divideMap(r + dist, c, dist);
            arr[3] = divideMap(r + dist, c + dist, dist);

            Arrays.sort(arr);
            return arr[2];
        }
    }
}

