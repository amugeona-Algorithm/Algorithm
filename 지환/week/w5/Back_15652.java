package 지환.week.w5;

import java.io.*;
import java.util.*;

public class Back_15652 {
    /*
    백준 15625
    N과 M 4
     */
    private static int N;
    private static int M;
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();

    private static boolean[] isUsed;
    private static int[] arr;
    private static int[] inputNumbers;
    private static int count;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isUsed = new boolean[10];
        arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = i + 1;
        }
        func(1,0);
        System.out.println(sb.toString());

    }

    private static void func(int start ,int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            isUsed[i] = true;
            arr[k] = i;
            func(i,k + 1);
            isUsed[i] = false;
        }
    }
}

