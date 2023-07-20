package 정민.week4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BJ_11725 {

    /*
     * 백준 11725
     * 트리의 부모찾기
     */

    static int N;
    static ArrayList<ArrayList<Integer>> list;
    static Stack<Integer> stack;
    static boolean[] check;
    static int res[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        check = new boolean[N + 1];
        res = new int[N + 1];
        list = new ArrayList<>();

        // 초기화
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        check[1] = true;

        dfs(1, 0);

        for (int i = 2; i <= N; i++) {
            System.out.println(res[i]);
        }
    }

    public static void dfs(int v, int parent) {
        for (int x : list.get(v)) {
            if (x == parent)
                continue; // 부모 노드는 제외
            res[x] = v; // v는 x의 부모
            dfs(x, v);
        }
    }

}
