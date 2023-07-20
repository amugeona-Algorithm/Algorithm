package Algorithm.지환.backjoon.w5;

import java.io.*;
import java.util.*;

public class Back_2805 {
    /*
    백준 2805 나무자르기
     */

    private static int N;
    private static int M;
    static int[] numbers;
    static int[] trees;
    static int result = 0;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        cutWithBiSearch();
    }

    private static void cutWithBiSearch() {
        int min = 0;

        //나무중 가장 큰 것
        Arrays.sort(trees);
        int max = trees[N - 1];
        int mid = 0;
        while (min < max) {

            mid = (min + max) / 2;
            long sum = 0;

            for (int treeH : trees) {
                int sub = treeH - mid;
                if (sub > 0) {
                    sum += sub;
                }

            }

            if (sum < M) {
                max = mid;
            } else if (sum >= M) {
                //결과 저장
                result = mid;

                //높이의 최대를 구해야하기 때문에 mid + 1
                min = mid + 1;
            }
        }
        System.out.println(result);
    }
}

