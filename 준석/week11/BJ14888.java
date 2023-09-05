package 준석.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BJ14888 {
    static int N;

    static int[] array;

    static int[] operator = new int[4];

    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        array = new int[N];
        String data = br.readLine();
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(data.split(" ")[i]);
        }

        String operatorArray = br.readLine();
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(operatorArray.split(" ")[i]);
        }
        play(array[0], 1);

        Collections.sort(result);

        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }

    static void play(int sum, int index) {
        if (index == N) {
            result.add(sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                if (i == 0) {
                    play(sum + array[index], index + 1);
                }
                if (i == 1) {
                    play(sum - array[index], index + 1);
                }
                if (i == 2) {
                    play(sum * array[index], index + 1);
                }
                if (i == 3) {
                    play(sum / array[index], index + 1);
                }
                operator[i]++;
            }
        }
    }
}
