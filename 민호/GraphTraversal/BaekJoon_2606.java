package 민호.GraphTraversal;

import java.io.*;
import java.util.*;

public class BaekJoon_2606 {
    /**
     * 백준 2606
     * 그래프 탐색 - 바이러스
     * Silver 3
     */

    static int N;
    static int K;
    static int Node[][];
    static int Visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());


        Node = new int[N + 1][N + 1];
        Visit = new int[N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Node[x][y] = 1;
            Node[y][x] = 1;
        }

        int result = bfs(1);
        System.out.println(result);

    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        Visit[start] = 1;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int out = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (Node[out][i] == 1 && Visit[i] != 1) { //큐에서 제거된 숫자(노드)와 연결된 노드 && 방문하지 않은 노드
                    Visit[i] = 1;
                    queue.offer(i);
                    count++;
                }
            }
        }
        return count;
    }

}
