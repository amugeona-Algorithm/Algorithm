package 지환.backjoon.w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back_18352 {
    /*
    백준 18352
    특정 거리의 도시 찾기
    실버 3
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringBuffer sb = new StringBuffer();
    private static StringTokenizer st;

    private static Map<String, Integer> map = new LinkedHashMap<>();

    private static int N;
    private static int M;
    private static int K;

    private static int X;

    private static int[] isVisited;
    private static List<List<Integer>> graph = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        isVisited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            isVisited[i] = -1;//방문 배열 방문 불가 상태로 초기화 , -1 은 무한을 의미
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
        }

        bfs(X);

        boolean flag = false;

        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i] == K) {
                flag = true;
                System.out.println(i);
            }
        }
        if (!flag) {
            System.out.println(-1);
        }
    }

    public static void bfs(int start) {
        //시작 정점의 최단거리는 0
        isVisited[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int v : graph.get(cur))
                //방문처리가 안되었다면
                if (isVisited[v] == -1) {
                    //현재 방문 포인트의 최단 거리 + 1 로 초기화
                    isVisited[v] = isVisited[cur] + 1;
                    queue.offer(v);
                }

        }
    }
}

