package 준석.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ18352 {
    static int N;
    static int M;
    static int K;
    static int X;

    static List<Integer>[] list;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);
        K = Integer.parseInt(data[2]);
        X = Integer.parseInt(data[3]);

        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] value = br.readLine().split(" ");
            list[Integer.parseInt(value[0])].add(Integer.parseInt(value[1]));
        }

        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        dijkstra(X);

        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                flag = true;
            }
        }

        if (!flag) {
            System.out.println(-1);
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int city = current[0];
            int dist = current[1];

            if (distance[city] < dist) {
                continue;
            }

            for (int nextCity : list[city]) {
                if (distance[nextCity] > dist + 1) {
                    distance[nextCity] = dist + 1;
                    pq.offer(new int[]{nextCity, dist + 1});
                }
            }
        }
    }
}
