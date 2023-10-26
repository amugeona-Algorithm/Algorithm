package 지환.week.w5;

import java.io.*;
import java.util.*;

public class Back_15650 {
    /*
    백준 15650
    N 과 M (2)
     */
    private static int N;
    private static int M;
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] isUsed;
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
    }

    private static void func(int k) {
        if (k == M ) {
            for (int i = 0; i < M; i++) {
                System.out.printf(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!isUsed[i] && (k == 0 || i > arr[k - 1])) { //마지막으로 골랐던 수가 i 보다 커야 오름차순이 됨. 또한 첫 실행 시 k==0 일 경우 예외로 실행
                arr[k] = i;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false;
            }
        }
    }
}

