package 민호.BruteForce;

import java.util.*;
import java.io.*;

public class BaekJoon_15686 {
    /**
     * 백준 15686
     * 완전 탐색 - 치킨 배달
     * Gold 5
     */

    static int N, M;
    static int[][] city;
    static ArrayList<Node> house = new ArrayList<>();
    static ArrayList<Node> chicken = new ArrayList<>();
    static int[] visit;
    static int result = Integer.MAX_VALUE;

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1)
                    house.add(new Node(i, j));
                else if (city[i][j] == 2)
                    chicken.add(new Node(i, j));
            }
        }

        visit = new int[chicken.size()];
        makeComb(0, 0);
        System.out.println(result);
    }

    static void makeComb(int count, int start) {
        if (count == M) {
            int totalSum = 0;
            for (int i = 0; i < house.size(); i++) {
                int shortDistance = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visit[j] == 1) {              //해당 치킨집이 조합에 포함되어 있는 경우
                        int distance = Math.abs(house.get(i).r - chicken.get(j).r) + Math.abs(house.get(i).c - chicken.get(j).c);
                        shortDistance = Math.min(distance, shortDistance);  //가장 가까운 치킨집까지의 거리
                    }
                }
                totalSum += shortDistance;    //도시의 치킨 거리
            }
            result = Math.min(result, totalSum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (visit[i] != 1) {
                visit[i] = 1;
                makeComb(count + 1, i + 1);
                visit[i] = 0;
            }
        }
    }

}
