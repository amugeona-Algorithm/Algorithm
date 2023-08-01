package 준석.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BJ10815 {
    static int N;

    static int M;

    static Integer[] arrayN;
    static Integer[] arrayM;

    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arrayN = new Integer[N];
        String dataN = br.readLine();
        for (int i = 0; i < N; i++) {
            arrayN[i] = Integer.parseInt(dataN.split(" ")[i]);
        }
        Arrays.sort(arrayN);

        M = Integer.parseInt(br.readLine());
        String dataM = br.readLine();
        arrayM = new Integer[M];

        answer = new int[M];

        for (int i = 0; i < M; i++) {
            arrayM[i] = Integer.parseInt(dataM.split(" ")[i]);
        }
        play(0);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    static void play(int key) {
        if (key >= arrayM.length) return;

        int start = 0;
        int end = arrayN.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (arrayN[middle] == arrayM[key]) {
                answer[key] = 1;
                break;
            } else if (arrayN[middle] > arrayM[key]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        play(key + 1);
    }
}

