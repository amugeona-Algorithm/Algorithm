package 지환.week.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_16349 {
    /*
    백준 16349
    치킨치킨치킨
     */

    static int N, M, result;
    static int[][] che ;
    static int[] comb = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        che = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                che[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        createComb(0, 0);

        System.out.println(result);
    }

    private static void createComb(int depth, int start) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += getMax(i);
            }
            if (sum > result) {
                result = sum;
            }
            return;
        }
        for (int i = start; i < M; i++) {
            comb[depth] = i;
            createComb(depth + 1, i + 1);
        }
    }

    private static int getMax(int index) {
        int max = 0;
        for (int j = 0; j < 3; j++) {
            int temp = che[index][comb[j]];
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
