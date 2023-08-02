package 정민.week6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_15663 {
    /*
     * 백준 15663
     * N과 M (9)
     */
    static int N, M;
    static int[] numbers, res; // 숫자 저장 배열
    static boolean[] isSelected; // 선택되었는지 저장 배열
    static StringBuilder sb;
    static Set<String> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();

        numbers = new int[N + 1];
        res = new int[M];
        isSelected = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers); // 사전 순 출력 위해 정렬
        list = new LinkedHashSet<>();

        permutation(0);
        Iterator<String> iter = list.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());

    }

    public static void permutation(int cnt) {
        if (cnt == M) {
            String s = "";
            for (int i = 0; i < M; i++) {
                int n = res[i];
                s += numbers[n] + " ";
            }
            list.add(s);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isSelected[i])
                continue;
            else {
                res[cnt] = i;
                isSelected[i] = true;
                permutation(cnt + 1);
                isSelected[i] = false;
            }
        }

    }

}
