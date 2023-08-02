package 준석.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2805 {
    static int N;
    static int M;
    static int[] treeHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data = br.readLine();

        N = Integer.parseInt(data.split(" ")[0]);
        M = Integer.parseInt(data.split(" ")[1]);

        String numberOfTree = br.readLine();

        treeHeight = new int[N];

        for (int i = 0; i < N; i++) {
            treeHeight[i] = Integer.parseInt(numberOfTree.split(" ")[i]);
        }
        Arrays.sort(treeHeight);
        System.out.println(play(0, treeHeight[treeHeight.length - 1]));
    }

    static int play(int start, int end) {
        if (start > end) return end;
        int middle = (start + end) / 2;
        int sum = 0;

        for (int i = 0; i < treeHeight.length; i++) {
            if (treeHeight[i] >= middle) {
                sum += treeHeight[i] - middle;
            }
        }
        if (sum >= M) {
            return play(middle + 1, end);
        } else {
            return play(start, middle - 1);
        }
    }
}
