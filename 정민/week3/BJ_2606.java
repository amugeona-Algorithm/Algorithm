package 정민.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2606 {
    /*
     * 백준 2606
     * 바이러스
     * 그래프 탐색
     */
    static int N, M, res; // 컴퓨터 수, 쌍 수, 1번 컴퓨터를 통해 걸리는 컴퓨터 수
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) {
        // bfs
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) { // N개의 컴퓨터 공간 생성
            list.add(new ArrayList<>());
        }

        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            list.get(temp1).add(temp2);
            list.get(temp2).add(temp1);
        }
        res = 0;
        calcVirus();
        System.out.println(res);
    }

    public static void calcVirus() {
        // bfs
        Queue<Integer> que = new LinkedList<>();
        boolean[] isVisited = new boolean[N + 1];

        que.add(1);
        isVisited[1] = true;

        while (!que.isEmpty()) {
            int virus = que.poll();
            for (int i = 0; i < list.get(virus).size(); i++) {
                int nextVirus = list.get(virus).get(i);
                if (!isVisited[nextVirus]) {
                    que.add(nextVirus);
                    isVisited[nextVirus] = true;
                    res++;
                }
            }
        }

        return;
    }
}
