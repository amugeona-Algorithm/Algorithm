package Algorithm.지환.backjoon.w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_1654 {
    /*
    백준 1653
    랜선 자르기
     */

    static int K, N;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] lines = new int[K];
        for (int i = 0; i < K; i++) lines[i] = Integer.parseInt(br.readLine());

        Arrays.sort(lines);

        long min = 1;
        long max = lines[lines.length - 1];
        long mid = 0;

        while (min <= max) {
            long lanCount = 0;
            mid = (max + min) / 2;


            //라인이 몇개인지 확인
            for (int i = 0; i < K; i++) {
                lanCount += lines[i] / mid;
            }

            //랜선 갯수가 부족하면 더 작게 짜름
            if (lanCount < N) {
                max = mid - 1;
            } //그렇지 않다면 다음 탐색을 위해 최솟값 변경
            else {
                min = mid + 1;
            }
        }
        System.out.println(max);
    }
}

