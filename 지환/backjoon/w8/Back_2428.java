package Algorithm.지환.backjoon.w8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back_2428 {

    /*
    백준 2428
    표절
    실버 3
     */
    static int N;

    static int X;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        long count = 0;
        int st = 0;
        int en = 0;

        while (st < N) {
            while (true) {
                //범위 초과 시 그만
                if (en >= N - 1) {
                    break;
                }

                int file1 = numbers[st];
                int file2 = numbers[en + 1];
                if (file1 < file2 * 0.9) {
                    break;
                }
                en++;// 이동
            }
            count += en - st;//검사 해야할 구간에 있는 파일 수들
            st++;// 시작인덱스 이동
        }

        System.out.println(count);
    }
}

