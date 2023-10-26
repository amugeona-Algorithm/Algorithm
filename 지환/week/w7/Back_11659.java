package 지환.week.w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_11659 {
    /*
    백준 11659
    구간합 구하기4
    실버 3
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringBuffer sb = new StringBuffer();
    private static StringTokenizer st;
    private static int N;
    private static int M;
    private static int[] prefix = new int[1000001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(prefix[end] - prefix[start - 1]).append("\n");
        }
        System.out.printf(sb.toString());
    }
}

