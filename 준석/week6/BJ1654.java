package 준석.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BJ1654 {
    static int K;
    static int N;

    static long[] lineArray;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String data = sc.nextLine();
        K = Integer.parseInt(data.split(" ")[0]);
        N = Integer.parseInt(data.split(" ")[1]);

        lineArray = new long[K];

        for (int i = 0; i < K; i++) {
            lineArray[i] = sc.nextLong();
        }
        Arrays.sort(lineArray);

        System.out.println(play(1, lineArray[lineArray.length - 1]));
    }

    static long play(long start, long end) {
        if (start > end) return end;
        long middle = (start + end) / 2;
        long count = 0;

        for (int i = 0; i < K; i++) {
            count += lineArray[i] / middle;
        }
        if (count >= N) {
            return play(middle+1, end);
        } else {
            return play(start, middle-1);
        }
    }
}
