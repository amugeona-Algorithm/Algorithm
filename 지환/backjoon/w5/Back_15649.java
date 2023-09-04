package 지환.backjoon.w5;

import java.io.*;
import java.util.*;

public class Back_15649 {
    /*
    백준 15649
    N 과 M (1)
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
        isUsed = new boolean[10];//정수 10 개라서 그냥 10칸짜리로 초기화. inUsed[1] 은 1을 의미
        arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = i + 1;
        }
        //0부터 넣어주는 이유는 aar[0] 부터 채워 넣기 위함
        func(0);
    }

    private static void func(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.printf(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <=N ; i++) {
            if(!isUsed[i]){
                arr[k] = i;
                isUsed[i] = true;//사용됨 처리
                func(k + 1); //다음으로 진행
                isUsed[i] = false; //재귀 끝나고 나오면서 사용처리 풀어줌. -> 다시 써야해서
            }
        }
    }
}

