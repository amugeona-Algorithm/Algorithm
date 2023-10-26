package 지환.week.w5;

import java.io.*;
import java.util.*;

public class Back_1182 {
    /*
    백준 1182
    부분수열의합
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
        isUsed = new boolean[N];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
        }
        func(0, 0);
        if (M == 0) {
            count--;
        }
        System.out.println(count);


    }

    private static void func(int cur, int total) {
        if (cur == N) {
            if (total == M) {
                count++;
            }
            return;
        }
        func(cur + 1, total);
        func(cur + 1, total + arr[cur]);
    }
}

