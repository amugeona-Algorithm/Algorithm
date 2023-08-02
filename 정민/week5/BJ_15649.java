package 정민.week5;

import java.util.Scanner;

public class BJ_15649 {
    /*
     * 백준 15649
     * N과 M (1)
     * backtracking
     */

    static int N, M, res;
    static boolean[] isSelected;
    static int[] numbers;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();

        isSelected = new boolean[N + 1]; // 선택했는지 배열
        numbers = new int[M]; // 선택 숫자 배열

        // 1부터 N까지 자연 수 중 중복없이 M개 수열
        permutation(0);
        System.out.print(sb);

    }

    public static void permutation(int cnt) {

        if (cnt == M) {
            String s = "";
            for (int i = 0; i < M; i++) {
                s += numbers[i] + " ";
            }
            sb.append(s + "\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isSelected[i])
                continue;
            else {
                numbers[cnt] = i;
                isSelected[i] = true;
                permutation(cnt + 1);
                isSelected[i] = false;
            }
        }

    }
}
