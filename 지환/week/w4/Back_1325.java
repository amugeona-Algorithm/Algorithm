package 지환.week.w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back_1325 {
    /*
    백준 1325
    효율적인 해킹
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<List<Integer>> edges = new ArrayList<>();
    private static int[] visitedCount; // 각 정점에서 bfs 시 몇번 접근하는지 카운트, 만약 3이라면 자신포함 3개의 정점에서 탐색해서 도달 가능함.
    private static StringTokenizer st;
    private static int N;
    private static int M;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        visitedCount = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            bfs(i);
        }

        StringBuffer sb = new StringBuffer();

        int max = Arrays.stream(visitedCount).max().getAsInt();
        for (int i = 1; i < visitedCount.length; i++) {
            if (max == visitedCount[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.printf(sb.toString());

    }

    static void bfs(int index) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        visit[index] = true;

        while (!q.isEmpty()) {
            int curVertex = q.poll();
            for (int v : edges.get(curVertex)) {
                if (!visit[v]) {
                    visit[v] = true; // 방문처리
                    visitedCount[v] = visitedCount[v] + 1; //방문 카운트(v로 해킹 할 수 있는 컴퓨터 횟수) ++
                    q.offer(v);//curVertex 기준으로 v 까지만 탐색했으니, 다음에 v가 curVertex 가 되도록 큐에 추가
                }
            }
        }
    }
}

