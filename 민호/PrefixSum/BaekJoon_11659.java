package 민호.PrefixSum;

import java.util.*;
import java.io.*;

public class BaekJoon_11659 {
    /**
     * 백준 11659
     * 누적 합 - 구간 합 구하기4
     * Sliver 3
     */

    static int N, M;
    static int[] numberArray;
    static int S, E;
    static int[] prefix;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        numberArray = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            numberArray[i] = Integer.parseInt(st.nextToken());
        }

        prefix = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            prefix[i] = prefix[i - 1] + numberArray[i];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            sb.append(prefix[E] - prefix[S - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
