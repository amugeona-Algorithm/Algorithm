package 민호.GraphTraversal;

import java.util.*;
import java.io.*;

public class BaekJoon_11725 {
    /**
     * 백준 11725
     * 그래프 탐색 - 트리의 부모 찾기
     * Silver 2
     * N의 범위가 클 경우 모든 노드를 2차원배열로 선언 시 메모리 초과 -> ArrayList로 선언 후 각 노드와 연결된 노드 Index를 add
     */

    static int N;
    static ArrayList<Integer> NodeList[];
    static int ParentNode[];
    static int Visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        NodeList = new ArrayList[N + 1];
        ParentNode = new int[N + 1];
        Visit = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            NodeList[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            NodeList[x].add(y);
            NodeList[y].add(x);
        }

        bfs(1);
        for (int i = 2; i < ParentNode.length; i++) {
            System.out.println(ParentNode[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        Visit[start] = 1;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int out = queue.poll();

            for (int linkedNode : NodeList[out]) {
                if (Visit[linkedNode] != 1) {
                    Visit[linkedNode] = 1;
                    queue.offer(linkedNode);
                    ParentNode[linkedNode] = out;
                }
            }
        }
    }
}
