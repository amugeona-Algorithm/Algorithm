package 민호.GraphTraversal;

import java.util.*;
import java.io.*;

public class BaekJoon_1260 {
    /**
     * 백준 1260
     * 그래프 탐색 - DFS와 BFS
     * Silver 2
     */
    static int N, E, S;
    static int Node[][];
    static int DfsVisit[];
    static int BfsVisit[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        Node = new int[N + 1][N + 1];
        DfsVisit = new int[N + 1];
        BfsVisit = new int[N + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Node[x][y] = 1;
            Node[y][x] = 1;
        }

        dfs(S);
        System.out.println();
        bfs(S);
    }

    static void dfs(int start) {
        DfsVisit[start] = 1;
        System.out.print(start + " ");

        for (int i = 1; i <= N; i++) {
            if (Node[start][i] == 1 && DfsVisit[i] != 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        BfsVisit[start] = 1;
        queue.offer(start);
        result.append(start).append(" ");

        while (!queue.isEmpty()) {
            int out = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (Node[out][i] == 1 && BfsVisit[i] != 1) {
                    queue.offer(i);
                    BfsVisit[i] = 1;
                    result.append(i).append(" ");
                }
            }
        }
        System.out.println(result);
    }

}
