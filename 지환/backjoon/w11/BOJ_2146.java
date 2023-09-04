package 지환.backjoon.w11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BOJ_2146 {
     /*
    백준 2146
    다리 만들
    골드3
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int[][] map;
    private static int N;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static boolean[][] isVisted;
    private static List<List<Land>> lands = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisted = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    lands.add(bfs(i, j));
                }
            }
        }

        int minBridgeDistance = Integer.MAX_VALUE;

        for (int i = 0; i < lands.size(); i++) {
            for (int j = i + 1; j < lands.size(); j++) {
                int bridgeDistance = findMinBridgeDistance(lands.get(i), lands.get(j));
                if (bridgeDistance < minBridgeDistance) {
                    minBridgeDistance = bridgeDistance;
                }
            }
        }

        System.out.println(minBridgeDistance-1);


    }
    private static int findMinBridgeDistance(List<Land> landList1, List<Land> landList2) {
        int minDistance = Integer.MAX_VALUE;

        for (Land land1 : landList1) {
            for (Land land2 : landList2) {
                int distance = calculateDistance(land1, land2);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }

        return minDistance;
    }


    private static int calculateDistance(Land land1, Land land2) {
        int dx = Math.abs(land1.r - land2.r);
        int dy = Math.abs(land1.c - land2.c);
        return dx +dy;
    }
    private static List<Land> bfs(int r, int c) {
        isVisted = new boolean[N][N];
        Queue<Land> queue = new LinkedList<>();
        queue.offer(new Land(r, c));
        isVisted[r][c] = true;
        map[r][c] = 0;
        List<Land> list = new ArrayList<>();
        list.add(new Land(r, c));
        while (!queue.isEmpty()) {
            Land poll = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nr = poll.r + dr[dir];
                int nc = poll.c + dc[dir];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || isVisted[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }
                queue.offer(new Land(nr, nc));
                isVisted[nr][nc] = true;
                list.add(new Land(nr, nc));
            }
        }
        for (Land land : list) {
            map[land.r][land.c] = 0;
        }
        return list;
    }

    static class Land {
        int r;
        int c;

        public Land(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
