package 민호.ShortestPath;

import java.util.*;
import java.io.*;

public class BaekJoon_18352 {
    /**
     * 백준 18352
     * 최단거리 - 특정 거리의 도시 찾기 (다익스트라 알고리즘 - 최소 비용 경로)
     * Sliver 2
     */

    static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    static int N, M, K, X; //도시의 개수, 도로의 개수, 거리 정보, 출발 도시 번호
    static ArrayList<Node>[] graph; //노드 간 연결 여부
    static int[] visit; //노드 방문
    static int[] distance;  //각 노드로의 최소 거리
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visit = new int[N + 1];
        distance = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;    //노드까지의 거리를 최대값으로 해둬야 나중에 최소값으로 대체 가능
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(new Node(y, 1)); //단방향 그래프, 비용 1
        }

        dijkstra(X);

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == K) {
                sb.append(i).append("\n");
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost); //우선순위 큐 사용, 비용이 적은 노드부터 큐에서 제거

        priorityQueue.add(new Node(start, 0));
        distance[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node nowNode = priorityQueue.poll();

            if (visit[nowNode.index] == 0)  //방문하지 않은 노드라면 방문 표시
                visit[nowNode.index] = 1;

            for (Node nextNode : graph[nowNode.index]) {
                if (visit[nextNode.index] == 0 && distance[nextNode.index] > distance[nowNode.index] + nextNode.cost) {   //저장된 다음 노드까지의 거리 > 저장된 현재 노드까지의 거리 + 다음 노드로의 비용
                    distance[nextNode.index] = distance[nowNode.index] + nextNode.cost;
                    priorityQueue.add(new Node(nextNode.index, distance[nextNode.index]));
                }
            }
        }
    }

}
