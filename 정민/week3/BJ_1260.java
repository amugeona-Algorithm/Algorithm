package 정민.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260 {
    /*
     * 백준 1260
     * DFS와 BFS
     */
    static int N, M, V; // 정점 개수, 간선 개수, 시작 정점 번호
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) { // init
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        bfs();
        System.out.println(sb.toString());
    }

    public static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        visited = new boolean[N + 1];
        que.add(V);
        visited[V] = true;

        while (!que.isEmpty()) {
            int n = que.poll();
            sb.append(n + " ");

            for (int i = 0; i < graph.get(n).size(); i++) {
                int temp = graph.get(n).get(i);
                if (!visited[temp]) {
                    visited[temp] = true;
                    que.add(temp);
                }
            }
        }
    }

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");
        for (int i = 0; i < graph.get(start).size(); i++) {
            int num = graph.get(start).get(i);
            if (!visited[num]) {
                dfs(num);
            }
        }
        return;
    }
}