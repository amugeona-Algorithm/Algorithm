package 지환.week.w5;

import java.io.*;
import java.util.*;

public class Back_15651 {
    /*
    백준 15651
    N 과 M (3)
     */
    private static int N;
    private static int M;
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] isUsed;
    private static StringBuffer sb = new StringBuffer();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isUsed = new boolean[10];
        arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = i + 1;
        }
        //0부터 넣어주는 이유는 aar[0] 부터 채워 넣기 위함
        func(0);
        System.out.printf(sb.toString());
    }

    private static void func(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {

            arr[k] = i;
            isUsed[i] = true;
            func(k + 1);
            isUsed[i] = false;

        }
    }
}

