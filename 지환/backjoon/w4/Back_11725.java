package Algorithm.지환.backjoon.w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back_11725 {
    /*
    백준 11725
    트리의 부모 찾기
     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static boolean[] visit;
    static int[] parents;
    static List<List<Integer>> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        visit = new boolean[N + 1];
        parents = new int[N + 1]; // 각 정점의 부모 매핑 배열
        for (int i = 0; i < N + 1; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());

            edges.get(firstNode).add(secondNode);//노드 연결, edges 에는 각 노드가 갈수 있는 경로를 넣어둠.
            edges.get(secondNode).add(firstNode);
        }

        dfs(1);// 1번부터 탐색

        for (int i = 2; i < N + 1; i++) {
            System.out.println(parents[i]);
        }

    }

    static void dfs(int node) {
        visit[node] = true;
        for (int v : edges.get(node)) {
            if (!visit[v]) {
                dfs(v);//node 에서 갈수 있는 경로 V 들중 하나로 다시 dfs
                //부모노드 설정
                parents[v] = node;//v로 접근하기 이전에 인자로 받았던 node 가 해당 v 의 부모
            }
        }
    }

}
