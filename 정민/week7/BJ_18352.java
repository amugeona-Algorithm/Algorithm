package 정민.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_18352 {
    /*
     * 백준 18352
     * 특정 거리의 도시 찾기
     * 최단 경로 -> bfs 풀이
     */
    static int N, M, K, X;
    static ArrayList<Integer> res;
    static ArrayList<ArrayList<Integer>> list;

    static class Loca {
        int num;
        int dist;

        public Loca(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        res = new ArrayList<>(); // 결과 담는
        list = new ArrayList<>();

        // 1번부터 N번까지의 도시, M개의 단방향 도로
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        bfs(X);

        if (res.size() == 0)
            System.out.println("-1");
        else {
            Collections.sort(res);
            for (int n : res)
                System.out.println(n);
        }

    }

    public static void bfs(int start) {
        // X 부터 시작
        Queue<Loca> que = new LinkedList<>();
        boolean[] isVisited = new boolean[N + 1];
        que.add(new Loca(start, 0));
        isVisited[start] = true;

        while (!que.isEmpty()) {
            Loca city = que.poll();

            if (city.dist == K)
                res.add(city.num);

            for (int i = 0; i < list.get(city.num).size(); i++) {
                int n = list.get(city.num).get(i);
                if (!isVisited[n]) {
                    que.add(new Loca(n, city.dist + 1));
                    isVisited[n] = true;
                }
            }

        }
        return;

    }
}