package 민호.GraphTraversal;

import java.util.*;
import java.io.*;

public class BaekJoon_1325 {
    /**
     * 백준 1325
     * 그래프 탐색 - 효울적인 해킹
     * Sliver 1
     */

    static int N;
    static int M;
    static ArrayList<Integer> Node[];
    static int Result[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Node = new ArrayList[N + 1];
        Result = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            Node[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Node[y].add(x); //단방향 그래프
        }

        for (int i = 1; i < N + 1; i++) {
            dfs(i);
        }

        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            max = Math.max(max, Result[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            if (Result[i] == max) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int start) {
        int visit[] = new int[N + 1];
        int count = 1; //기본적으로 첫 컴퓨터는 해킹

        Stack<Integer> stack = new Stack<>(); //재귀함수로 dfs를 구현할 시 count(해킹 수)를 유지할 수 없어 stack으로 구현

        stack.push(start);
        visit[start] = 1;

        while (!stack.isEmpty()) {
            int out = stack.pop();

            for (int value : Node[out]) {
                if (visit[value] != 1) {
                    stack.push(value);
                    visit[value] = 1;
                    count++;
                }
            }
        }

        Result[start] = count;
    }

}
