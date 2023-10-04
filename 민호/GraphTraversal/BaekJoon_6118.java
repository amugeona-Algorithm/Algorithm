package 민호.GraphTraversal;

import java.util.*;
import java.io.*;

public class BaekJoon_6118 {
    /**
     * 백준 6118
     * 그래프 탐색 - 숨바꼭질
     * Sliver 1
     */

    static int N, M;
    static ArrayList<Integer> Connect[];    //메모리 초과를 방지하기 위해 2차원 배열 대신 사용
    static int[] resultDis;
    static int[] visit;
    static StringBuilder sb = new StringBuilder();

    static class Node{
        int v;
        int dis;

        public Node(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new int[N + 1];
        resultDis = new int[N + 1];
        Connect = new ArrayList[N+1];

        for(int i=0; i<N+1; i++){
            Connect[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Connect[a].add(b);
            Connect[b].add(a);
        }

        bfs(1);

        int disMax = Integer.MIN_VALUE;
        int count = 0;

        for(int value : resultDis){
            disMax = Math.max(disMax, value);
        }

        for(int i=1; i< resultDis.length; i++){
            if(resultDis[i] == disMax){
                sb.append(i).append(" ");
                sb.append(disMax).append(" ");
                break;
            }
        }

        for (int value : resultDis){
            if(value == disMax)
                count++;
        }

        sb.append(count);
        System.out.println(sb);
    }

    static void bfs(int start){
        Queue<Node> queue = new LinkedList<>();

        visit[start] = 1;
        queue.offer(new Node(start,0));

        while(!queue.isEmpty()){
            Node out = queue.poll();

            for (int value : Connect[out.v]) {
                if(visit[value] != 1){
                    visit[value] = 1;
                    queue.offer(new Node(value, out.dis + 1));
                    resultDis[value] = out.dis + 1;
                }
            }
        }

    }
}
