package 정민.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2606_before {

    // 예전 풀이

    static int N, M, res; // 컴퓨터의 수, 간선 수, 결과 값
    static int[][] com; // 컴퓨터의 연결 정보
    static boolean[] check; // 방문

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        com = new int[N + 1][N + 1];
        check = new boolean[N + 1];

        // 입력 정보 받기
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            com[x][y] = com[y][x] = 1;
        }

        // bfs 호출
        bfs(1);
        System.out.println(res);

    }

    public static void bfs(int i) {
        check[i] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        res = 0;

        while (!que.isEmpty()) {
            int temp = que.poll();
            for (int j = 1; j <= N; j++) {
                if (com[temp][j] == 1 && check[j] == false) {
                    que.add(j);
                    check[j] = true;
                    res++;
                }
            }
        }

    }
}
