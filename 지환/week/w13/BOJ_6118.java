package 지환.week.w13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_6118 {
    /*
    백준 6118
    숨바꼭질
    실버 1
   */

    private static int N, M;
    private static List<List<Integer>> list = new ArrayList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] isVisited;


    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = array[0];
        M = array[1];
        int furthestEdge = 0;
        int count = 0;
        int furthestDis = 0;
        isVisited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int[] array1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = array1[0];
            int b = array1[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        isVisited[1] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            //새롭게 먼 헛간이 나온경우
            if (cur.dis > furthestDis) {
                furthestEdge = cur.edge;
                furthestDis = cur.dis;
                count = 1;
                //그렇지 않은 경우,
            } else if (cur.dis == furthestDis) {
                count++;
                //만약 거리가 같은 헛간이 여러개면 가장 작은 헛간 번호를 출력한다
                furthestEdge = Math.min(furthestEdge, cur.edge);
            }

            for (int x : list.get(cur.edge)) {
                if (isVisited[x]) {
                    continue;
                }
                isVisited[x] = true;
                queue.offer(new Node(x, cur.dis + 1));
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append(furthestEdge).append(" ").append(furthestDis).append(" ").append(count).append(" ");
        System.out.println(sb.toString());

    }

    static class Node {
        int edge;
        int dis;

        public Node(int edge, int next) {
            this.edge = edge;
            this.dis = next;
        }
    }
}
