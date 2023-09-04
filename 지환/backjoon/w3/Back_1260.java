package 지환.backjoon.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1260 {
    /*
    백준 1260
    DFS, BFS
     */
    static int map[][];
    static StringBuilder sb = new StringBuilder();
    static int N;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st2.nextToken());
            int c2 = Integer.parseInt(st2.nextToken());
            map[c1][c2] = 1;
            map[c2][c1] = 1;
        }

        int[] dfs_visit = new int[N + 1];
        dfs(V,dfs_visit);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int start, int [] visit) {
        visit[start] = 1;
        sb.append(start).append(" ");
        for (int i = 0; i <= N; i++) {
            if (map[start][i] == 1 && visit[i] != 1) {
                dfs(i,visit);
            }
        }
    }

    static void bfs(int start) {
        int visit[] = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        //시작값 방문 했다 치고
        visit[start] = 1;
        //큐에 시작값 넣음
        queue.offer(start);
        sb.append(start).append(" ");
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 1; i < map.length; i++) {
                if (map[x][i] == 1 && visit[i] != 1) {
                    queue.offer(i);
                    visit[i] = 1;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}
