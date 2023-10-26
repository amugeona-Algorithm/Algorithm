package 지환.week.w15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_4179 {
    /*
    백준 4179
    불
    BFS 두번 돌리기
     */

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static String[][] map;
    private static Queue<Node> fs = new LinkedList<>();
    private static Queue<Node> js = new LinkedList<>();
    private static int[][] jTime;
    private static int[][] fTime;
    private static int R, C;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        jTime = new int[R][C];
        fTime = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                jTime[i][j] = -1;
                fTime[i][j] = -1;
            }
        }

        Node jNode = new Node();


        for (int i = 0; i < R; i++) {
            List<String> collect = Arrays.stream(br.readLine().split("")).collect(Collectors.toUnmodifiableList());
            for (int j = 0; j < C; j++) {
                String temp = collect.get(j);
                if (temp.equals("J")) {
                    js.offer(new Node(i, j));
                }
                if (temp.equals("F")) {
                    fs.offer(new Node(i, j));
                }
                map[i][j] = temp;
            }
        }


        if (jbfs()) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }

    }

    private static int result = 0;

    static boolean jbfs() {

        while (!js.isEmpty()) {

            //불 확산 맵에 찍기. 확산 시간을 찍기 위함.
            int fSize = fs.size();
            for (int i = 0; i < fSize; i++) {
                Node poll = fs.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nr = poll.r + dr[dir];
                    int nc = poll.c + dc[dir];

                    if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                        if (!map[nr][nc].equals("#") && !map[nr][nc].equals("F")) {
                            map[nr][nc] = "F";
                            fs.offer(new Node(nr, nc, poll.time + 1));
                        }
                    }
                }
            }
            int size = js.size();
            for (int i = 0; i < size; i++) {
                Node poll = js.poll();
                for (int dir = 0; dir < 4; dir++) {

                    int nr = poll.r + dr[dir];
                    int nc = poll.c + dc[dir];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                        result = poll.time + 1;
                        return false;
                    }
                    if (!map[nr][nc].equals("#") && !map[nr][nc].equals("F") && !map[nr][nc].equals("J")) {
                        js.add(new Node(nr, nc, poll.time + 1));
                        map[nr][nc] = "J";
                    }
                }
            }
        }
        return true;
    }

    static class Node {
        int r;
        int c;
        int time;

        public Node() {
        }

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}
