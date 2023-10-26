package 지환.week.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_2606 {
    /*
    백준 2606
    바이러스
     */
    static int map[][];
    static int visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int computerLineNumber = Integer.parseInt(br.readLine()); // 컴퓨터 연결 수

        map = new int[n + 1][n + 1];
        visit = new int[n + 1];

        for (int i = 0; i < computerLineNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            map[c1][c2] = 1;
            map[c2][c1] = 1;
        }

        bfs(1);

    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        //시작값 방문 했다 치고
        visit[start] = 1;

        //큐에 시작값 넣음
        queue.offer(start);

        int count = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 1; i < map.length; i++) {
                if (map[x][i] == 1 && visit[i] != 1) {
                    queue.offer(i);
                    visit[i] = 1;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
