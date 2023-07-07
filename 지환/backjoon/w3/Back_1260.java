package Algorithm.지환.backjoon.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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
        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }


    private static void dfs(int start) {
        Stack<Integer> s = new Stack<>();
        int visit[] = new int[N + 1];
        visit[start] = 1;
        s.push(start);
        sb.append(start).append(" ");

        while (!s.isEmpty()) {
            int cur_v = s.peek(); // 현재 갖고 있는 정점 확인. remove 아님
            boolean isEnd = false; // 탐색 중, 끝을 찍었는지 여부
            for (int i = 1; i < map.length; i++) {
                if (map[cur_v][i] == 1 && visit[i] != 1) {
                    visit[i] = 1;
                    s.push(i);
                    sb.append(s.peek()).append(" ");
                    isEnd = true;
                    break;
                }
            }
            if (!isEnd) {
                s.pop();
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
