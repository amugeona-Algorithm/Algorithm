package 민호.GraphTraversal;

import java.util.*;
import java.io.*;

public class BaekJoon_14502 {
    /**
     * 백준 14502
     * 그래프 탐색 - 연구소
     * Gold 4
     * 3개의 벽 조합하기 -> 임시 지도 복사 -> 임시 지도에서 바이러스 4방향 탐색으로 감염시키기 -> 안전 영역 구하기 -> 조합 반복하며 최댓값 구하기
     */

    static int N, M;
    static int[][] Map;
    static int[] dr = {-1, 1, 0, 0};    //상하좌우 탐색
    static int[] dc = {0, 0, -1, 1};
    static int result = Integer.MIN_VALUE;

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

        Map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0);
        System.out.println(result);
    }

    static void makeWall(int count) {
        if (count == 3) {
            int countSafe = infection();
            result = Math.max(result, countSafe);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Map[i][j] == 0) {
                    Map[i][j] = 1;
                    makeWall(count + 1);
                    Map[i][j] = 0;
                }
            }
        }
    }

    static int infection() {
        int[][] tempMap = copyMap();

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 2)
                    queue.offer(new Node(i, j));
            }
        }

        while (!queue.isEmpty()){
            Node out = queue.poll();
            for(int d=0; d<4; d++){
                int nr = out.r + dr[d];
                int nc = out.c + dc[d];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && tempMap[nr][nc] == 0){ //지도 범위 내 빈칸인 경우
                    tempMap[nr][nc] = 2;    //감염시키기
                    queue.offer(new Node(nr, nc));
                }
            }
        }

        return countSafeZone(tempMap);
    }

    static int countSafeZone(int[][] tempMap) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0)
                    count++;
            }
        }

        return count;
    }

    static int[][] copyMap() {
        int[][] tempMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = Map[i][j];
            }
        }

        return tempMap;
    }
}
